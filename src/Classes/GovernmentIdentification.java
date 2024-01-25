package Classes;

import java.io.IOException;

public class GovernmentIdentification extends EmployeeInformation {
	
	private String employeeNumber = getEmployeeNumber();
	private String sssNumber;
	private String philHealthNumber;
	private String pagibigNumber;
	private String tinNumber;
	

	public GovernmentIdentification(String userId, String password) throws IOException {
		super(userId, password);
		// TODO Auto-generated constructor stub
	}
	
	public GovernmentIdentification(String employeeNumber) {
    	super(employeeNumber);
    }
	
	public void setSSSNumber(String value) {
		this.sssNumber = value;
	}
	
	public void setPhilHealthNumber(String value) {
		this.philHealthNumber = value;
	}
	
	public void setPagibigNumber(String value) {
		this.pagibigNumber = value;
	}
	
	public void setTinNumber(String value) {
		this.tinNumber = value;
	}
	
	public String getSSSNumber() {
		return sssNumber;
	}
	
	public String getPhilHealthNumber() {
		return philHealthNumber;
	}

	public String getPagibigNumber() {
		return pagibigNumber;
	}
	
	public String getTinNumber() {
		return tinNumber;
	}
}
