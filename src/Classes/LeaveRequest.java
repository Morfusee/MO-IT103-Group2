package Classes;

import java.io.IOException;
import java.util.UUID;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import UtilityClasses.JsonFileHandler;

public class LeaveRequest {
	private String id;
	private String employeeNum;
	private String first_name;
	private String last_name;
	private String startDate;
	private String endDate;
	private String notes;
	private String leave_type;
	private String approved = "Not Approved Yet.";

	public LeaveRequest(String employeeNum) {
		this.setEmployeeNum(employeeNum);
		this.setId(UUID.randomUUID().toString());
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getLeave_type() {
		return leave_type;
	}

	public void setLeave_type(String leave_type) {
		this.leave_type = leave_type;
	}

	public String isApproved() {
		return approved;
	}

	public void setApproved(String approved) {
		this.approved = approved;
	}

	public String getEmployeeNum() {
		return employeeNum;
	}

	public void setEmployeeNum(String employeeNum) {
		this.employeeNum = employeeNum;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public static void setLeaveRequestInformationObject(String value, LeaveRequest leaveRequest) throws IOException {

		// Iterate through the JSON file for the employee data
		JsonObject employeeData = JsonFileHandler.nameIterator(JsonFileHandler.getLeaveRequestJSON(), "id", value);

		// Instantiate Gson to get their Json counterparts
		Gson gson = new Gson();
		LeaveRequest leaveRequestInfo = gson.fromJson(employeeData, LeaveRequest.class);

		// Set the employee's identity information
		leaveRequest.setEmployeeNum(leaveRequestInfo.getEmployeeNum());
		leaveRequest.setLast_name(leaveRequestInfo.getLast_name());
		leaveRequest.setFirst_name(leaveRequestInfo.getFirst_name());
		leaveRequest.setEndDate(leaveRequestInfo.getEndDate());
		leaveRequest.setStartDate(leaveRequestInfo.getStartDate());
		leaveRequest.setLeave_type(leaveRequestInfo.getLeave_type());
		leaveRequest.setNotes(leaveRequestInfo.getNotes());
		leaveRequest.setApproved(leaveRequestInfo.isApproved());
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
