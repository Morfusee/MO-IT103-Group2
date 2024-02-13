package GUI.employee;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.toedter.calendar.JTextFieldDateEditor;

import Classes.Compensation;
import Classes.GovernmentIdentification;
import Classes.LeaveRequest;
import GUI.employee.*;
import UtilityClasses.JsonFileHandler;

public class LeaveRequestPage extends JFrame {

	private com.toedter.calendar.JDateChooser endDateField;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTextArea notesField;
	private javax.swing.JLabel leaveRequestLabel;
	private javax.swing.JLabel notesLabel;
	private com.toedter.calendar.JDateChooser startDateField;
	private javax.swing.JButton submitButton;
	private javax.swing.JButton cancelButton;
	private javax.swing.JButton viewRequestsButton;
	private javax.swing.JComboBox<String> typeOfLeaveDropdown;
	private javax.swing.JLabel typeOfLeaveLabel;
	private GovernmentIdentification employeeGI;
	private Compensation employeeComp;

	public LeaveRequestPage(GovernmentIdentification employeeGI, Compensation employeeComp) {
		this.employeeGI = employeeGI;
		this.employeeComp = employeeComp;

		initComponents();
	}

	@SuppressWarnings("unchecked")
	private void initComponents() {

		leaveRequestLabel = new javax.swing.JLabel();
		typeOfLeaveLabel = new javax.swing.JLabel();
		typeOfLeaveDropdown = new javax.swing.JComboBox<>();
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		startDateField = new com.toedter.calendar.JDateChooser();
		endDateField = new com.toedter.calendar.JDateChooser();
		notesLabel = new javax.swing.JLabel();
		jScrollPane1 = new javax.swing.JScrollPane();
		notesField = new javax.swing.JTextArea();
		submitButton = new javax.swing.JButton();
		cancelButton = new javax.swing.JButton();
		viewRequestsButton = new javax.swing.JButton();

		setTitle("MotorPH Payroll System | Submit Leave Request");
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setResizable(false);

		leaveRequestLabel.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
		leaveRequestLabel.setText("Leave Request Form");

		typeOfLeaveLabel.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
		typeOfLeaveLabel.setText("Type of Leave");

		typeOfLeaveDropdown.setModel(new javax.swing.DefaultComboBoxModel<>(
				new String[] { "Sick Leave", "Vacation Leave", "Emergency Leave" }));
		typeOfLeaveDropdown.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				typeOfLeaveDropdownActionPerformed(evt);
			}
		});

		jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
		jLabel1.setText("Start Date");

		jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
		jLabel2.setText("End Date");

		startDateField.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
		startDateField.setPreferredSize(new java.awt.Dimension(126, 22));

		JTextFieldDateEditor startDateFieldEditor = (JTextFieldDateEditor) startDateField.getDateEditor();
		startDateFieldEditor.setEditable(false);

		endDateField.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
		endDateField.setPreferredSize(new java.awt.Dimension(126, 22));

		JTextFieldDateEditor endDateFieldEditor = (JTextFieldDateEditor) endDateField.getDateEditor();
		endDateFieldEditor.setEditable(false);

		notesLabel.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
		notesLabel.setText("Notes");

		notesField.setColumns(20);
		notesField.setRows(5);
		jScrollPane1.setViewportView(notesField);

		submitButton.setText("Submit");
		submitButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				submitButtonActionPerformed(evt);
			}
		});

		cancelButton.setText("Cancel");
		cancelButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				cancelButtonActionPerformed(evt);
			}
		});

		viewRequestsButton.setText("View Requests");
		viewRequestsButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				viewRequestsButtonActionPerformed(evt);
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

	private void typeOfLeaveDropdownActionPerformed(java.awt.event.ActionEvent evt) {

	}

	private void viewRequestsButtonActionPerformed(java.awt.event.ActionEvent evt) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				// Remove the EmployeesPage Window
				dispose();

				try {
					new EmployeeLeaveRequestListPage(employeeGI, employeeComp).setVisible(true);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}

	private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {
		StringBuilder errorMessage = new StringBuilder();

		// Check if all fields are valid
		if (!areAllFieldsValid(errorMessage)) {
			errorDialogPane(errorMessage, "Error");
			return;
		}

		// Write to the json file
		addLeaveRequest();

		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				// Close the dashboard page
				dispose();

				// Back to the employee dashboard page
				new EmployeeDashboard(employeeGI, employeeComp).setVisible(true);
			}
		});
	}

	private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				// Remove the EmployeesPage Window
				dispose();

				new EmployeeDashboard(employeeGI, employeeComp).setVisible(true);
			}
		});
	}

	public void addLeaveRequest() {
		LeaveRequest leaveRequest = new LeaveRequest(employeeGI.getEmployeeNumber());

		// Add the data to the json file
		leaveRequest.setLast_name(employeeGI.getLastName());
		leaveRequest.setFirst_name(employeeGI.getFirstName());
		leaveRequest.setStartDate(startDateField.getDate().toString());
		leaveRequest.setEndDate(endDateField.getDate().toString());
		leaveRequest.setNotes(notesField.getText());
		leaveRequest.setLeave_type(typeOfLeaveDropdown.getSelectedItem().toString());
		leaveRequest.setApproved("Not Approved Yet");

		// Read existing LeaveRequest objects from the file
		List<LeaveRequest> existingLeaveRequests = JsonFileHandler
				.readLeaveRequestsFromFile(JsonFileHandler.getLeaveRequestJsonPath());

		// Add the new LeaveRequest object to the list
		existingLeaveRequests.add(leaveRequest);

		// Write the updated list back to the file
		JsonFileHandler.addToJsonFile(existingLeaveRequests, JsonFileHandler.getLeaveRequestJsonPath());
	}

	private boolean areAllFieldsValid(StringBuilder errorMessage) {
		if (startDateField.getDate() == null || endDateField.getDate() == null) {
			errorMessage.setLength(0); // Clear previous content
			errorMessage.append("Date fields cannot be empty.");
			return false;
		}

		if (startDateField.getDate().compareTo(endDateField.getDate()) > 0) {
			errorMessage.setLength(0); // Clear previous content
			errorMessage.append("Start date cannot be after end date.");
			return false;
		}

		return true;
	}

	private void errorDialogPane(StringBuilder errorMessage, String title) {
		JOptionPane.showMessageDialog(new JFrame(""), errorMessage, title, JOptionPane.ERROR_MESSAGE);
	}

}
