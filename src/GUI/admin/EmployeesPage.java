package GUI.admin;

import javax.swing.table.*;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonWriter;

import Classes.Compensation;
import Classes.EmployeeInformation;
import Classes.GovernmentIdentification;
import UtilityClasses.JsonFileHandler;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

import javax.swing.*;

@SuppressWarnings("serial")
public class EmployeesPage extends JFrame {

	private JScrollPane jScrollPane1;
	private JButton jButton1;
	private JTable jTable1;
	private int numberOfColumns = 9;
	private JButton addEmployeeButton;
	private JButton deleteEmployeeButton;
	private int selectedRow;

	// Instantiate two of the user's important information
	GovernmentIdentification employeeGI;
	Compensation employeeComp;

	public EmployeesPage() {
		initComponents();
		loadEmployeeData();
	}

	private void initComponents() {

		// Set JFrame
		setTitle("MotorPH Payroll System | Employee List");
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setResizable(false);

		// Instantiate Table
		jTable1 = new JTable();

		addEmployeeButton = new JButton();
		deleteEmployeeButton = new JButton();

		// Instantiate Button Component
		jButton1 = new JButton();
		jButton1.setText("Go Back to Dashboard");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		// Create an empty default table model
		DefaultTableModel model = new DefaultTableModel(new Object[][] {}, new String[] { "Employee Number",
				"Last Name", "First Name", "SSS No.", "PhilHealth No.", "TIN", "Pagibig No.", "", "", "" }) {
			@Override
			public Class<?> getColumnClass(int columnIndex) {
				// Return the appropriate class for the last column (column with buttons)
				return (columnIndex == getColumnCount() - 1) || (columnIndex == getColumnCount() - 2) ? JButton.class
						: Object.class;
			}

			@Override
			public boolean isCellEditable(int row, int column) {
				// Allow editing only for the last column
				return column == getColumnCount() - 1 || column == getColumnCount() - 2
						|| column == getColumnCount() - 3;
			}
		};

		// Modify Table Row Height
		jTable1 = new JTable(model);
		jTable1.setRowHeight(30);

		// Modify the width of the first column
		TableColumn firstColumn = jTable1.getColumnModel().getColumn(0);
		firstColumn.setPreferredWidth(90); // Set your preferred width here

		// Modify the width of the last column
		TableColumn lastColumn = jTable1.getColumnModel().getColumn(numberOfColumns);
		lastColumn.setPreferredWidth(50); // Set your preferred width here

		// Modify the width of the last column
		TableColumn editColumn = jTable1.getColumnModel().getColumn(numberOfColumns - 2);
		editColumn.setPreferredWidth(40); // Set your preferred width here

		// Modify the width of the last column
		TableColumn deleteColumn = jTable1.getColumnModel().getColumn(numberOfColumns - 1);
		deleteColumn.setPreferredWidth(100); // Set your preferred width here

		// Set a custom renderer and editor for the Edit Column
		jTable1.getColumnModel().getColumn(model.getColumnCount() - 1).setCellRenderer(new ButtonRenderer("Delete"));
		jTable1.getColumnModel().getColumn(model.getColumnCount() - 1)
				.setCellEditor(new ButtonEditor(0, "Delete", "DeleteDialogPane"));

		// Set a custom renderer and editor for the View Employee column
		jTable1.getColumnModel().getColumn(model.getColumnCount() - 2)
				.setCellRenderer(new ButtonRenderer("View Employee"));
		jTable1.getColumnModel().getColumn(model.getColumnCount() - 2)
				.setCellEditor(new ButtonEditor(0, "View Employee", "FullEmployeeDetailsPage"));

		// Set a custom renderer and editor for the Edit Column
		jTable1.getColumnModel().getColumn(model.getColumnCount() - 3).setCellRenderer(new ButtonRenderer("Edit"));
		jTable1.getColumnModel().getColumn(model.getColumnCount() - 3)
				.setCellEditor(new ButtonEditor(0, "Edit", "UpdateEmployeeDetailsPage"));

		// Set custom renderer for the header cells to make them bold
		JTableHeader header = jTable1.getTableHeader();
		header.setDefaultRenderer(new BoldHeaderRenderer(header.getDefaultRenderer()));

		jScrollPane1 = new JScrollPane(jTable1);

		addEmployeeButton.setText("Add");
		addEmployeeButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				addEmployeeButtonActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 996, Short.MAX_VALUE)
								.addGroup(layout.createSequentialGroup().addComponent(jButton1)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(addEmployeeButton)))
						.addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				javax.swing.GroupLayout.Alignment.TRAILING,
				layout.createSequentialGroup().addContainerGap(13, Short.MAX_VALUE)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jButton1).addComponent(addEmployeeButton))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 428,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));

		pack();

		// Make the window appear in the middle
		setLocationRelativeTo(null);
	}

	private void loadEmployeeData() {
		try {
			// Read the JSON file and parse it using GSON
			FileReader reader = new FileReader(JsonFileHandler.getEmployeesJsonPath());
			JsonArray jsonArray = JsonParser.parseReader(reader).getAsJsonArray();

			// Iterate through the JSON array and add data to the table model
			DefaultTableModel model = (DefaultTableModel) ((JTable) jScrollPane1.getViewport().getView()).getModel();
			Gson gson = new Gson();

			for (int i = 0; i < jsonArray.size(); i++) {
				JsonObject jsonObject = jsonArray.get(i).getAsJsonObject();
				GovernmentIdentification employee = gson.fromJson(jsonObject, GovernmentIdentification.class);

				// Add the data to the table model
				model.addRow(new Object[] { employee.getEmployeeNumber(), employee.getLastName(),
						employee.getFirstName(), employee.getSSSNumber(), employee.getPhilHealthNumber(),
						employee.getTinNumber(), employee.getPagibigNumber(), "View" });
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Click event of Go Back to Dashboard Button
	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				// Remove the EmployeesPage Window
				dispose();

				// Go back to the dashboard page
				new DashboardPage().setVisible(true);
			}
		});
	}

	private void addEmployeeButtonActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void deleteEmployeeButtonActionPerformed(String employeeNumToRemove) throws IOException {
		JsonArray jsonArray = JsonFileHandler.getEmployeesJSON();

		// Remove the object
		removeJsonObject(jsonArray, "employeeNum", employeeNumToRemove);

		// Write the modified JsonArray back to the JSON file
		writeJsonFile(jsonArray, JsonFileHandler.getEmployeesJsonPath());

		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				// Remove the EmployeesPage Window
				dispose();

				// Refresh the Employees Page
				new EmployeesPage().setVisible(true);
			}
		});

	}

	private static void removeJsonObject(JsonArray jsonArray, String key, String value) {
		Iterator<JsonElement> iterator = jsonArray.iterator();
		while (iterator.hasNext()) {
			JsonElement element = iterator.next();
			if (element.isJsonObject()) {
				JsonObject jsonObject = element.getAsJsonObject();
				if (jsonObject.has(key) && jsonObject.get(key).getAsString().equals(value)) {
					iterator.remove(); // Remove the object from the JsonArray
					break; // Assuming there is only one object with the specified value
				}
			}
		}
	}

	private static void writeJsonFile(JsonArray jsonArray, String filePath) {
		try (JsonWriter writer = new JsonWriter(new FileWriter(filePath))) {
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			gson.toJson(jsonArray, writer);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Custom on-render look for the button column
	private class ButtonRenderer extends JButton implements TableCellRenderer {
		private String buttonLabel;

		public ButtonRenderer(String buttonLabel) {
			this.buttonLabel = buttonLabel;
			setOpaque(true);
		}

		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			setText(buttonLabel);
			return this;
		}
	}

	// Custom click-event look for the button column
	private class ButtonEditor extends AbstractCellEditor implements TableCellEditor {
		private JButton button;
		private int targetColumn;
		private String buttonLabel;

		public ButtonEditor(int targetColumn, String buttonLabel, String page) {
			this.targetColumn = targetColumn;
			this.buttonLabel = buttonLabel;
			button = new JButton(this.buttonLabel);
			button.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					java.awt.EventQueue.invokeLater(new Runnable() {
						public void run() {
							if (!page.equals("DeleteDialogPane"))
								dispose();

							// Check what page to go to
							switch (page) {
							case "FullEmployeeDetailsPage":
								// Go to the employees information page
								new FullEmployeeDetailsPage(employeeGI, employeeComp).setVisible(true);
								break;
							case "UpdateEmployeeDetailsPage":
								// Go to the employees information page
								new UpdateEmployeeDetailsPage(employeeGI, employeeComp).setVisible(true);
								break;
							case "DeleteDialogPane":
								// Display a confirmation dialog
								int result = JOptionPane.showConfirmDialog(null, "Do you want to proceed?",
										"Confirmation", JOptionPane.YES_NO_OPTION);

								// Check the user's choice
								if (result == JOptionPane.YES_OPTION) {
									try {
										deleteEmployeeButtonActionPerformed(
												jTable1.getValueAt(selectedRow, targetColumn).toString());
										System.out.println(jTable1.getValueAt(selectedRow, targetColumn).toString());
									} catch (IOException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
								}
								break;
							default:
								new FullEmployeeDetailsPage(employeeGI, employeeComp).setVisible(true);
								break;
							}

						}
					});
				}
			});
		}

		@Override
		public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
				int column) {

			// Call constructor
			employeeGI = new GovernmentIdentification(jTable1.getValueAt(row, targetColumn).toString());
			employeeComp = new Compensation(jTable1.getValueAt(row, targetColumn).toString());

			selectedRow = row;

			// Set all the important information to be passed
			try {
				setEmployeeInformationObject(jTable1.getValueAt(row, targetColumn).toString());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return button;
		}

		@Override
		public Object getCellEditorValue() {
			return "View";
		}
	}

	// Make the column headers bold
	private static class BoldHeaderRenderer implements TableCellRenderer {

		private final TableCellRenderer defaultRenderer;

		public BoldHeaderRenderer(TableCellRenderer defaultRenderer) {
			this.defaultRenderer = defaultRenderer;
		}

		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			Component c = defaultRenderer.getTableCellRendererComponent(table, value, isSelected, hasFocus, row,
					column);

			if (c instanceof JLabel) {
				JLabel label = (JLabel) c;
				Font font = label.getFont();
				label.setFont(font.deriveFont(font.getStyle() | Font.BOLD));
			}

			return c;
		}
	}

	public void setEmployeeInformationObject(String employeeNumber) throws IOException {

		// Iterate through the JSON file for the employee data
		JsonObject employeeData = JsonFileHandler.nameIterator(JsonFileHandler.getEmployeesJSON(), "employeeNum",
				employeeNumber);

		// Instantiate Gson to get their Json counterparts
		Gson gson = new Gson();
		GovernmentIdentification employeeGovInfo = gson.fromJson(employeeData, GovernmentIdentification.class);
		Compensation employeeCompInfo = gson.fromJson(employeeData, Compensation.class);

		// Set the employee's identity information
		employeeGI.setLastName(employeeGovInfo.getLastName());
		employeeGI.setFirstName(employeeGovInfo.getFirstName());
		employeeGI.setBirthday(employeeGovInfo.getBirthday());
		employeeGI.setAddress(employeeGovInfo.getAddress());
		employeeGI.setPhoneNumber(employeeGovInfo.getPhoneNumber());
		employeeGI.setImmediateSupervisor(employeeGovInfo.getImmediateSupervisor());
		employeeGI.setStatus(employeeGovInfo.getStatus());
		employeeGI.setPosition(employeeGovInfo.getPosition());

		// Set Government Identification data of Employee
		employeeGI.setSSSNumber(employeeGovInfo.getSSSNumber());
		employeeGI.setPhilHealthNumber(employeeGovInfo.getPhilHealthNumber());
		employeeGI.setPagibigNumber(employeeGovInfo.getPagibigNumber());
		employeeGI.setTinNumber(employeeGovInfo.getTinNumber());

		// Set Compensation data of Employee
		employeeComp.setBasicSalary(employeeCompInfo.getBasicSalary());
		employeeComp.setClothingAllowance(employeeCompInfo.getClothingAllowance());
		employeeComp.setGrossSemiMonthlyRate(employeeCompInfo.getGrossSemiMonthlyRate());
		employeeComp.setPhoneAllowance(employeeCompInfo.getPhoneAllowance());
		employeeComp.setRiceSubsidy(employeeCompInfo.getRiceSubsidy());
		employeeComp.setHourlyRate(employeeCompInfo.getHourlyRate());
	}
}
