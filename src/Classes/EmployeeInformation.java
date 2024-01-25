package Classes;

import java.io.IOException;

public class EmployeeInformation extends User {

    private String employeeNumber = getEmployeeNumber();
    private String lastName;
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
}
