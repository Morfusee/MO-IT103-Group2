package GUI.admin;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.toedter.calendar.JTextFieldDateEditor;

import Classes.Compensation;
import Classes.GovernmentIdentification;
import Classes.LeaveRequest;
import GUI.employee.EmployeeDashboard;
import UtilityClasses.JsonFileHandler;

@SuppressWarnings("serial")
public class LeaveRequestDetailsPage extends JFrame {
	private javax.swing.JLabel endDateField;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTextArea notesField;
	private javax.swing.JLabel leaveRequestLabel;
	private javax.swing.JLabel notesLabel;
	private javax.swing.JLabel startDateField;
	private javax.swing.JButton submitButton;
	private javax.swing.JButton cancelButton;
	private javax.swing.JButton viewRequestsButton;
	private javax.swing.JLabel typeOfLeaveDropdown;
	private javax.swing.JLabel typeOfLeaveLabel;
	private GovernmentIdentification employeeGI;
	private Compensation employeeComp;
	private LeaveRequest leaveRequest;

	public LeaveRequestDetailsPage(GovernmentIdentification employeeGI, Compensation employeeComp,
			LeaveRequest leaveRequest) {
		this.employeeGI = employeeGI;
		this.employeeComp = employeeComp;
		this.leaveRequest = leaveRequest;

		initComponents();
	}

	@SuppressWarnings("unchecked")
	private void initComponents() {

		leaveRequestLabel = new javax.swing.JLabel();
		typeOfLeaveLabel = new javax.swing.JLabel();
		typeOfLeaveDropdown = new javax.swing.JLabel();
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		startDateField = new javax.swing.JLabel();
		endDateField = new javax.swing.JLabel();
		notesLabel = new javax.swing.JLabel();
		jScrollPane1 = new javax.swing.JScrollPane();
		notesField = new javax.swing.JTextArea();
		submitButton = new javax.swing.JButton();
		cancelButton = new javax.swing.JButton();
		viewRequestsButton = new javax.swing.JButton();

		setTitle("MotorPH Payroll System | Leave Request Details");
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setResizable(false);

		leaveRequestLabel.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
		leaveRequestLabel.setText("Leave Request Details");

		typeOfLeaveLabel.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
		typeOfLeaveLabel.setText("Type of Leave");

		typeOfLeaveDropdown.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
		typeOfLeaveDropdown.setText(leaveRequest.getLeave_type());

		jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
		jLabel1.setText("Start Date");

		jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
		jLabel2.setText("End Date");

		startDateField.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
		startDateField.setPreferredSize(new java.awt.Dimension(126, 22));

		try {
			startDateField.setText(new SimpleDateFormat("EEE MMM dd, yyyy")
					.format(new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy").parse(leaveRequest.getStartDate())));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		endDateField.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
		endDateField.setPreferredSize(new java.awt.Dimension(126, 22));

		try {
			endDateField.setText(new SimpleDateFormat("EEE MMM dd, yyyy")
					.format(new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy").parse(leaveRequest.getEndDate())));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		notesLabel.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
		notesLabel.setText("Notes");

		notesField.setColumns(20);
		notesField.setRows(5);
		notesField.setText(leaveRequest.getNotes());
		notesField.setEditable(false);

		jScrollPane1.setViewportView(notesField);

		submitButton.setText("Approve");
		submitButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					approveButtonActionPerformed(evt);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		cancelButton.setText("Cancel");
		cancelButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				cancelButtonActionPerformed(evt);
			}
		});

		viewRequestsButton.setText("Reject");
		viewRequestsButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					rejectButtonActionPerformed(evt);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(29, 29, 29)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
								.addGroup(layout.createSequentialGroup().addComponent(cancelButton)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(viewRequestsButton)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(submitButton))
								.addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(notesLabel, javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(leaveRequestLabel, javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(typeOfLeaveLabel).addComponent(jLabel1)
												.addComponent(jLabel2))
										.addGap(99, 99, 99)
										.addGroup(layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
												.addComponent(typeOfLeaveDropdown, 0, 170, Short.MAX_VALUE)
												.addComponent(startDateField, javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(endDateField, javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
						.addContainerGap(29, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(32, 32, 32).addComponent(leaveRequestLabel)
						.addGap(39, 39, 39)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(typeOfLeaveLabel)
								.addComponent(typeOfLeaveDropdown, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(layout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jLabel1)
								.addComponent(startDateField, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jLabel2).addComponent(endDateField,
										javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18).addComponent(notesLabel)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 95,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(31, 31, 31)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(submitButton).addComponent(cancelButton).addComponent(viewRequestsButton))
						.addContainerGap(32, Short.MAX_VALUE)));

		pack();

		// Put the window in the middle
		setLocationRelativeTo(null);
	}

	private void rejectButtonActionPerformed(java.awt.event.ActionEvent evt) throws IOException {
		// Instantiate error message in case of misinput
		StringBuilder errorMessage = new StringBuilder();

		// Read the JSON file and parse it into a Java object
		JsonArray jsonArrayLeaveRequest = JsonFileHandler.getLeaveRequestJSON();

		// Update a specific entry in the Java object
		String employeeNumToUpdate = leaveRequest.getEmployeeNum();
		String startDate = leaveRequest.getStartDate();
		String endDate = leaveRequest.getEndDate();
		String notes = leaveRequest.getNotes();
		String leaveType = leaveRequest.getLeave_type();

		rejectEntry(jsonArrayLeaveRequest, employeeNumToUpdate, startDate, endDate, notes, leaveType, errorMessage);

		// Convert the Java object back to JSON
		String updatedJson = jsonArrayLeaveRequest.toString();

		// Write the updated JSON back to the file
		JsonFileHandler.writeJsonFile(updatedJson, JsonFileHandler.getLeaveRequestJsonPath());

		// Go back to the employee list page
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				// Remove the UpdateEmployeeDetailsPage Window
				dispose();

				try {
					new LeaveRequestListPage(employeeGI, employeeComp).setVisible(true);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}

	private void approveButtonActionPerformed(java.awt.event.ActionEvent evt) throws IOException {
		// Instantiate error message in case of misinput
		StringBuilder errorMessage = new StringBuilder();

		// Read the JSON file and parse it into a Java object
		JsonArray jsonArrayLeaveRequest = JsonFileHandler.getLeaveRequestJSON();

		// Update a specific entry in the Java object
		String employeeNumToUpdate = leaveRequest.getEmployeeNum();
		String startDate = leaveRequest.getStartDate();
		String endDate = leaveRequest.getEndDate();
		String notes = leaveRequest.getNotes();
		String leaveType = leaveRequest.getLeave_type();

		approveEntry(jsonArrayLeaveRequest, employeeNumToUpdate, startDate, endDate, notes, leaveType, errorMessage);

		// Convert the Java object back to JSON
		String updatedJson = jsonArrayLeaveRequest.toString();

		// Write the updated JSON back to the file
		JsonFileHandler.writeJsonFile(updatedJson, JsonFileHandler.getLeaveRequestJsonPath());

		// Go back to the employee list page
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				// Remove the UpdateEmployeeDetailsPage Window
				dispose();

				try {
					new LeaveRequestListPage(employeeGI, employeeComp).setVisible(true);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}

	private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				// Remove the EmployeesPage Window
				dispose();

				try {
					new LeaveRequestListPage(employeeGI, employeeComp).setVisible(true);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}

	private static boolean approveEntry(JsonArray jsonArray, String employeeNumToUpdate, String startDate,
			String endDate, String notes, String leaveType, StringBuilder errorMessage) {

		for (JsonElement element : jsonArray) {
			if (!element.isJsonObject()) {
				errorMessage.setLength(0); // Clear previous content
				errorMessage.append("Data is not a Json Object.");
				return false;
			}

			JsonObject employeeObject = element.getAsJsonObject();
			if (employeeObject.has("employeeNum") // I'm cooked
					&& employeeObject.get("employeeNum").getAsString().equals(employeeNumToUpdate)
					&& employeeObject.get("startDate").getAsString().equals(startDate)
					&& employeeObject.get("endDate").getAsString().equals(endDate)
					&& employeeObject.get("notes").getAsString().equals(notes)
					&& employeeObject.get("leave_type").getAsString().equals(leaveType)) {

				employeeObject.addProperty("approved", "Approved");

				break; // Break the loop once the entry is updated
			}
		}
		return true;
	}

	private static boolean rejectEntry(JsonArray jsonArray, String employeeNumToUpdate, String startDate,
			String endDate, String notes, String leaveType, StringBuilder errorMessage) {

		for (JsonElement element : jsonArray) {
			if (!element.isJsonObject()) {
				errorMessage.setLength(0); // Clear previous content
				errorMessage.append("Data is not a Json Object.");
				return false;
			}

			JsonObject employeeObject = element.getAsJsonObject();
			if (employeeObject.has("employeeNum") // I'm cooked
					&& employeeObject.get("employeeNum").getAsString().equals(employeeNumToUpdate)
					&& employeeObject.get("startDate").getAsString().equals(startDate)
					&& employeeObject.get("endDate").getAsString().equals(endDate)
					&& employeeObject.get("notes").getAsString().equals(notes)
					&& employeeObject.get("leave_type").getAsString().equals(leaveType)) {

				employeeObject.addProperty("approved", "Rejected");

				break; // Break the loop once the entry is updated
			}
		}
		return true;
	}
}
