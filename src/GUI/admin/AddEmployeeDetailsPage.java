package GUI.admin;

import java.awt.Dimension;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import Classes.Compensation;
import Classes.GovernmentIdentification;
import UtilityClasses.CustomTooltip;
import UtilityClasses.DataValidators;
import UtilityClasses.JsonFileHandler;

public class AddEmployeeDetailsPage extends JFrame {

	// Variables declaration - do not modify
	private static javax.swing.JTextField addressField;
	private javax.swing.JLabel addressLabel;
	private static javax.swing.JTextField basicSalaryField;
	private javax.swing.JLabel basicSalaryLabel;
	private static javax.swing.JTextField birthdayField;
	private javax.swing.JLabel birthdayLabel;
	private static javax.swing.JTextField clothingAllowanceField;
	private javax.swing.JLabel clothingAllowanceLabel;
	private static javax.swing.JTextField employeeNumberField;
	private javax.swing.JLabel employeeNumberLabel;
	private static javax.swing.JTextField firstNameField;
	private javax.swing.JLabel firstNameLabel;
	private javax.swing.JButton goBackToEmployeeListButton;
	private static javax.swing.JTextField grossSemiMonthlyRateField;
	private javax.swing.JLabel grossSemiMonthlyRateLabel;
	private static javax.swing.JTextField hourlyRateField;
	private javax.swing.JLabel hourlyRateLabel;
	private static javax.swing.JTextField immediateSupervisorField;
	private javax.swing.JLabel immediateSupervisorLabel;
	private javax.swing.JButton confirmButton;
	private javax.swing.JPanel jPanel3;
	private static javax.swing.JTextField lastNameField;
	private javax.swing.JLabel lastNameLabel;
	private static javax.swing.JTextField pagibigField;
	private javax.swing.JLabel pagibigLabel;
	private static javax.swing.JTextField philhealthField;
	private javax.swing.JLabel philhealthLabel;
	private static javax.swing.JTextField phoneAllowanceField;
	private javax.swing.JLabel phoneAllowanceLabel;
	private static javax.swing.JTextField phoneNumberField;
	private javax.swing.JLabel phoneNumberLabel;
	private static javax.swing.JTextField positionField;
	private javax.swing.JLabel positionLabel;
	private static javax.swing.JTextField riceSubsidyField;
	private javax.swing.JLabel riceSubsidyLabel;
	private static javax.swing.JTextField sssField;
	private javax.swing.JLabel sssLabel;
	private static javax.swing.JTextField statusField;
	private javax.swing.JLabel statusLabel;
	private static javax.swing.JTextField tinField;
	private javax.swing.JLabel tinLabel;
	// End of variables declaration

	public AddEmployeeDetailsPage(String employeeNum) {
		initComponents(employeeNum);
	}

	private void initComponents(String employeeNum) {

		goBackToEmployeeListButton = new javax.swing.JButton();
		jPanel3 = new javax.swing.JPanel();
		grossSemiMonthlyRateField = new javax.swing.JTextField();
		hourlyRateLabel = new javax.swing.JLabel();
		basicSalaryLabel = new javax.swing.JLabel();
		tinLabel = new javax.swing.JLabel();
		birthdayField = new javax.swing.JTextField();
		positionField = new javax.swing.JTextField();
		firstNameField = new javax.swing.JTextField();
		phoneAllowanceLabel = new javax.swing.JLabel();
		statusField = new javax.swing.JTextField();
		confirmButton = new javax.swing.JButton();
		immediateSupervisorField = new javax.swing.JTextField();
		positionLabel = new javax.swing.JLabel();
		basicSalaryField = new javax.swing.JTextField();
		addressLabel = new javax.swing.JLabel();
		pagibigField = new javax.swing.JTextField();
		immediateSupervisorLabel = new javax.swing.JLabel();
		employeeNumberLabel = new javax.swing.JLabel();
		grossSemiMonthlyRateLabel = new javax.swing.JLabel();
		hourlyRateField = new javax.swing.JTextField();
		phoneNumberField = new javax.swing.JTextField();
		philhealthField = new javax.swing.JTextField();
		sssLabel = new javax.swing.JLabel();
		riceSubsidyField = new javax.swing.JTextField();
		statusLabel = new javax.swing.JLabel();
		riceSubsidyLabel = new javax.swing.JLabel();
		sssField = new javax.swing.JTextField();
		lastNameField = new javax.swing.JTextField();
		birthdayLabel = new javax.swing.JLabel();
		firstNameLabel = new javax.swing.JLabel();
		phoneAllowanceField = new javax.swing.JTextField();
		pagibigLabel = new javax.swing.JLabel();
		phoneNumberLabel = new javax.swing.JLabel();
		employeeNumberField = new javax.swing.JTextField();
		addressField = new javax.swing.JTextField();
		philhealthLabel = new javax.swing.JLabel();
		lastNameLabel = new javax.swing.JLabel();
		tinField = new javax.swing.JTextField();
		clothingAllowanceField = new javax.swing.JTextField();
		clothingAllowanceLabel = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		setResizable(false);
		setTitle("MotorPH Payroll System | Add Employee");

		goBackToEmployeeListButton.setText("Go Back to Employee List");
		goBackToEmployeeListButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					goBackToEmployeeListButtonActionPerformed(evt);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		employeeNumberField.setText(employeeNum);

		// Set preferred size for all the fields
		addressField.setPreferredSize(new Dimension(164, 22));

		// Set the employeeNumber to uneditable
		employeeNumberField.setEditable(false);
		employeeNumberField.setEnabled(false);

		jPanel3.setBackground(new java.awt.Color(204, 204, 204));
		jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

		hourlyRateLabel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
		hourlyRateLabel.setText("Hourly Rate");

		basicSalaryLabel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
		basicSalaryLabel.setText("Basic Salary");

		tinLabel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
		tinLabel.setText("TIN Number");

		phoneAllowanceLabel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
		phoneAllowanceLabel.setText("Phone Allowance");

		confirmButton.setText("Confirm");
		confirmButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					confirmButtonActionPerformed(evt);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		positionLabel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
		positionLabel.setText("Position");

		addressLabel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
		addressLabel.setText("Address");

		immediateSupervisorLabel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
		immediateSupervisorLabel.setText("Immediate Supervisor");

		employeeNumberLabel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
		employeeNumberLabel.setText("Employee Number");

		grossSemiMonthlyRateLabel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
		grossSemiMonthlyRateLabel.setText("Gross Semi-Monthly Rate");

		sssLabel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
		sssLabel.setText("SSS Number");

		statusLabel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
		statusLabel.setText("Status");

		riceSubsidyLabel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
		riceSubsidyLabel.setText("Rice Subsidy");

		birthdayLabel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
		birthdayLabel.setText("Birthday");

		firstNameLabel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
		firstNameLabel.setText("First Name");

		pagibigLabel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
		pagibigLabel.setText("Pag-ibig Number");

		phoneNumberLabel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
		phoneNumberLabel.setText("Phone Number");

		philhealthLabel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
		philhealthLabel.setText("PhilHealth Number");

		lastNameLabel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
		lastNameLabel.setText("Last Name");

		clothingAllowanceLabel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
		clothingAllowanceLabel.setText("Clothing Allowance");

		/*************************/
		/* Custom tooltip events */
		/*************************/

		// Phone number tooltip
		String phoneNumberTooltip = "Accepted format: xxx-xxx-xxx";

		phoneNumberField.addCaretListener(new CaretListener() {
			@Override
			public void caretUpdate(CaretEvent e) {
				CustomTooltip.showCustomTooltip(phoneNumberField, phoneNumberTooltip);
			}
		});

		phoneNumberField.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				// Show the tooltip when the component gains focus
				CustomTooltip.showCustomTooltip(phoneNumberField, phoneNumberTooltip);
			}

			@Override
			public void focusLost(FocusEvent e) {
				// Hide the tooltip when the component loses focus
				CustomTooltip.hideCustomTooltip();
			}
		});

		// SSS tooltip
		String sssTooltip = "Accepted format: xx-xxxxxxx-x";

		sssField.addCaretListener(new CaretListener() {
			@Override
			public void caretUpdate(CaretEvent e) {
				CustomTooltip.showCustomTooltip(sssField, sssTooltip);
			}
		});

		sssField.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				// Show the tooltip when the component gains focus
				CustomTooltip.showCustomTooltip(sssField, sssTooltip);
			}

			@Override
			public void focusLost(FocusEvent e) {
				// Hide the tooltip when the component loses focus
				CustomTooltip.hideCustomTooltip();
			}
		});

		// PhilHealth tooltip
		String philhealthTooltip = "Max Length: 12";

		philhealthField.addCaretListener(new CaretListener() {
			@Override
			public void caretUpdate(CaretEvent e) {
				CustomTooltip.showCustomTooltip(philhealthField, philhealthTooltip);
			}
		});

		philhealthField.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				// Show the tooltip when the component gains focus
				CustomTooltip.showCustomTooltip(philhealthField, philhealthTooltip);
			}

			@Override
			public void focusLost(FocusEvent e) {
				// Hide the tooltip when the component loses focus
				CustomTooltip.hideCustomTooltip();
			}
		});

		// TIN tooltip
		String tinTooltip = "Accepted format: xxx-xxx-xxx-xxx";

		tinField.addCaretListener(new CaretListener() {
			@Override
			public void caretUpdate(CaretEvent e) {
				CustomTooltip.showCustomTooltip(tinField, tinTooltip);
			}
		});

		tinField.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				// Show the tooltip when the component gains focus
				CustomTooltip.showCustomTooltip(tinField, tinTooltip);
			}

			@Override
			public void focusLost(FocusEvent e) {
				// Hide the tooltip when the component loses focus
				CustomTooltip.hideCustomTooltip();
			}
		});

		// Pagibig tooltip
		String pagibigTooltip = "Max Length: 12";

		pagibigField.addCaretListener(new CaretListener() {
			@Override
			public void caretUpdate(CaretEvent e) {
				CustomTooltip.showCustomTooltip(pagibigField, pagibigTooltip);
			}
		});

		pagibigField.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				// Show the tooltip when the component gains focus
				CustomTooltip.showCustomTooltip(pagibigField, pagibigTooltip);
			}

			@Override
			public void focusLost(FocusEvent e) {
				// Hide the tooltip when the component loses focus
				CustomTooltip.hideCustomTooltip();
			}
		});

		// Birthday tooltip
		String birthdayTooltip = "Accepted format: MM/dd/yyyy";

		birthdayField.addCaretListener(new CaretListener() {
			@Override
			public void caretUpdate(CaretEvent e) {
				CustomTooltip.showCustomTooltip(birthdayField, birthdayTooltip);
			}
		});

		birthdayField.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				// Show the tooltip when the component gains focus
				CustomTooltip.showCustomTooltip(birthdayField, birthdayTooltip);
			}

			@Override
			public void focusLost(FocusEvent e) {
				// Hide the tooltip when the component loses focus
				CustomTooltip.hideCustomTooltip();
			}
		});

		javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
		jPanel3.setLayout(jPanel3Layout);
		jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel3Layout.createSequentialGroup().addGap(36, 36, 36).addGroup(jPanel3Layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(firstNameField)
						.addComponent(employeeNumberField).addComponent(birthdayField).addComponent(addressField)
						.addGroup(jPanel3Layout.createSequentialGroup()
								.addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(addressLabel).addComponent(birthdayLabel)
										.addComponent(lastNameLabel).addComponent(firstNameLabel)
										.addComponent(employeeNumberLabel))
								.addGap(0, 49, Short.MAX_VALUE))
						.addComponent(lastNameField)).addGap(44, 44, 44)
						.addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addComponent(phoneNumberLabel).addComponent(sssLabel).addComponent(sssField)
								.addComponent(philhealthLabel).addComponent(philhealthField).addComponent(tinLabel)
								.addComponent(tinField).addComponent(pagibigLabel).addComponent(pagibigField)
								.addComponent(phoneNumberField, javax.swing.GroupLayout.PREFERRED_SIZE, 163,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(44, 44, 44)
						.addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addComponent(statusLabel).addComponent(positionLabel).addComponent(positionField)
								.addComponent(immediateSupervisorLabel).addComponent(immediateSupervisorField)
								.addComponent(basicSalaryLabel).addComponent(basicSalaryField)
								.addComponent(riceSubsidyLabel).addComponent(riceSubsidyField).addComponent(statusField,
										javax.swing.GroupLayout.PREFERRED_SIZE, 163,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(44, 44, 44)
						.addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addComponent(phoneAllowanceLabel).addComponent(clothingAllowanceLabel)
								.addComponent(clothingAllowanceField).addComponent(hourlyRateLabel)
								.addComponent(hourlyRateField)
								.addComponent(confirmButton, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(phoneAllowanceField, javax.swing.GroupLayout.PREFERRED_SIZE, 163,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGroup(jPanel3Layout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
										.addComponent(grossSemiMonthlyRateField,
												javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(grossSemiMonthlyRateLabel,
												javax.swing.GroupLayout.Alignment.LEADING,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
						.addGap(36, 36, 36)));
		jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel3Layout.createSequentialGroup().addContainerGap()
						.addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(employeeNumberLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(phoneNumberLabel).addComponent(statusLabel)
								.addComponent(phoneAllowanceLabel))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(employeeNumberField, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(phoneNumberField, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(statusField, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(phoneAllowanceField, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(firstNameLabel).addComponent(sssLabel).addComponent(positionLabel)
								.addComponent(clothingAllowanceLabel))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(firstNameField, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(sssField, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(positionField, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(clothingAllowanceField, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(lastNameLabel).addComponent(philhealthLabel)
								.addComponent(immediateSupervisorLabel).addComponent(grossSemiMonthlyRateLabel))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(lastNameField, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(philhealthField, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(immediateSupervisorField, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(grossSemiMonthlyRateField, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(birthdayLabel).addComponent(tinLabel).addComponent(basicSalaryLabel)
								.addComponent(hourlyRateLabel))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(birthdayField, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(tinField, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(basicSalaryField, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(hourlyRateField, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(addressLabel).addComponent(pagibigLabel).addComponent(riceSubsidyLabel))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(addressField, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(pagibigField, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(riceSubsidyField, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(confirmButton))
						.addContainerGap(19, Short.MAX_VALUE)));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(28, 28, 28)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(goBackToEmployeeListButton).addComponent(jPanel3,
										javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addContainerGap(29, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(46, 46, 46).addComponent(goBackToEmployeeListButton)
						.addGap(18, 18, 18)
						.addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(43, Short.MAX_VALUE)));

		pack();

		// Make the window appear in the middle
		setLocationRelativeTo(null);
	}// </editor-fold>

	private void confirmButtonActionPerformed(java.awt.event.ActionEvent evt) throws IOException {
		// Instantiate error message in case of misinput
		StringBuilder errorMessage = new StringBuilder();

		// Read the JSON file and parse it into a Java object
		JsonArray jsonArrayEmployees = JsonFileHandler.getEmployeesJSON();
		JsonArray jsonArrayLoginCredentials = JsonFileHandler.getLoginCredentialsJSON();

		if (!addEmployeeEntry(jsonArrayEmployees, errorMessage)) {
			errorDialogPane(errorMessage, "Error");
			return;
		}

		// Create temporary login credentials
		addLoginCredentialsEntry(jsonArrayLoginCredentials, employeeNumberField, firstNameField, lastNameField);

		// Convert the Java object back to JSON
		String updatedJsonEmployees = jsonArrayEmployees.toString();
		String updatedJsonLoginCredentials = jsonArrayLoginCredentials.toString();

		// Write the updated JSON back to the file
		JsonFileHandler.writeJsonFile(updatedJsonEmployees, JsonFileHandler.getEmployeesJsonPath());
		JsonFileHandler.writeJsonFile(updatedJsonLoginCredentials, JsonFileHandler.getLoginCredentialsJsonPath());

		// Go back to the employee list page
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				// Remove the UpdateEmployeeDetailsPage Window
				dispose();

				new EmployeeListPage().setVisible(true);
			}
		});

	}

	private static boolean addEmployeeEntry(JsonArray jsonArray, StringBuilder errorMessage) {
		String[] properties = { "employeeNum", "last_name", "first_name", "birthday", "address", "phone_number", "SSS",
				"Philhealth", "TIN", "Pag-ibig", "Status", "Position", "immediate_supervisor", "basic_salary",
				"rice_subsidy", "phone_allowance", "clothing_allowance", "gross_semi-monthly_rate", "hourly_rate" };

		JTextField[] fields = { employeeNumberField, lastNameField, firstNameField, birthdayField, addressField,
				phoneNumberField, sssField, philhealthField, tinField, pagibigField, statusField, positionField,
				immediateSupervisorField, basicSalaryField, riceSubsidyField, phoneAllowanceField,
				clothingAllowanceField, grossSemiMonthlyRateField, hourlyRateField };

		// Maintain a new array to validate user input
		JTextField[] stringOnlyFields = { lastNameField, firstNameField, positionField, immediateSupervisorField,
				statusField };

		JTextField[] numericFields = { pagibigField, philhealthField, basicSalaryField, riceSubsidyField,
				phoneAllowanceField, clothingAllowanceField, grossSemiMonthlyRateField, hourlyRateField };

		// Check if all the fields are filled out
		if (Arrays.stream(fields).anyMatch(field -> field.getText().trim().isEmpty())) {
			errorMessage.setLength(0); // Clear previous content
			errorMessage.append("Please fill in all the fields.");
			return false;
		}

		if (Arrays.stream(numericFields).anyMatch(numField -> !DataValidators.isNumeric(numField.getText()))) {
			errorMessage.setLength(0); // Clear previous content
			errorMessage.append(
					"Please enter valid numeric values for those that require it. (e.g. Hourly Rate, Basic Salary)");
			return false;
		}

		if (Arrays.stream(stringOnlyFields)
				.anyMatch(stringField -> !DataValidators.isPureString(stringField.getText()))) {
			errorMessage.setLength(0);
			errorMessage.append("Please enter valid characters only.");
			return false;
		}

		if (!DataValidators.isValidDate(birthdayField.getText())) {
			errorMessage.setLength(0);
			errorMessage.append("Please enter a valid date.");
			return false;
		}

		if (!DataValidators.isSSSFormattedCorrectly(sssField.getText())
				|| !DataValidators.isPhoneNumberFormattedCorrectly(phoneNumberField.getText())
				|| !DataValidators.isTINFormattedCorrectly(tinField.getText())
				|| !DataValidators.isProperLength(pagibigField.getText())
				|| !DataValidators.isProperLength(philhealthField.getText())) {
			errorMessage.setLength(0);
			errorMessage.append("Please follow proper formatting.");
			return false;
		}

		// Create a new JsonObject for the new employee
		JsonObject newEmployee = new JsonObject();

		// Set the properties for the new employee
		for (int i = 0; i < properties.length; i++) {
			addEmployees(newEmployee, properties[i], fields[i].getText());
		}

		// Add the new employee JsonObject to the JsonArray
		jsonArray.add(newEmployee);

		return true;
	}

	private static void addEmployees(JsonObject jsonObject, String propertyName, String propertyValue) {
		switch (propertyName) {
		case "Philhealth":
		case "Pag-ibig":
			jsonObject.addProperty(propertyName, Long.parseLong(propertyValue));
			break;
		case "basic_salary":
		case "rice_subsidy":
		case "phone_allowance":
		case "clothing_allowance":
		case "gross_semi-monthly_rate":
		case "hourly_rate":
			jsonObject.addProperty(propertyName, Double.parseDouble(propertyValue));
			break;
		case "employeeNum":
			jsonObject.addProperty(propertyName, Integer.parseInt(propertyValue));
			break;
		default:
			jsonObject.addProperty(propertyName, propertyValue);
			break;
		}
	}

	public static void addLoginCredentialsEntry(JsonArray jsonArray, JTextField employeeNumberField,
			JTextField firstNameField, JTextField lastNameField) {

		// Create a new JsonObject for the new employee
		JsonObject newEmployee = new JsonObject();

		newEmployee.addProperty("employeeNum", Integer.parseInt(employeeNumberField.getText()));
		newEmployee.addProperty("username", (firstNameField.getText() + "." + lastNameField.getText()).toLowerCase());
		newEmployee.addProperty("password", "password" + employeeNumberField.getText());

		// Add the new employee JsonObject to the JsonArray
		jsonArray.add(newEmployee);

	}

	private static boolean isNumeric(String str) {
		try {
			// Attempt to parse the input as a number
			Double.parseDouble(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	private void errorDialogPane(StringBuilder errorMessage, String title) {
		JOptionPane.showMessageDialog(new JFrame(""), errorMessage, title, JOptionPane.ERROR_MESSAGE);
	}

	private void goBackToEmployeeListButtonActionPerformed(java.awt.event.ActionEvent evt) throws IOException {
		// Go back to the employee list page
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				// Remove the EmployeesPage Window
				dispose();

				new EmployeeListPage().setVisible(true);
			}
		});
	}
}
