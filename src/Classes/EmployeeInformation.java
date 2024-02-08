package Classes;

import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

import UtilityClasses.JsonFileHandler;

public class EmployeeInformation extends User {

	@SerializedName("last_name")
	private String lastName;

	@SerializedName("first_name")
	private String firstName;

	private String birthday;
	private String address;

	@SerializedName("phone_number")
	private String phoneNumber;

	@SerializedName("Position")
	private String position;

	@SerializedName("immediate_supervisor")
	private String immediateSupervisor;

	@SerializedName("hourly_rate")
	private double hourlyRate;

	@SerializedName("Status")
	private String status;

	public EmployeeInformation(String userId, String password) throws IOException {
		super(userId, password);
	}

	public EmployeeInformation(String employeeNumber) {
		super(employeeNumber);
	}

	public void setHourlyRate(double value) {
		this.hourlyRate = value;
	}

	public double getHourlyRate() {
		return hourlyRate;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getImmediateSupervisor() {
		return immediateSupervisor;
	}

	public void setImmediateSupervisor(String immediateSupervisor) {
		this.immediateSupervisor = immediateSupervisor;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public static void setEmployeeInformationObject(String employeeNumber, GovernmentIdentification employeeGI,
			Compensation employeeComp) throws IOException {

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
