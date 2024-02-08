/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import UtilityClasses.JsonFileHandler;
import java.io.IOException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.gson.annotations.SerializedName;

public class User {

	@SerializedName("employeeNum")
	private String employeeNumber;
	private String userId;
	private String password;
	private Boolean isVerified = false;
	private Date dateRegistered;
	private Boolean loginStatus = false;
	private Boolean isAdmin = false;

	public User(String userId, String password) throws IOException {
		this.userId = userId;
		this.password = password;
		if (!userId.equals("") && !password.equals("")) {
			authenticateLogin();
		}
	}

	public User(String employeeNumber) {
		setEmployeeNumber(employeeNumber);
	}

	public String getEmployeeNumber() {
		return employeeNumber;
	}

	public void setEmployeeNumber(String value) {
		this.employeeNumber = value;
	}

	/* userId getter/setter */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserId() {
		return userId;
	}

	/* password getter/setter */
	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	/* isVerified getter/setter */
	public void setIsVerified(Boolean isVerified) {
		this.isVerified = isVerified;
	}

	public Boolean getIsVerified() {
		return isVerified;
	}

	/* date of registration getter/setter */
	public void setDateRegistered(Date dateRegistered) {
		this.dateRegistered = dateRegistered;
	}

	public Date getDateRegistered() {
		return dateRegistered;
	}

	/* login status getter/setter */
	public void setLoginStatus(Boolean loginStatus) {
		this.loginStatus = loginStatus;
	}

	public Boolean getLoginStatus() {
		return loginStatus;
	}

	public void setIsAdmin(Boolean value) {
		this.isAdmin = value;
	}

	public Boolean getIsAdmin() {
		return isAdmin;
	}

	public void authenticateLogin() throws IOException {
		if (!userId.equals("admin")) {
			// Set the employee number if the user is not an admin
			setEmployeeNumber(JsonFileHandler.nameIterator(JsonFileHandler.getLoginCredentialsJSON(), "username",
					userId, "employeeNum"));

			// Check the login status
			setLoginStatus(JsonFileHandler.compareLoginCredentials(JsonFileHandler.getLoginCredentialsJSON(),
					"username", userId, "password", password));
			return;
		}

		// Check if user is an admin
		setLoginStatus(authenticateAdminLogin(userId, password));
		return;
	}

	private Boolean authenticateAdminLogin(String userId, String password) {
		if (userId.equals("admin") && password.equals("123")) {
			setIsAdmin(true);
			return true;
		}
		return false;
	}
}
