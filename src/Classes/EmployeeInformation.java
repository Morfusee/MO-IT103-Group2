package Classes;

import java.io.IOException;

import com.google.gson.annotations.SerializedName;

public class EmployeeInformation extends User {

	@SerializedName("last_name")
	private String lastName;
	
	@SerializedName("first_name")
	private String firstName;
	
	private String birthday;
	private String address;
	private String phoneNumber;
	private String position;
	private String immediateSupervisor;
	private double hourlyRate;

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
	
	public String getLastName() {
		return lastName;
	}
	
	public String getFirstName() {
		return firstName;
	}
}
