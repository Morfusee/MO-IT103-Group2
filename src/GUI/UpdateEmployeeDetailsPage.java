package GUI;

import java.awt.Dimension;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFrame;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import Classes.Compensation;
import Classes.GovernmentIdentification;
import UtilityClasses.JsonFileHandler;

public class UpdateEmployeeDetailsPage extends JFrame {

	// Variables declaration - do not modify
	private static javax.swing.JTextField addressField;
	private javax.swing.JLabel addressLabel;
	private static javax.swing.JTextField basicSalaryField;
	private javax.swing.JLabel basicSalaryLabel;
	private static javax.swing.JTextField birthdayField;
	private javax.swing.JLabel birthdayLabel;
	private static javax.swing.JTextField clothingAllowanceField;
	private javax.swing.JLabel clothingAllowanceLabel;
	private javax.swing.JTextField employeeNumberField;
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
	private GovernmentIdentification employeeGI;
	private Compensation employeeComp;
	// End of variables declaration

	public UpdateEmployeeDetailsPage(GovernmentIdentification employeeGI, Compensation employeeComp) {
		this.employeeGI = employeeGI;
		this.employeeComp = employeeComp;
		initComponents();
	}

	private void initComponents() {

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
		setTitle("MotorPH Payroll System | Update Employee Details");

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

		// Change the value of each corresponding field
		addressField.setText(employeeGI.getAddress());
		basicSalaryField.setText(Double.toString(employeeComp.getBasicSalary()));
		birthdayField.setText(employeeGI.getBirthday());
		clothingAllowanceField.setText(Double.toString(employeeComp.getClothingAllowance()));
		employeeNumberField.setText(employeeGI.getEmployeeNumber());
		firstNameField.setText(employeeGI.getFirstName());
		grossSemiMonthlyRateField.setText(Double.toString(employeeComp.getGrossSemiMonthlyRate()));
		hourlyRateField.setText(Double.toString(employeeComp.getHourlyRate()));
		immediateSupervisorField.setText(employeeGI.getImmediateSupervisor());
		lastNameField.setText(employeeGI.getLastName());
		pagibigField.setText(employeeGI.getPagibigNumber());
		philhealthField.setText(employeeGI.getPhilHealthNumber());
		phoneAllowanceField.setText(Double.toString(employeeComp.getPhoneAllowance()));
		phoneNumberField.setText(employeeGI.getPhoneNumber());
		positionField.setText(employeeGI.getPosition());
		riceSubsidyField.setText(Double.toString(employeeComp.getRiceSubsidy()));
		sssField.setText(employeeGI.getSSSNumber());
		statusField.setText(employeeGI.getStatus());
		tinField.setText(employeeGI.getTinNumber());

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
		// Read the JSON file and parse it into a Java object
		JsonArray jsonArray = JsonFileHandler.getEmployeesJSON();

		// Update a specific entry in the Java object
		String employeeNumToUpdate = employeeNumberField.getText();

		updateEntry(jsonArray, employeeNumToUpdate);

		// Convert the Java object back to JSON
		String updatedJson = jsonArray.toString();

		// Write the updated JSON back to the file
		writeJsonFile(updatedJson, JsonFileHandler.getEmployeesJsonPath());

		// Go back to the employee list page
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				// Remove the UpdateEmployeeDetailsPage Window
				dispose();

				new EmployeesPage().setVisible(true);
			}
		});

	}

	private static void writeJsonFile(String json, String filePath) {
		try (FileWriter writer = new FileWriter(filePath)) {
			writer.write(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void updateEntry(JsonArray jsonArray, String employeeNumToUpdate) {
		for (JsonElement element : jsonArray) {
			if (element.isJsonObject()) {
				JsonObject employeeObject = element.getAsJsonObject();
				if (employeeObject.has("employeeNum")
						&& employeeObject.get("employeeNum").getAsString().equals(employeeNumToUpdate)) {
					// Update the values for the specified employeeNum
					updateProperty(employeeObject, "last_name", lastNameField.getText());
					updateProperty(employeeObject, "first_name", firstNameField.getText());
					updateProperty(employeeObject, "birthday", birthdayField.getText());
					updateProperty(employeeObject, "address", addressField.getText());
					updateProperty(employeeObject, "phone_number", phoneNumberField.getText());
					updateProperty(employeeObject, "SSS", sssField.getText());
					updateProperty(employeeObject, "Philhealth", Long.parseLong(philhealthField.getText()));
					updateProperty(employeeObject, "TIN", tinField.getText());
					updateProperty(employeeObject, "Pag-ibig", Long.parseLong(pagibigField.getText()));
					updateProperty(employeeObject, "Status", statusField.getText());
					updateProperty(employeeObject, "Position", positionField.getText());
					updateProperty(employeeObject, "immediate_supervisor", immediateSupervisorField.getText());
					updateProperty(employeeObject, "basic_salary", Double.parseDouble(basicSalaryField.getText()));
					updateProperty(employeeObject, "rice_subsidy", Double.parseDouble(riceSubsidyField.getText()));
					updateProperty(employeeObject, "phone_allowance",
							Double.parseDouble(phoneAllowanceField.getText()));
					updateProperty(employeeObject, "clothing_allowance",
							Double.parseDouble(clothingAllowanceField.getText()));
					updateProperty(employeeObject, "gross_semi-monthly_rate",
							Double.parseDouble(grossSemiMonthlyRateField.getText()));
					updateProperty(employeeObject, "hourly_rate", Double.parseDouble(hourlyRateField.getText()));

					break; // Break the loop once the entry is updated
				}
			}
		}
	}

	private static void updateProperty(JsonObject jsonObject, String propertyName, String propertyValue) {
		if (jsonObject.has(propertyName)) {
			jsonObject.addProperty(propertyName, propertyValue);
		}
	}

	private static void updateProperty(JsonObject jsonObject, String propertyName, Double propertyValue) {
		if (jsonObject.has(propertyName)) {
			jsonObject.addProperty(propertyName, propertyValue);
		}
	}

	private static void updateProperty(JsonObject jsonObject, String propertyName, Long propertyValue) {
		if (jsonObject.has(propertyName)) {
			jsonObject.addProperty(propertyName, propertyValue);
		}
	}

	private void goBackToEmployeeListButtonActionPerformed(java.awt.event.ActionEvent evt) throws IOException {
		// Go back to the employee list page
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				// Remove the EmployeesPage Window
				dispose();
			}
		});
	}
}
