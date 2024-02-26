package UtilityClasses;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Pattern;

import javax.swing.JTextField;

public class DataValidators {
	public static boolean isNumeric(String str) {
		try {
			// Attempt to parse the input as a number
			Double.parseDouble(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public static boolean isPureString(String str) {
		String regex = "^[^0-9]+$";

		if (Pattern.matches(regex, str)) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean isSSSFormattedCorrectly(String str) {
		return str.matches("\\d{2}-\\d{7}-\\d{1}");
	}

	public static boolean isPhoneNumberFormattedCorrectly(String str) {
		return str.matches("\\d{3}-\\d{3}-\\d{3}");
	}

	public static boolean isTINFormattedCorrectly(String str) {
		return str.matches("\\d{3}-\\d{3}-\\d{3}-\\d{3}");
	}

	public static boolean isProperLength(String str) {
		return str.matches("\\d{12}");
	}

	public static boolean isBirthdayFormattedCorrectly(String str) {
		return str.matches("\\d{2}/\\d{2}/\\d{2}");
	}

	public static boolean isValidDate(String dateStr) {
		// Check if the dateStr consists only of numeric characters and the required
		// separator "/"
		if (!dateStr.matches("[0-9/]+")) {
			return false;
		}

		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		sdf.setLenient(false);

		try {
			// Parse the input date. If successful, the date is valid.
			sdf.parse(dateStr);
			return true;
		} catch (ParseException e) {
			// If an exception is thrown during parsing, the date is not valid.
			return false;
		}
	}

}
