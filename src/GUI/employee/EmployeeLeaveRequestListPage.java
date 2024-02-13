package GUI.employee;

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
import Classes.LeaveRequest;
import UtilityClasses.JsonFileHandler;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Iterator;

import javax.swing.*;

@SuppressWarnings("serial")
public class EmployeeLeaveRequestListPage extends JFrame {

	private JScrollPane jScrollPane1;
	private JButton goBackButton;
	private JTable jTable1;
	private int numberOfColumns = 5;
	private JButton addEmployeeButton;
	private JButton deleteEmployeeButton;
	private int selectedRow;
	private String employeeNum;

	// Instantiate two of the user's important information
	GovernmentIdentification employeeGI;
	Compensation employeeComp;
	LeaveRequest leaveRequest;

	public EmployeeLeaveRequestListPage(GovernmentIdentification employeeGI, Compensation employeeComp)
			throws ParseException {
		this.employeeGI = employeeGI;
		this.employeeComp = employeeComp;
		initComponents();
		loadEmployeeData();
	}

	private void initComponents() {

		// Set JFrame
		setTitle("MotorPH Payroll System | Leave Requests");
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setResizable(false);

		// Instantiate Table
		jTable1 = new JTable();

		addEmployeeButton = new JButton();
		deleteEmployeeButton = new JButton();

		// Instantiate Button Component
		goBackButton = new JButton();
		goBackButton.setText("Go Back to Leave Request Page");
		goBackButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				goBackButtonActionPerformed(evt);
			}
		});

		// Create an empty default table model
		DefaultTableModel model = new DefaultTableModel(new Object[][] {},
				new String[] { "ID", "Employee Number", "Start Date", "End Date", "Status", "Leave Type", "" }) {
			@Override
			public Class<?> getColumnClass(int columnIndex) {
				// Return the appropriate class for the last column (column with buttons)
				return (columnIndex == getColumnCount() - 1) || (columnIndex == getColumnCount() - 2) ? JButton.class
						: Object.class;
			}

			@Override
			public boolean isCellEditable(int row, int column) {
				// Allow editing only for the last column
				return column == getColumnCount() - 1;
			}
		};

		// Modify Table Row Height
		jTable1 = new JTable(model);
		jTable1.setRowHeight(30);

		// Modify the width of the first column
		TableColumn firstColumn = jTable1.getColumnModel().getColumn(0);
		firstColumn.setMinWidth(0);
		firstColumn.setMaxWidth(0);

		// Modify the width of the second column
		TableColumn secondColumn = jTable1.getColumnModel().getColumn(1);
		secondColumn.setPreferredWidth(90); // Set your preferred width here

		// Modify the width of the last column
		TableColumn lastColumn = jTable1.getColumnModel().getColumn(numberOfColumns);
		lastColumn.setPreferredWidth(50); // Set your preferred width here

		// Set a custom renderer and editor for the Edit Column
		jTable1.getColumnModel().getColumn(model.getColumnCount() - 1).setCellRenderer(new ButtonRenderer("Delete"));
		jTable1.getColumnModel().getColumn(model.getColumnCount() - 1)
				.setCellEditor(new ButtonEditor(1, "Delete", "DeleteDialogPane"));

		// Set custom renderer for the header cells to make them bold
		JTableHeader header = jTable1.getTableHeader();
		header.setDefaultRenderer(new BoldHeaderRenderer(header.getDefaultRenderer()));

		jScrollPane1 = new JScrollPane(jTable1);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 996, Short.MAX_VALUE)
								.addGroup(layout.createSequentialGroup().addComponent(goBackButton).addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
						.addContainerGap(13, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				javax.swing.GroupLayout.Alignment.TRAILING,
				layout.createSequentialGroup().addContainerGap(13, Short.MAX_VALUE)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(goBackButton))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 428,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));

		pack();

		// Make the window appear in the middle
		setLocationRelativeTo(null);
	}

	private void loadEmployeeData() throws ParseException {
		try {
			// Read the JSON file and parse it using GSON
			FileReader reader = new FileReader(JsonFileHandler.getLeaveRequestJsonPath());
			JsonElement jsonElement = JsonParser.parseReader(reader);

			// Check if the parsed JSON is an array
			if (!jsonElement.isJsonArray()) {
				return;
			}

			JsonArray jsonArray = jsonElement.getAsJsonArray();

			// Check if the JSON array is empty
			if (jsonArray.size() == 0) {
				// Handle the case when the array is empty by creating an empty JSON array
				jsonArray = new JsonArray();
			}

			// Iterate through the JSON array and add data to the table model
			DefaultTableModel model = (DefaultTableModel) ((JTable) jScrollPane1.getViewport().getView()).getModel();
			Gson gson = new Gson();

			// Auto increment employeeNum for record creation
			employeeNum = String.valueOf(jsonArray.size() > 0
					? jsonArray.get(jsonArray.size() - 1).getAsJsonObject().get("employeeNum").getAsInt() + 1
					: 1);

			// Loop through the JSON array
			for (int i = 0; i < jsonArray.size(); i++) {
				JsonObject jsonObject = jsonArray.get(i).getAsJsonObject();
				LeaveRequest leaveRequests = gson.fromJson(jsonObject, LeaveRequest.class);

				// Only show records that belong to this employee
				if (jsonObject.get("employeeNum").getAsString().equals(employeeGI.getEmployeeNumber())) {

					// Format the start date so it doesn't show the time
					String formattedStartDate = new SimpleDateFormat("EEE MMM dd, yyyy").format(
							new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy").parse(leaveRequests.getStartDate()));

					String formattedEndDate = new SimpleDateFormat("EEE MMM dd, yyyy").format(
							new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy").parse(leaveRequests.getEndDate()));

					// Add the data to the table model
					model.addRow(new Object[] { leaveRequests.getId(), leaveRequests.getEmployeeNum(),
							formattedStartDate, formattedEndDate, leaveRequests.isApproved(),
							leaveRequests.getLeave_type(), "View", "View" });
				}

			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Click event of Go Back to leave request page Button
	private void goBackButtonActionPerformed(java.awt.event.ActionEvent evt) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				// Remove the leave request list Window
				dispose();

				// Go back to the leave request page
				new LeaveRequestPage(employeeGI, employeeComp).setVisible(true);
			}
		});
	}

	private void deleteLeaveEntry(String value) throws IOException {
		JsonArray jsonArray = JsonFileHandler.getLeaveRequestJSON();

		// Instantiate gson class
		Gson gson = new GsonBuilder().setPrettyPrinting().create();

		// Remove the object
		JsonFileHandler.removeJsonObject(jsonArray, "id", value);

		// Write the modified JsonArray back to the JSON file
		JsonFileHandler.writeJsonFile(gson.toJson(jsonArray), JsonFileHandler.getLeaveRequestJsonPath());
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
							case "DeleteDialogPane":
								// Display a confirmation dialog
								int result = JOptionPane.showConfirmDialog(null, "Do you want to proceed?",
										"Confirmation", JOptionPane.YES_NO_OPTION);

								// Check the user's choice
								if (result == JOptionPane.YES_OPTION) {
									try {
										performDeleteOperation(targetColumn);
										dispose();
										navigateToLeaveRequestListPage();
									} catch (IOException | ParseException e) {
										e.printStackTrace();
										// Handle or log the exception as needed
									}
								}
								break;
							default:
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
			leaveRequest = new LeaveRequest(jTable1.getValueAt(row, targetColumn).toString());

			selectedRow = row;

			// Set all the important information to be passed
			try {
				EmployeeInformation.setEmployeeInformationObject(jTable1.getValueAt(row, targetColumn).toString(),
						employeeGI, employeeComp);
				LeaveRequest.setLeaveRequestInformationObject(jTable1.getValueAt(row, targetColumn - 1).toString(),
						leaveRequest);
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

	private void performDeleteOperation(int targetColumn) throws IOException {
		deleteLeaveEntry(jTable1.getValueAt(selectedRow, targetColumn - 1).toString());
	}

	private void navigateToLeaveRequestListPage() throws ParseException {
		new EmployeeLeaveRequestListPage(employeeGI, employeeComp).setVisible(true);
	}
}
