
package UtilityClasses;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import Classes.LeaveRequest;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class JsonFileHandler {

	private static final String attendanceJson = "./resources/JSON_Files/Attendance.json";

	private static final String employeesJson = "./resources/JSON_Files/Employees.json";

	private static final String loginCredentialsJson = "./resources/JSON_Files/LoginCredentials.json";

	private static final String leaveRequestCredentialsJson = "./resources/JSON_Files/LeaveRequest.json";

	private JsonFileHandler() {
		throw new AssertionError();
	}

	public static String getAttendanceJsonPath() {
		return attendanceJson;
	}

	public static String getEmployeesJsonPath() {
		return employeesJson;
	}

	public static String getLoginCredentialsJsonPath() {
		return loginCredentialsJson;
	}

	public static String getLeaveRequestJsonPath() {
		return leaveRequestCredentialsJson;
	}

	public static JsonArray getEmployeesJSON() throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(getEmployeesJsonPath()));
		Gson gson = new Gson();
		JsonArray json = gson.fromJson(reader, JsonArray.class);
		return json;
	}

	public static JsonArray getLoginCredentialsJSON() throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(getLoginCredentialsJsonPath()));
		Gson gson = new Gson();
		JsonArray json = gson.fromJson(reader, JsonArray.class);
		return json;
	}

	public static JsonArray getLeaveRequestJSON() throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(getLeaveRequestJsonPath()));
		Gson gson = new Gson();
		JsonArray json = gson.fromJson(reader, JsonArray.class);
		return json;
	}

	public static String getEmployeeInformationJSON(String desiredKey, String desiredValue) throws IOException {
		JsonArray json = getEmployeesJSON();
		for (int i = 0; i < json.size(); i++) {
			JsonObject jsonObject = json.get(i).getAsJsonObject();
			// Check if the desiredKey exists in the current JsonObject
			if (jsonObject.has(desiredKey) && jsonObject.get(desiredKey).getAsString().equals(desiredValue)) {
				return jsonObject.toString();
			}
		}
		return null;
	}

	public static JsonArray getAttendanceJSON() throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(getAttendanceJsonPath()));
		Gson gson = new Gson();
		JsonArray json = gson.fromJson(reader, JsonArray.class);
		return json;
	}

	public static JsonArray getAttendanceJSON(String filePath) throws IOException {
		// Read the JSON file into a string
		String jsonStr = new String(Files.readAllBytes(Paths.get(filePath)));

		// Parse the string into a JsonArray
		JsonArray jsonArray = JsonParser.parseString(jsonStr).getAsJsonArray();

		return jsonArray;
	}

	public static JsonObject nameIterator(JsonArray json, String ENKey, String employeeNumber) {
		for (int i = 0; i < json.size(); i++) {
			// Retrieve the current JsonObject
			JsonObject currentObject = json.get(i).getAsJsonObject();

			// Check if the JsonObject has the specified key and its value matches the
			// employeeNumber
			if (currentObject.has(ENKey) && currentObject.get(ENKey).getAsString().equals(employeeNumber)) {
				return currentObject;
			}
		}
		return null; // Employee not found in the JsonArray
	}

	public static String nameIterator(JsonArray json, String ENKey, String employeeNumber, String key) {
		for (int i = 0; i < json.size(); i++) { // iterate through the JsonArray
			String result;
			// first I get the 'i' JsonElement as a JsonObject, then I get the key as a
			// string and I compare it with the value
			if (json.get(i).getAsJsonObject().get(ENKey).getAsString().equals(employeeNumber)) {
				result = json.get(i).getAsJsonObject().get(key).getAsString();
				return result;
			}

		}
		return null;
	}

	public static void labelAssigner(JsonObject employeeData, String[] stringifiedLabels, JLabel[] labels) {
		for (int i = 0; i < labels.length; i++) {
			labels[i].setText(employeeData.get(stringifiedLabels[i + 1]).getAsString());
		}
	}

	public static boolean compareLoginCredentials(JsonArray json, String userKey, String username, String passKey,
			String password) {
		for (int i = 0; i < json.size(); i++) { // iterate through the JsonArray
			// first I get the 'i' JsonElement as a JsonObject, then I get the key as a
			// string and I compare it with the value
			if (json.get(i).getAsJsonObject().get(userKey).getAsString().equals(username)
					&& json.get(i).getAsJsonObject().get(passKey).getAsString().equals(password)) {
				return true;
			}
		}
		return false;
	}

	public static void writeJsonFile(String json, String filePath) {
		try (FileWriter writer = new FileWriter(filePath)) {
			writer.write(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void addToJsonFile(List<LeaveRequest> leaveRequests, String filePath) {
		try {
			Gson gson = new Gson();

			// Convert the list of LeaveRequest objects to a JSON array
			String jsonArray = gson.toJson(leaveRequests);

			// Write the JSON array to the file
			Files.writeString(Paths.get(filePath), jsonArray);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static List<LeaveRequest> readLeaveRequestsFromFile(String filePath) {
		try {
			String content = Files.readString(Paths.get(filePath));

			// Check if the content is empty or not a valid JSON array
			if (content.isEmpty() || !content.trim().startsWith("[") || !content.trim().endsWith("]")) {
				// If so, return an empty list or handle the case as needed
				return new ArrayList<>();
			} else {
				// Otherwise, create a new ArrayList from the array returned by fromJson
				LeaveRequest[] leaveRequestsArray = new Gson().fromJson(content, LeaveRequest[].class);
				return new ArrayList<>(Arrays.asList(leaveRequestsArray));
			}
		} catch (IOException e) {
			e.printStackTrace();
			return new ArrayList<>();
		}
	}

	public static void removeJsonObject(JsonArray jsonArray, String key, String value) {
		Iterator<JsonElement> iterator = jsonArray.iterator();
		while (iterator.hasNext()) {
			JsonElement element = iterator.next();
			if (element.isJsonObject()) {
				JsonObject jsonObject = element.getAsJsonObject();
				if (jsonObject.has(key) && jsonObject.get(key).getAsString().equals(value)) {
					iterator.remove(); // Remove the object from the JsonArray
					break; // Assuming there is only one object with the specified value
				}
			}
		}
	}
}
