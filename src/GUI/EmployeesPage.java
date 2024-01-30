package GUI;

import javax.swing.table.*;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.annotations.SerializedName;

import Classes.EmployeeInformation;
import Classes.GovernmentIdentification;
import UtilityClasses.JsonFileHandler;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.*;

@SuppressWarnings("serial")
public class EmployeesPage extends JFrame {

	JScrollPane jScrollPane1;
	JButton jButton1;

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
		JTable jTable1 = new JTable();

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
				"Last Name", "First Name", "SSS No.", "PhilHealth No.", "TIN", "Pagibig No.", "" }) {
			@Override
			public Class<?> getColumnClass(int columnIndex) {
				// Return the appropriate class for the last column (column with buttons)
				return columnIndex == getColumnCount() - 1 ? JButton.class : Object.class;
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

		// Set a custom renderer and editor for the last column
		jTable1.getColumnModel().getColumn(model.getColumnCount() - 1).setCellRenderer(new ButtonRenderer());
		jTable1.getColumnModel().getColumn(model.getColumnCount() - 1).setCellEditor(new ButtonEditor());

		// Set custom renderer for the header cells to make them bold
		JTableHeader header = jTable1.getTableHeader();
		header.setDefaultRenderer(new BoldHeaderRenderer(header.getDefaultRenderer()));

		jScrollPane1 = new JScrollPane(jTable1);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup().addContainerGap()
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 996, Short.MAX_VALUE)
						.addGroup(layout.createSequentialGroup().addComponent(jButton1).addGap(0, 0, Short.MAX_VALUE)))
				.addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				javax.swing.GroupLayout.Alignment.TRAILING,
				layout.createSequentialGroup().addContainerGap(13, Short.MAX_VALUE).addComponent(jButton1)
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

	// Custom on-render look for the button column
	private class ButtonRenderer extends JButton implements TableCellRenderer {
		public ButtonRenderer() {
			setOpaque(true);
		}

		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			setText("View Employee");
			return this;
		}
	}

	// Custom click-event look for the button column
	private class ButtonEditor extends AbstractCellEditor implements TableCellEditor {
		private JButton button;

		public ButtonEditor() {
			button = new JButton("View Employee");
			button.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// Handle button click event
					JOptionPane.showMessageDialog(null, "Button Clicked!");
				}
			});
		}

		@Override
		public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
				int column) {
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
}
