package GUI;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.border.*;
import com.google.gson.JsonObject;

import Classes.Compensation;
import UtilityClasses.JsonFileHandler;
import UtilityClasses.SalaryCalculator;

public class CalculatorPage extends JFrame {

	// Hourly Rate
	private double hourlyRate;
	private JLabel hourlyRateLabel = new JLabel("Hourly Rate: ");
	private JLabel hourlyRateValue = new JLabel();

	// Hours Rendered
	private double hoursRendered;
	private JLabel hoursRenderedLabel = new JLabel("Hours Rendered: ");
	private JTextField hoursRenderedField = new JTextField(4);

	// Gross Salary
	private double grossSalary;
	private JLabel grossSalaryLabel = new JLabel("Gross Salary: ");
	private JLabel grossSalaryValue = new JLabel("");

	// Rice Subsidy
	private double riceSubsidy;
	private JLabel riceSubsidyLabel = new JLabel("Rice Subsidy: ");
	private JLabel riceSubsidyValue = new JLabel("");

	// Phone Allowances
	private double phoneAllowance;
	private JLabel phoneAllowanceLabel = new JLabel("Phone Allowance: ");
	private JLabel phoneAllowanceValue = new JLabel("");

	// Clothing Allowances
	private double clothingAllowance;
	private JLabel clothingAllowanceLabel = new JLabel("Clothing Allowance: ");
	private JLabel clothingAllowanceValue = new JLabel("");

	// Total Allowance
	private double totalAllowance;
	private JLabel totalAllowanceLabel = new JLabel("Total Allowance: ");
	private JLabel totalAllowanceValue = new JLabel("");

	// SSS Deduction
	private double sssDeductions;
	private JLabel sssDeductionsLabel = new JLabel("SSS Deduction: ");
	private JLabel sssDeductionsValue = new JLabel("");

	// PhilHealth Deduction
	private double philhealthDeductions;
	private JLabel philhealthDeductionsLabel = new JLabel("PhilHealth Deduction: ");
	private JLabel philhealthDeductionsValue = new JLabel("");

	// Pag-ibig Deduction
	private double pagibigDeductions;
	private JLabel pagibigDeductionsLabel = new JLabel("Pag-ibig Deduction: ");
	private JLabel pagibigDeductionsValue = new JLabel("");

	// Total Deductions
	private double totalDeductions;
	private JLabel totalDeductionsLabel = new JLabel("Total Deductions: ");
	private JLabel totalDeductionsValue = new JLabel("");

	// Taxable Salary
	private double taxableSalary;
	private JLabel taxableSalaryLabel = new JLabel("Taxable Salary: ");
	private JLabel taxableSalaryValue = new JLabel("");

	// Withholding Tax
	private double withHoldingTax;
	private JLabel withHoldingTaxLabel = new JLabel("Withholding Tax: ");
	private JLabel withHoldingTaxValue = new JLabel("");

	// Salary After Tax
	private double salaryAfterTax;
	private JLabel salaryAfterTaxLabel = new JLabel("Salary After Tax: ");
	private JLabel salaryAfterTaxValue = new JLabel("");

	// Net Salary
	private double netSalary;
	private JLabel netSalaryLabel = new JLabel("Net Salary: ");
	private JLabel netSalaryValue = new JLabel("");

	// Buttons
	private JButton calculateSalaryButton = new JButton("Calculate");

	// Panels
	private JPanel jPanel1;
	private JPanel jPanel3;
	private JPanel jPanel4;

	// Headers
	private JLabel grossSalaryComputationLabel;
	private JLabel netSalaryComputationLabel;
	private JLabel allowancesLabel;

	// Duplicated Labels
	private JLabel grossSalaryLabel1;
	private JLabel grossSalaryValue1;
	private JLabel totalAllowancesLabel1;
	private JLabel totalAllowanceValue1;

	/**
	 * Creates new form CalculatorPage
	 */
	public CalculatorPage(Compensation employeeComp) {
		initComponents(employeeComp);
		// Set important data on render
		setDataOnRender(employeeComp);
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents(Compensation employeeComp) {

		jPanel1 = new javax.swing.JPanel();
		grossSalaryComputationLabel = new javax.swing.JLabel();
		jPanel3 = new javax.swing.JPanel();
		netSalaryComputationLabel = new javax.swing.JLabel();
		grossSalaryLabel1 = new javax.swing.JLabel();
		grossSalaryValue1 = new javax.swing.JLabel();
		totalAllowancesLabel1 = new javax.swing.JLabel();
		totalAllowanceValue1 = new javax.swing.JLabel();
		jPanel4 = new javax.swing.JPanel();
		allowancesLabel = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		setBackground(new java.awt.Color(255, 255, 255));
		setResizable(false);
		setTitle("MotorPH Payroll System | Salary Calculator");

		jPanel1.setBackground(new java.awt.Color(255, 255, 255));
		jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

		hoursRenderedLabel.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
		hoursRenderedLabel.setText("Hours Rendered");

		grossSalaryComputationLabel.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
		grossSalaryComputationLabel.setText("Gross Salary Computation");

		hourlyRateLabel.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
		hourlyRateLabel.setText("Hourly Rate");

		grossSalaryLabel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
		grossSalaryLabel.setText("Gross Salary");

		hourlyRateValue.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
		hourlyRateValue.setText(" ");

		grossSalaryValue.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
		grossSalaryValue.setText(" ");

		hoursRenderedField.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				hoursRenderedFieldActionPerformed(evt, employeeComp);
			}
		});

		calculateSalaryButton.setText("Calculate");
		calculateSalaryButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				calculateSalaryButtonActionPerformed(evt, employeeComp);
			}
		});

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addGap(42, 42, 42)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(hourlyRateLabel).addComponent(hoursRenderedLabel)
								.addComponent(grossSalaryLabel))
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(jPanel1Layout.createSequentialGroup()
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addGroup(jPanel1Layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(hourlyRateValue, javax.swing.GroupLayout.PREFERRED_SIZE,
														132, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(grossSalaryValue, javax.swing.GroupLayout.PREFERRED_SIZE,
														132, javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(45, 45, 45))
								.addGroup(jPanel1Layout.createSequentialGroup().addGap(29, 29, 29)
										.addComponent(hoursRenderedField, javax.swing.GroupLayout.PREFERRED_SIZE, 132,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(calculateSalaryButton).addContainerGap(16, Short.MAX_VALUE))))
				.addGroup(jPanel1Layout.createSequentialGroup().addGap(14, 14, 14)
						.addComponent(grossSalaryComputationLabel).addGap(0, 0, Short.MAX_VALUE)));
		jPanel1Layout
				.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
								.addGap(14, 14, 14).addComponent(grossSalaryComputationLabel).addGap(28, 28, 28)
								.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(hoursRenderedLabel).addComponent(calculateSalaryButton)
										.addComponent(hoursRenderedField, javax.swing.GroupLayout.PREFERRED_SIZE, 24,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(18, 18, 18)
								.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(hourlyRateLabel).addComponent(hourlyRateValue))
								.addGap(18, 18, 18)
								.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(grossSalaryLabel).addComponent(grossSalaryValue))
								.addContainerGap(35, Short.MAX_VALUE)));

		jPanel3.setBackground(new java.awt.Color(255, 255, 255));
		jPanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

		netSalaryComputationLabel.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
		netSalaryComputationLabel.setText("Net Salary Computation");

		sssDeductionsLabel.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
		sssDeductionsLabel.setText("SSS Deduction");

		sssDeductionsValue.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
		sssDeductionsValue.setText(" ");

		philhealthDeductionsLabel.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
		philhealthDeductionsLabel.setText("PhilHealth Deduction");

		philhealthDeductionsValue.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
		philhealthDeductionsValue.setText(" ");

		totalDeductionsLabel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
		totalDeductionsLabel.setText("Total Deductions");

		totalDeductionsValue.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
		totalDeductionsValue.setText(" ");

		pagibigDeductionsLabel.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
		pagibigDeductionsLabel.setText("Pag-ibig Deduction");

		pagibigDeductionsValue.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
		pagibigDeductionsValue.setText(" ");

		grossSalaryLabel1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
		grossSalaryLabel1.setText("Gross Salary");

		grossSalaryValue1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
		grossSalaryValue1.setText(" ");

		taxableSalaryLabel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
		taxableSalaryLabel.setText("Taxable Salary");

		taxableSalaryValue.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
		taxableSalaryValue.setText(" ");

		withHoldingTaxLabel.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
		withHoldingTaxLabel.setText("Withholding Tax");

		withHoldingTaxValue.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
		withHoldingTaxValue.setText(" ");

		salaryAfterTaxLabel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
		salaryAfterTaxLabel.setText("Salary After Tax");

		salaryAfterTaxValue.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
		salaryAfterTaxValue.setText(" ");

		totalAllowancesLabel1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
		totalAllowancesLabel1.setText("Total Allowances");

		totalAllowanceValue1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
		totalAllowanceValue1.setText(" ");

		netSalaryLabel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
		netSalaryLabel.setText("Net Salary");

		netSalaryValue.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
		netSalaryValue.setText(" ");

		javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
		jPanel3.setLayout(jPanel3Layout);
		jPanel3Layout
				.setHorizontalGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(jPanel3Layout
								.createSequentialGroup().addGap(15, 15, 15).addComponent(netSalaryComputationLabel)
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(jPanel3Layout.createSequentialGroup().addGap(48, 48, 48)
								.addGroup(jPanel3Layout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(philhealthDeductionsLabel).addComponent(sssDeductionsLabel)
										.addComponent(totalDeductionsLabel).addComponent(grossSalaryLabel1)
										.addComponent(taxableSalaryLabel).addComponent(withHoldingTaxLabel)
										.addComponent(salaryAfterTaxLabel).addComponent(netSalaryLabel)
										.addComponent(totalAllowancesLabel1).addComponent(pagibigDeductionsLabel))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40,
										Short.MAX_VALUE)
								.addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(netSalaryValue, javax.swing.GroupLayout.PREFERRED_SIZE, 132,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(totalAllowanceValue1, javax.swing.GroupLayout.PREFERRED_SIZE, 132,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(salaryAfterTaxValue, javax.swing.GroupLayout.PREFERRED_SIZE, 132,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(withHoldingTaxValue, javax.swing.GroupLayout.PREFERRED_SIZE, 132,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(taxableSalaryValue, javax.swing.GroupLayout.PREFERRED_SIZE, 132,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(grossSalaryValue1, javax.swing.GroupLayout.PREFERRED_SIZE, 132,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(
												totalDeductionsValue, javax.swing.GroupLayout.PREFERRED_SIZE, 132,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(pagibigDeductionsValue, javax.swing.GroupLayout.PREFERRED_SIZE,
												132, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGroup(jPanel3Layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
												.addComponent(philhealthDeductionsValue,
														javax.swing.GroupLayout.PREFERRED_SIZE, 132,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(sssDeductionsValue,
														javax.swing.GroupLayout.PREFERRED_SIZE, 132,
														javax.swing.GroupLayout.PREFERRED_SIZE)))
								.addGap(51, 51, 51)));
		jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel3Layout.createSequentialGroup().addGap(14, 14, 14)
						.addComponent(netSalaryComputationLabel).addGap(18, 18, 18)
						.addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(sssDeductionsLabel).addComponent(sssDeductionsValue))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(philhealthDeductionsLabel).addComponent(philhealthDeductionsValue))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(pagibigDeductionsLabel).addComponent(pagibigDeductionsValue))
						.addGap(18, 18, 18)
						.addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(totalDeductionsLabel).addComponent(totalDeductionsValue))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(grossSalaryLabel1).addComponent(grossSalaryValue1))
						.addGap(18, 18, 18)
						.addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(taxableSalaryLabel).addComponent(taxableSalaryValue))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(withHoldingTaxLabel).addComponent(withHoldingTaxValue))
						.addGap(18, 18, 18)
						.addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(salaryAfterTaxLabel).addComponent(salaryAfterTaxValue))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(totalAllowancesLabel1).addComponent(totalAllowanceValue1))
						.addGap(18, 18, 18)
						.addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(netSalaryLabel).addComponent(netSalaryValue))
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		jPanel4.setBackground(new java.awt.Color(255, 255, 255));
		jPanel4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

		riceSubsidyLabel.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
		riceSubsidyLabel.setText("Rice Subsidy");

		riceSubsidyValue.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
		riceSubsidyValue.setText(" ");

		phoneAllowanceLabel.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
		phoneAllowanceLabel.setText("Phone Allowance");

		phoneAllowanceValue.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
		phoneAllowanceValue.setText(" ");

		totalAllowanceLabel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
		totalAllowanceLabel.setText("Total Allowances");

		totalAllowanceValue.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
		totalAllowanceValue.setText(" ");

		allowancesLabel.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
		allowancesLabel.setText("Allowances");

		clothingAllowanceLabel.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
		clothingAllowanceLabel.setText("Clothing Allowance");

		clothingAllowanceValue.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
		clothingAllowanceValue.setText(" ");

		javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
		jPanel4.setLayout(jPanel4Layout);
		jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel4Layout.createSequentialGroup().addGap(17, 17, 17).addComponent(allowancesLabel)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(jPanel4Layout.createSequentialGroup().addGap(37, 37, 37)
						.addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(phoneAllowanceLabel).addComponent(riceSubsidyLabel)
								.addComponent(totalAllowanceLabel).addComponent(clothingAllowanceLabel))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(phoneAllowanceValue, javax.swing.GroupLayout.PREFERRED_SIZE, 132,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(riceSubsidyValue, javax.swing.GroupLayout.PREFERRED_SIZE, 132,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(totalAllowanceValue, javax.swing.GroupLayout.PREFERRED_SIZE, 132,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(clothingAllowanceValue, javax.swing.GroupLayout.PREFERRED_SIZE, 132,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(39, 39, 39)));
		jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel4Layout.createSequentialGroup().addGap(12, 12, 12).addComponent(allowancesLabel)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(riceSubsidyLabel).addComponent(riceSubsidyValue))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(phoneAllowanceLabel).addComponent(phoneAllowanceValue))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(clothingAllowanceLabel).addComponent(clothingAllowanceValue))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
						.addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(totalAllowanceLabel).addComponent(totalAllowanceValue))
						.addGap(18, 18, 18)));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup().addGap(48, 48, 48)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
										.addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addGap(18, 18, 18)
								.addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addContainerGap(58, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup().addContainerGap(36, Short.MAX_VALUE)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
						.addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(layout.createSequentialGroup()
								.addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(18, 18, 18).addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
				.addContainerGap(36, Short.MAX_VALUE)));

		pack();
		
		// Must be called after setting pack
		setLocationRelativeTo(null);
	}

	private void hoursRenderedFieldActionPerformed(java.awt.event.ActionEvent evt, Compensation employeeComp) {
		// TODO add your handling code here:
		setDataOnEvent(employeeComp);
	}

	private void calculateSalaryButtonActionPerformed(java.awt.event.ActionEvent evt, Compensation employeeComp) {
		// TODO add your handling code here:
		setDataOnEvent(employeeComp);
	}

	public void setDataOnEvent(Compensation employeeComp) {
		// Format the data to only be two decimal places
		DecimalFormat numberFormat = new DecimalFormat("#.00");

		// Get hours rendered
		hoursRendered = Double.parseDouble(hoursRenderedField.getText());

		// Set Gross Salary
		grossSalary = Double
				.parseDouble(numberFormat.format(employeeComp.calculateGrossSalary(hourlyRate, hoursRendered)));
		grossSalaryValue.setText(String.valueOf(grossSalary));
		grossSalaryValue1.setText(String.valueOf(grossSalary)); // Duplicate label

		// Set SSS Deductions
		sssDeductions = Double.parseDouble(numberFormat.format(SalaryCalculator.getSSS(grossSalary)));
		sssDeductionsValue.setText(String.valueOf(sssDeductions));

		// Set PhilHealth Deductions
		philhealthDeductions = Double.parseDouble(numberFormat.format(SalaryCalculator.getPhilHealth(grossSalary)));
		philhealthDeductionsValue.setText(String.valueOf(philhealthDeductions));

		// Set Pag-ibig Deductions
		pagibigDeductions = Double.parseDouble(numberFormat.format(SalaryCalculator.getPagibig(grossSalary)));
		pagibigDeductionsValue.setText(String.valueOf(pagibigDeductions));

		// Set Total Deductions
		totalDeductions = pagibigDeductions + philhealthDeductions + sssDeductions;
		totalDeductionsValue.setText(String.valueOf(totalDeductions));

		// Set Taxable Salary
		taxableSalary = Double.parseDouble(numberFormat.format(grossSalary - totalDeductions));
		taxableSalaryValue.setText(String.valueOf(taxableSalary));

		// Set Withholding Tax
		withHoldingTax = Double.parseDouble(numberFormat.format(SalaryCalculator.getWithholding(taxableSalary)));
		withHoldingTaxValue.setText(String.valueOf(withHoldingTax));

		// Set Salary After Tax
		salaryAfterTax = Double.parseDouble(numberFormat.format(taxableSalary - withHoldingTax));
		salaryAfterTaxValue.setText(String.valueOf(salaryAfterTax));

		// Set Net Salary
		netSalary = Double.parseDouble(numberFormat.format(salaryAfterTax + totalAllowance));
		netSalaryValue.setText(String.valueOf(netSalary));

	}

	public void setDataOnRender(Compensation employeeComp) {
		// Set hourly rate
		hourlyRate = employeeComp.getHourlyRate();
		hourlyRateValue.setText(Double.toString(hourlyRate));

		// Set rice subsidy
		riceSubsidy = employeeComp.getRiceSubsidy();
		riceSubsidyValue.setText(Double.toString(riceSubsidy));

		// Set phone allowance
		phoneAllowance = employeeComp.getPhoneAllowance();
		phoneAllowanceValue.setText(Double.toString(phoneAllowance));

		// Set clothing allowance
		clothingAllowance = employeeComp.getClothingAllowance();
		clothingAllowanceValue.setText(Double.toString(clothingAllowance));

		totalAllowance = phoneAllowance + riceSubsidy + clothingAllowance;
		totalAllowanceValue.setText(Double.toString(totalAllowance));
		totalAllowanceValue1.setText(Double.toString(totalAllowance)); // Duplicate label
	}
}
