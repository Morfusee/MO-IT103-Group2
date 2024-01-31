
package UtilityClasses;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.swing.JLabel;

public class JsonFileHandler {

	private static final String attendanceJson = "./resources/JSON_Files/Attendance.json";

	private static final String employeesJson = "./resources/JSON_Files/Employees.json";

	private JsonFileHandler() {
		throw new AssertionError();
	}

	public static String getAttendanceJsonPath() {
		return attendanceJson;
	}

	public static String getEmployeesJsonPath() {
		return employeesJson;
	}

	public static JsonArray getEmployeesJSON() throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(getEmployeesJsonPath()));
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
}
