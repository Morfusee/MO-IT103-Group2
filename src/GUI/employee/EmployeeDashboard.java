package GUI.employee;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.io.IOException;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.concurrent.atomic.AtomicInteger;

import javax.swing.JFrame;
import javax.swing.JScrollBar;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import Classes.Compensation;
import Classes.GovernmentIdentification;
import GUI.LoginPage;
import UtilityClasses.JsonFileHandler;
import UtilityClasses.SalaryCalculator;

public class EmployeeDashboard extends JFrame {

	// Variables declaration - do not modify
	private javax.swing.JLabel address;
	private javax.swing.JLabel addressValue;
	private javax.swing.JLabel allowancesLabel;
	private javax.swing.JButton submitLeaveRequestButton;
	private javax.swing.JLabel birthday;
	private javax.swing.JLabel birthdayValue;
	private javax.swing.JLabel clothingAllowanceLabel;
	private javax.swing.JLabel clothingAllowanceValue;
	private javax.swing.JButton computeButton;
	private javax.swing.JButton logoutButton;
	private javax.swing.JLabel firstName;
	private javax.swing.JLabel firstNameValue;
	private javax.swing.JLabel grossSalaryComputationLabel;
	private javax.swing.JLabel grossSalaryLabel;
	private javax.swing.JLabel grossSalaryLabel1;
	private javax.swing.JLabel grossSalaryValue;
	private javax.swing.JLabel grossSalaryValue1;
	private javax.swing.JLabel hourlyRate;
	private javax.swing.JLabel hourlyRateLabel;
	private javax.swing.JLabel hourlyRateValue;
	private javax.swing.JLabel hourlyRateLabel1;
	private javax.swing.JLabel hoursRenderedLabel;
	private javax.swing.JLabel hoursRenderedValue;
	private javax.swing.JLabel immediateSupervisor;
	private javax.swing.JLabel immediateSupervisorValue;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel11;
	private javax.swing.JPanel jPanel12;
	private javax.swing.JPanel jPanel3;
	private javax.swing.JPanel jPanel31;
	private javax.swing.JPanel jPanel32;
	private javax.swing.JPanel jPanel33;
	private javax.swing.JPanel jPanel4;
	private javax.swing.JPanel jPanel5;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JLabel lastName;
	private javax.swing.JLabel lastNameValue;
	private javax.swing.JComboBox<String> monthDropdown;
	private javax.swing.JLabel netSalaryComputationLabel;
	private javax.swing.JLabel netSalaryLabel;
	private javax.swing.JLabel netSalaryValue;
	private javax.swing.JLabel pagibigDeductionsLabel;
	private javax.swing.JLabel pagibigDeductionsValue;
	private javax.swing.JLabel pagibigNumber;
	private javax.swing.JLabel pagibigNumberValue;
	private javax.swing.JLabel philhealthDeductionsLabel;
	private javax.swing.JLabel philhealthDeductionsValue;
	private javax.swing.JLabel philhealthNumber;
	private javax.swing.JLabel philhealthNumberValue;
	private javax.swing.JLabel phoneAllowanceLabel;
	private javax.swing.JLabel phoneAllowanceValue;
	private javax.swing.JLabel phoneNumber;
	private javax.swing.JLabel phoneNumberValue;
	private javax.swing.JLabel position;
	private javax.swing.JLabel positionValue;
	private javax.swing.JLabel riceSubsidyLabel;
	private javax.swing.JLabel riceSubsidyValue;
	private javax.swing.JLabel salaryAfterTaxLabel;
	private javax.swing.JLabel salaryAfterTaxValue;
	private javax.swing.JLabel sssDeductionsLabel;
	private javax.swing.JLabel sssDeductionsValue;
	private javax.swing.JLabel sssNumber;
	private javax.swing.JLabel sssNumberValue;
	private javax.swing.JLabel status;
	private javax.swing.JLabel statusValue;
	private javax.swing.JLabel taxableSalaryLabel;
	private javax.swing.JLabel taxableSalaryValue;
	private javax.swing.JLabel tinNumber;
	private javax.swing.JLabel tinNumberValue;
	private javax.swing.JLabel totalAllowanceLabel;
	private javax.swing.JLabel totalAllowanceValue;
	private javax.swing.JLabel totalAllowancesLabel1;
	private javax.swing.JLabel totalAllowancesValue1;
	private javax.swing.JLabel totalDeductionsLabel;
	private javax.swing.JLabel totalDeductionsValue;
	private javax.swing.JLabel withHoldingTaxLabel;
	private javax.swing.JLabel withHoldingTaxValue;
	private javax.swing.JLabel welcomeLabel;
	private GovernmentIdentification employeeGI;
	private Compensation employeeComp;
	private Double totalAllowance;
	private String selectedMonth = LocalDate.now().getMonth().toString();
	private AtomicInteger hoursRenderedNum = new AtomicInteger(0);
	private AtomicInteger absentsNum = new AtomicInteger(0);
	private AtomicInteger latesNum = new AtomicInteger(0);
	private AtomicInteger presentsNum = new AtomicInteger(0);
	private DecimalFormat numberFormat = new DecimalFormat("#.00");
	// End of variables declaration

	public EmployeeDashboard(GovernmentIdentification employeeGI, Compensation employeeComp) {

		// Put the class objects onto a higher scope
		this.employeeGI = employeeGI;
		this.employeeComp = employeeComp;

		// Set total allowance early on to avoid errors
		this.totalAllowance = employeeComp.getRiceSubsidy() + employeeComp.getPhoneAllowance()
				+ employeeComp.getClothingAllowance();

		initComponents();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jPanel1 = new javax.swing.JPanel();
		jScrollPane1 = new javax.swing.JScrollPane();
		jPanel12 = new javax.swing.JPanel();
		jPanel5 = new javax.swing.JPanel();
		address = new javax.swing.JLabel();
		addressValue = new javax.swing.JLabel();
		jPanel31 = new javax.swing.JPanel();
		hoursRenderedLabel = new javax.swing.JLabel();
		grossSalaryComputationLabel = new javax.swing.JLabel();
		hourlyRateLabel = new javax.swing.JLabel();
		grossSalaryLabel = new javax.swing.JLabel();
		hourlyRateLabel1 = new javax.swing.JLabel();
		grossSalaryValue = new javax.swing.JLabel();
		hoursRenderedValue = new javax.swing.JLabel();
		jPanel32 = new javax.swing.JPanel();
		netSalaryComputationLabel = new javax.swing.JLabel();
		sssDeductionsLabel = new javax.swing.JLabel();
		sssDeductionsValue = new javax.swing.JLabel();
		philhealthDeductionsLabel = new javax.swing.JLabel();
		philhealthDeductionsValue = new javax.swing.JLabel();
		totalDeductionsLabel = new javax.swing.JLabel();
		totalDeductionsValue = new javax.swing.JLabel();
		pagibigDeductionsLabel = new javax.swing.JLabel();
		pagibigDeductionsValue = new javax.swing.JLabel();
		grossSalaryLabel1 = new javax.swing.JLabel();
		grossSalaryValue1 = new javax.swing.JLabel();
		taxableSalaryLabel = new javax.swing.JLabel();
		taxableSalaryValue = new javax.swing.JLabel();
		withHoldingTaxLabel = new javax.swing.JLabel();
		withHoldingTaxValue = new javax.swing.JLabel();
		salaryAfterTaxLabel = new javax.swing.JLabel();
		salaryAfterTaxValue = new javax.swing.JLabel();
		totalAllowancesLabel1 = new javax.swing.JLabel();
		totalAllowancesValue1 = new javax.swing.JLabel();
		netSalaryLabel = new javax.swing.JLabel();
		netSalaryValue = new javax.swing.JLabel();
		jPanel33 = new javax.swing.JPanel();
		riceSubsidyLabel = new javax.swing.JLabel();
		riceSubsidyValue = new javax.swing.JLabel();
		phoneAllowanceLabel = new javax.swing.JLabel();
		phoneAllowanceValue = new javax.swing.JLabel();
		totalAllowanceLabel = new javax.swing.JLabel();
		totalAllowanceValue = new javax.swing.JLabel();
		allowancesLabel = new javax.swing.JLabel();
		clothingAllowanceLabel = new javax.swing.JLabel();
		clothingAllowanceValue = new javax.swing.JLabel();
		jPanel11 = new javax.swing.JPanel();
		firstName = new javax.swing.JLabel();
		firstNameValue = new javax.swing.JLabel();
		lastName = new javax.swing.JLabel();
		lastNameValue = new javax.swing.JLabel();
		birthday = new javax.swing.JLabel();
		birthdayValue = new javax.swing.JLabel();
		phoneNumber = new javax.swing.JLabel();
		phoneNumberValue = new javax.swing.JLabel();
		jPanel3 = new javax.swing.JPanel();
		status = new javax.swing.JLabel();
		statusValue = new javax.swing.JLabel();
		position = new javax.swing.JLabel();
		positionValue = new javax.swing.JLabel();
		immediateSupervisor = new javax.swing.JLabel();
		immediateSupervisorValue = new javax.swing.JLabel();
		hourlyRate = new javax.swing.JLabel();
		hourlyRateValue = new javax.swing.JLabel();
		jPanel4 = new javax.swing.JPanel();
		sssNumber = new javax.swing.JLabel();
		sssNumberValue = new javax.swing.JLabel();
		philhealthNumber = new javax.swing.JLabel();
		philhealthNumberValue = new javax.swing.JLabel();
		pagibigNumber = new javax.swing.JLabel();
		pagibigNumberValue = new javax.swing.JLabel();
		tinNumber = new javax.swing.JLabel();
		tinNumberValue = new javax.swing.JLabel();
		welcomeLabel = new javax.swing.JLabel();
		monthDropdown = new javax.swing.JComboBox<>();
		computeButton = new javax.swing.JButton();
		submitLeaveRequestButton = new javax.swing.JButton();
		logoutButton = new javax.swing.JButton();

		setTitle("MotorPH Payroll System | Full Details of " + employeeGI.getLastName());
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setResizable(false);

		jPanel1.setBackground(new java.awt.Color(255, 255, 255));

		jPanel5.setBackground(new java.awt.Color(255, 255, 255));
		jPanel5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

		address.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
		address.setText("Address");

		addressValue.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
		addressValue.setText(employeeGI.getAddress());

		javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
		jPanel5.setLayout(jPanel5Layout);
		jPanel5Layout.setHorizontalGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel5Layout.createSequentialGroup().addGap(15, 15, 15)
						.addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(address).addComponent(addressValue,
										javax.swing.GroupLayout.PREFERRED_SIZE, 785,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		jPanel5Layout.setVerticalGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel5Layout.createSequentialGroup().addGap(12, 12, 12).addComponent(address)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(addressValue)
						.addContainerGap(13, Short.MAX_VALUE)));

		jPanel31.setBackground(new java.awt.Color(255, 255, 255));
		jPanel31.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

		hoursRenderedLabel.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
		hoursRenderedLabel.setText("Hours Rendered");

		grossSalaryComputationLabel.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
		grossSalaryComputationLabel.setText("Gross Salary Computation");

		hourlyRateLabel.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
		hourlyRateLabel.setText("Hourly Rate");

		grossSalaryLabel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
		grossSalaryLabel.setText("Gross Salary");

		hourlyRateLabel1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
		hourlyRateLabel1.setText(Double.toString(employeeComp.getHourlyRate()));

		grossSalaryValue.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
		grossSalaryValue.setText(" ");

		hoursRenderedValue.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
		hoursRenderedValue.setText(" ");

		javax.swing.GroupLayout jPanel31Layout = new javax.swing.GroupLayout(jPanel31);
		jPanel31.setLayout(jPanel31Layout);
		jPanel31Layout.setHorizontalGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel31Layout.createSequentialGroup().addGap(42, 42, 42)
						.addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(hourlyRateLabel).addComponent(hoursRenderedLabel)
								.addComponent(grossSalaryLabel))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(hourlyRateLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 132,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(grossSalaryValue, javax.swing.GroupLayout.PREFERRED_SIZE, 132,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(hoursRenderedValue, javax.swing.GroupLayout.PREFERRED_SIZE, 132,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(45, 45, 45))
				.addGroup(jPanel31Layout.createSequentialGroup().addGap(14, 14, 14)
						.addComponent(grossSalaryComputationLabel).addGap(0, 0, Short.MAX_VALUE)));
		jPanel31Layout
				.setVerticalGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel31Layout.createSequentialGroup()
								.addGap(14, 14, 14).addComponent(grossSalaryComputationLabel).addGap(28, 28, 28)
								.addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(hoursRenderedLabel).addComponent(hoursRenderedValue))
								.addGap(18, 18, 18)
								.addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(hourlyRateLabel).addComponent(hourlyRateLabel1))
								.addGap(18, 18, 18)
								.addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(grossSalaryLabel).addComponent(grossSalaryValue))
								.addContainerGap(35, Short.MAX_VALUE)));

		jPanel32.setBackground(new java.awt.Color(255, 255, 255));
		jPanel32.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

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

		totalAllowancesValue1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
		totalAllowancesValue1.setText(numberFormat.format(totalAllowance));

		netSalaryLabel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
		netSalaryLabel.setText("Net Salary");

		netSalaryValue.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
		netSalaryValue.setText(" ");

		javax.swing.GroupLayout jPanel32Layout = new javax.swing.GroupLayout(jPanel32);
		jPanel32.setLayout(jPanel32Layout);
		jPanel32Layout.setHorizontalGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel32Layout.createSequentialGroup().addGap(15, 15, 15)
						.addComponent(netSalaryComputationLabel)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(jPanel32Layout.createSequentialGroup().addGap(48, 48, 48)
						.addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(philhealthDeductionsLabel).addComponent(sssDeductionsLabel)
								.addComponent(totalDeductionsLabel).addComponent(grossSalaryLabel1)
								.addComponent(taxableSalaryLabel).addComponent(withHoldingTaxLabel)
								.addComponent(salaryAfterTaxLabel).addComponent(netSalaryLabel)
								.addComponent(totalAllowancesLabel1).addComponent(pagibigDeductionsLabel))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
						.addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(netSalaryValue, javax.swing.GroupLayout.PREFERRED_SIZE, 132,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(totalAllowancesValue1, javax.swing.GroupLayout.PREFERRED_SIZE, 132,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(salaryAfterTaxValue, javax.swing.GroupLayout.PREFERRED_SIZE, 132,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(withHoldingTaxValue, javax.swing.GroupLayout.PREFERRED_SIZE, 132,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(taxableSalaryValue, javax.swing.GroupLayout.PREFERRED_SIZE, 132,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(grossSalaryValue1, javax.swing.GroupLayout.PREFERRED_SIZE, 132,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(totalDeductionsValue, javax.swing.GroupLayout.PREFERRED_SIZE, 132,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(pagibigDeductionsValue, javax.swing.GroupLayout.PREFERRED_SIZE, 132,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
										.addComponent(philhealthDeductionsValue, javax.swing.GroupLayout.PREFERRED_SIZE,
												132, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(sssDeductionsValue, javax.swing.GroupLayout.PREFERRED_SIZE, 132,
												javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addGap(51, 51, 51)));
		jPanel32Layout.setVerticalGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel32Layout.createSequentialGroup().addGap(14, 14, 14)
						.addComponent(netSalaryComputationLabel).addGap(18, 18, 18)
						.addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(sssDeductionsLabel).addComponent(sssDeductionsValue))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(philhealthDeductionsLabel).addComponent(philhealthDeductionsValue))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(pagibigDeductionsLabel).addComponent(pagibigDeductionsValue))
						.addGap(18, 18, 18)
						.addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(totalDeductionsLabel).addComponent(totalDeductionsValue))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(grossSalaryLabel1).addComponent(grossSalaryValue1))
						.addGap(18, 18, 18)
						.addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(taxableSalaryLabel).addComponent(taxableSalaryValue))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(withHoldingTaxLabel).addComponent(withHoldingTaxValue))
						.addGap(18, 18, 18)
						.addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(salaryAfterTaxLabel).addComponent(salaryAfterTaxValue))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(totalAllowancesLabel1).addComponent(totalAllowancesValue1))
						.addGap(18, 18, 18)
						.addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(netSalaryLabel).addComponent(netSalaryValue))
						.addContainerGap(32, Short.MAX_VALUE)));

		jPanel33.setBackground(new java.awt.Color(255, 255, 255));
		jPanel33.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

		riceSubsidyLabel.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
		riceSubsidyLabel.setText("Rice Subsidy");

		riceSubsidyValue.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
		riceSubsidyValue.setText(Double.toString(employeeComp.getRiceSubsidy()));

		phoneAllowanceLabel.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
		phoneAllowanceLabel.setText("Phone Allowance");

		phoneAllowanceValue.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
		phoneAllowanceValue.setText(Double.toString(employeeComp.getPhoneAllowance()));

		totalAllowanceLabel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
		totalAllowanceLabel.setText("Total Allowances");

		totalAllowanceValue.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
		totalAllowanceValue.setText(numberFormat.format(totalAllowance));

		allowancesLabel.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
		allowancesLabel.setText("Allowances");

		clothingAllowanceLabel.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
		clothingAllowanceLabel.setText("Clothing Allowance");

		clothingAllowanceValue.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
		clothingAllowanceValue.setText(Double.toString(employeeComp.getClothingAllowance()));

		javax.swing.GroupLayout jPanel33Layout = new javax.swing.GroupLayout(jPanel33);
		jPanel33.setLayout(jPanel33Layout);
		jPanel33Layout.setHorizontalGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel33Layout.createSequentialGroup().addGap(17, 17, 17).addComponent(allowancesLabel)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(jPanel33Layout.createSequentialGroup().addGap(37, 37, 37)
						.addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(phoneAllowanceLabel).addComponent(riceSubsidyLabel)
								.addComponent(totalAllowanceLabel).addComponent(clothingAllowanceLabel))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
						.addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(phoneAllowanceValue, javax.swing.GroupLayout.PREFERRED_SIZE, 132,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(riceSubsidyValue, javax.swing.GroupLayout.PREFERRED_SIZE, 132,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(totalAllowanceValue, javax.swing.GroupLayout.PREFERRED_SIZE, 132,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(clothingAllowanceValue, javax.swing.GroupLayout.PREFERRED_SIZE, 132,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(39, 39, 39)));
		jPanel33Layout.setVerticalGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel33Layout.createSequentialGroup().addGap(12, 12, 12).addComponent(allowancesLabel)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(riceSubsidyLabel).addComponent(riceSubsidyValue))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(phoneAllowanceLabel).addComponent(phoneAllowanceValue))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(clothingAllowanceLabel).addComponent(clothingAllowanceValue))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
						.addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(totalAllowanceLabel).addComponent(totalAllowanceValue))
						.addGap(18, 18, 18)));

		jPanel11.setBackground(new java.awt.Color(255, 255, 255));
		jPanel11.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
		jPanel11.setPreferredSize(new java.awt.Dimension(280, 299));

		firstName.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
		firstName.setText("First Name");

		firstNameValue.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
		firstNameValue.setText(employeeGI.getFirstName());

		lastName.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
		lastName.setText("Last Name");

		lastNameValue.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
		lastNameValue.setText(employeeGI.getLastName());

		birthday.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
		birthday.setText("Birthday");

		birthdayValue.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
		birthdayValue.setText(employeeGI.getBirthday());

		phoneNumber.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
		phoneNumber.setText("Phone Number");

		phoneNumberValue.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
		phoneNumberValue.setText(employeeGI.getPhoneNumber());

		javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
		jPanel11.setLayout(jPanel11Layout);
		jPanel11Layout.setHorizontalGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel11Layout.createSequentialGroup().addGap(28, 28, 28).addGroup(jPanel11Layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(phoneNumberValue, javax.swing.GroupLayout.PREFERRED_SIZE, 201,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addComponent(phoneNumber).addComponent(birthday).addComponent(lastName)
								.addComponent(firstName)
								.addComponent(firstNameValue, javax.swing.GroupLayout.DEFAULT_SIZE, 201,
										Short.MAX_VALUE)
								.addComponent(lastNameValue, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(birthdayValue, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
						.addContainerGap(62, Short.MAX_VALUE)));
		jPanel11Layout.setVerticalGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel11Layout.createSequentialGroup().addGap(28, 28, 28).addComponent(firstName)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(firstNameValue)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(lastName)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(lastNameValue)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(birthday)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(birthdayValue)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(phoneNumber)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(phoneNumberValue)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		jPanel3.setBackground(new java.awt.Color(255, 255, 255));
		jPanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
		jPanel3.setPreferredSize(new java.awt.Dimension(280, 277));

		status.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
		status.setText("Status");

		statusValue.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
		statusValue.setText(employeeGI.getStatus());

		position.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
		position.setText("Position");

		positionValue.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
		positionValue.setText(employeeGI.getPosition());

		immediateSupervisor.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
		immediateSupervisor.setText("Immediate Supervisor");

		immediateSupervisorValue.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
		immediateSupervisorValue.setText(employeeGI.getImmediateSupervisor());

		hourlyRate.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
		hourlyRate.setText("Hourly Rate");

		hourlyRateValue.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
		hourlyRateValue.setText(Double.toString(employeeComp.getHourlyRate()));

		javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
		jPanel3.setLayout(jPanel3Layout);
		jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel3Layout.createSequentialGroup().addGap(30, 30, 30)
						.addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addComponent(hourlyRate).addComponent(immediateSupervisor).addComponent(position)
								.addComponent(status)
								.addComponent(statusValue, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
								.addComponent(positionValue, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(immediateSupervisorValue, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(hourlyRateValue, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addContainerGap(60, Short.MAX_VALUE)));
		jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel3Layout.createSequentialGroup().addGap(29, 29, 29).addComponent(status)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(statusValue)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(position)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(positionValue)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(immediateSupervisor)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(immediateSupervisorValue)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(hourlyRate)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(hourlyRateValue)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		jPanel4.setBackground(new java.awt.Color(255, 255, 255));
		jPanel4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
		jPanel4.setPreferredSize(new java.awt.Dimension(280, 277));

		sssNumber.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
		sssNumber.setText("SSS Number");

		sssNumberValue.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
		sssNumberValue.setText(employeeGI.getSSSNumber());

		philhealthNumber.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
		philhealthNumber.setText("PhilHealth Number");

		philhealthNumberValue.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
		philhealthNumberValue.setText(employeeGI.getPhilHealthNumber());

		pagibigNumber.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
		pagibigNumber.setText("Pag-ibig Number");

		pagibigNumberValue.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
		pagibigNumberValue.setText(employeeGI.getPagibigNumber());

		tinNumber.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
		tinNumber.setText("TIN Number");

		tinNumberValue.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
		tinNumberValue.setText(employeeGI.getTinNumber());

		javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
		jPanel4.setLayout(jPanel4Layout);
		jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel4Layout.createSequentialGroup().addGap(33, 33, 33).addGroup(jPanel4Layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false).addComponent(tinNumber)
						.addComponent(pagibigNumber).addComponent(philhealthNumber).addComponent(sssNumber)
						.addComponent(sssNumberValue, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
						.addComponent(philhealthNumberValue, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(pagibigNumberValue, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(tinNumberValue, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel4Layout.createSequentialGroup().addGap(29, 29, 29).addComponent(sssNumber)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(sssNumberValue)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(philhealthNumber)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(philhealthNumberValue)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(pagibigNumber).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(pagibigNumberValue)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(tinNumber)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(tinNumberValue)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
		jPanel12.setLayout(jPanel12Layout);
		jPanel12Layout.setHorizontalGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel12Layout.createSequentialGroup().addContainerGap().addGroup(jPanel12Layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
						.addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(jPanel12Layout.createSequentialGroup()
								.addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 297,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 297,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE))
						.addGroup(jPanel12Layout.createSequentialGroup().addGroup(jPanel12Layout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addComponent(jPanel31, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jPanel33, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		jPanel12Layout.setVerticalGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel12Layout.createSequentialGroup().addContainerGap().addGroup(jPanel12Layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
						.addGroup(jPanel12Layout.createSequentialGroup()
								.addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jPanel33, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE)
								.addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		jScrollPane1.setViewportView(jPanel12);

		// Get the vertical scrollbar from the JScrollPane
		JScrollBar verticalScrollBar = jScrollPane1.getVerticalScrollBar();

		// Reduce the unit increment for slower scrolling
		int newUnitIncrement = 10;
		verticalScrollBar.setUnitIncrement(newUnitIncrement);

		// Add an AdjustmentListener to the vertical scrollbar
		verticalScrollBar.addAdjustmentListener(new AdjustmentListener() {
			@Override
			public void adjustmentValueChanged(AdjustmentEvent e) {
				// Adjust the block increment if needed
				int newBlockIncrement = 50;
				verticalScrollBar.setBlockIncrement(newBlockIncrement);
			}
		});

		monthDropdown.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "January", "February", "March",
				"April", "May", "June", "July", "August", "September", "October", "November", "December" }));

		monthDropdown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				monthDropdownActionPerformed(e);
			}
		});

		computeButton.setText("Compute");
		computeButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					computeButtonActionPerformed(evt);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		submitLeaveRequestButton.setText("Submit Leave Request");
		submitLeaveRequestButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				backToEmployeeListButtonActionPerformed(evt);
			}
		});

		welcomeLabel.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
		welcomeLabel.setText("Welcome, " + employeeGI.getLastName() + ".");

//		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
//		jPanel1.setLayout(jPanel1Layout);
//		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//				.addGroup(jPanel1Layout.createSequentialGroup().addContainerGap(41, Short.MAX_VALUE)
//						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//								.addComponent(welcomeLabel)
//								.addGroup(jPanel1Layout
//										.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
//										.addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING,
//												javax.swing.GroupLayout.PREFERRED_SIZE, 948,
//												javax.swing.GroupLayout.PREFERRED_SIZE)
//										.addGroup(jPanel1Layout.createSequentialGroup()
//												.addComponent(submitLeaveRequestButton,
//														javax.swing.GroupLayout.PREFERRED_SIZE, 206,
//														javax.swing.GroupLayout.PREFERRED_SIZE)
//												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
//														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//												.addComponent(monthDropdown, javax.swing.GroupLayout.PREFERRED_SIZE,
//														179, javax.swing.GroupLayout.PREFERRED_SIZE)
//												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
//												.addComponent(computeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 89,
//														javax.swing.GroupLayout.PREFERRED_SIZE))))
//						.addContainerGap(41, Short.MAX_VALUE)));
//		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//				.addGroup(jPanel1Layout.createSequentialGroup().addContainerGap(39, Short.MAX_VALUE)
//						.addComponent(welcomeLabel)
//						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
//						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
//								.addComponent(computeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33,
//										javax.swing.GroupLayout.PREFERRED_SIZE)
//								.addComponent(monthDropdown, javax.swing.GroupLayout.PREFERRED_SIZE, 33,
//										javax.swing.GroupLayout.PREFERRED_SIZE)
//								.addComponent(submitLeaveRequestButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33,
//										javax.swing.GroupLayout.PREFERRED_SIZE))
//						.addGap(12, 12, 12).addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 438,
//								javax.swing.GroupLayout.PREFERRED_SIZE)
//						.addGap(27, 27, 27)));
//
//		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
//		getContentPane().setLayout(layout);
//		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(
//				jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
//		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//				.addGroup(layout.createSequentialGroup()
//						.addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
//								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
//						.addGap(0, 0, Short.MAX_VALUE)));

		logoutButton.setText("Log Out");
		logoutButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				logoutButtonActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addContainerGap(41, Short.MAX_VALUE)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(welcomeLabel)
								.addGroup(jPanel1Layout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
										.addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING,
												javax.swing.GroupLayout.PREFERRED_SIZE, 948,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGroup(jPanel1Layout.createSequentialGroup()
												.addComponent(submitLeaveRequestButton,
														javax.swing.GroupLayout.PREFERRED_SIZE, 206,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(monthDropdown, javax.swing.GroupLayout.PREFERRED_SIZE,
														179, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(computeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 89,
														javax.swing.GroupLayout.PREFERRED_SIZE))))
						.addContainerGap(41, Short.MAX_VALUE))
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
						jPanel1Layout.createSequentialGroup()
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(logoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 94,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addContainerGap()));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addContainerGap()
						.addComponent(logoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 21,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, Short.MAX_VALUE).addComponent(welcomeLabel)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(computeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(monthDropdown, javax.swing.GroupLayout.PREFERRED_SIZE, 33,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(submitLeaveRequestButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(12, 12, 12).addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 438,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(27, 27, 27)));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(0, 0, Short.MAX_VALUE)));

		pack();

		// Must be called after setting pack
		setLocationRelativeTo(null);
	}// </editor-fold>

	private void computeButtonActionPerformed(java.awt.event.ActionEvent evt) throws IOException {

		// Reset values for hours rendered
		resetSummaryValues();

		// Compute for the hoursRendered
		loadAttendanceRecordsFromJsonFile(JsonFileHandler.getAttendanceJsonPath());

		// Compute for the Gross Salary
		Double grossSalary = computeGrossSalary();

		grossSalaryValue.setText(numberFormat.format(computeGrossSalary()));
		grossSalaryValue1.setText(numberFormat.format(computeGrossSalary()));

		// Compute for deductions
		Double sssDeduction = SalaryCalculator.getSSS(grossSalary);
		Double philhealthDeduction = SalaryCalculator.getPhilHealth(grossSalary);
		Double pagibigDeduction = SalaryCalculator.getPagibig(grossSalary);
		Double totalDeductions = sssDeduction + philhealthDeduction + pagibigDeduction;

		sssDeductionsValue.setText(numberFormat.format(sssDeduction));
		philhealthDeductionsValue.setText(numberFormat.format(philhealthDeduction));
		pagibigDeductionsValue.setText(numberFormat.format(pagibigDeduction));
		totalDeductionsValue.setText(numberFormat.format(totalDeductions));

		// Compute for Taxable Salary
		Double taxableSalary = grossSalary - totalDeductions;

		taxableSalaryValue.setText(numberFormat.format(taxableSalary));

		// Compute for Withholding Tax
		Double withholdingTax = SalaryCalculator.getWithholding(taxableSalary);

		withHoldingTaxValue.setText(numberFormat.format(withholdingTax));

		// Compute for Salary After Tax
		Double salaryAfterTax = taxableSalary - withholdingTax;

		salaryAfterTaxValue.setText(numberFormat.format(salaryAfterTax));

		// Compute for Net Salary
		Double netSalary = salaryAfterTax + totalAllowance;

		netSalaryValue.setText(numberFormat.format(netSalary));

	}

	private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				// Remove the EmployeesPage Window
				dispose();

				new LoginPage().setVisible(true);
			}
		});
	}

	private void backToEmployeeListButtonActionPerformed(java.awt.event.ActionEvent evt) {
		// Go back to the employee list page
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				// Remove the EmployeesPage Window
				dispose();

				new LeaveRequestPage(employeeGI, employeeComp).setVisible(true);
			}
		});
	}

	private void monthDropdownActionPerformed(java.awt.event.ActionEvent evt) {

		// Reset values for hours rendered
		resetSummaryValues();

		// Get the selected item
		selectedMonth = ((String) monthDropdown.getSelectedItem()).toUpperCase();
	}

	public void loadAttendanceRecordsFromJsonFile(String filePath) throws IOException {

		// Load the JSON file as a JsonArray
		JsonArray jsonArray = JsonFileHandler.getAttendanceJSON(filePath);

		// Loop through each element in the array and create an AttendanceData object
		// for each one
		for (JsonElement element : jsonArray) {

			JsonObject attendanceJson = element.getAsJsonObject();
			String employeeNum = attendanceJson.get("employeeNum").getAsString();
			LocalDateTime month = SalaryCalculator.getTimeInOrOut(attendanceJson, "time_in");

			if (employeeNum.equals(employeeGI.getEmployeeNumber())
					&& month.getMonth().equals(Month.valueOf(selectedMonth))) {

				String date = attendanceJson.get("date").getAsString();
				String timeIn = attendanceJson.get("time_in").getAsString();
				String timeOut = attendanceJson.get("time_out").getAsString();
				String hoursRendered = SalaryCalculator.getAttendance(attendanceJson, Month.valueOf(selectedMonth),
						presentsNum, latesNum, absentsNum, hoursRenderedNum);
				String present = isPresent(hoursRendered);
			}
		}

		// Set the hours rendered to the label
		hoursRenderedValue.setText(hoursRenderedNum.toString());
	}

	public Double computeGrossSalary() {
		return hoursRenderedNum.get() * employeeComp.getHourlyRate();
	}

	public String isPresent(String hoursRendered) {
		if (!hoursRendered.equals("0"))
			return "Present";
		return "Absent";
	}

	public void resetSummaryValues() {
		this.absentsNum = new AtomicInteger(0);
		this.hoursRenderedNum = new AtomicInteger(0);
		this.latesNum = new AtomicInteger(0);
		this.presentsNum = new AtomicInteger(0);
	}
}
