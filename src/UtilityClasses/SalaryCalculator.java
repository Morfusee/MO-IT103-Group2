package UtilityClasses;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.atomic.AtomicInteger;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class SalaryCalculator {

	private SalaryCalculator() {
		throw new AssertionError();
	}

	public static int getNumberOfElements(JsonArray json, String ENKey, String employeeNumber, Month month) {
		int numberOfElements = 0;
		for (int i = 0; i < json.size(); i++) {
			LocalDateTime dateTime = getTimeIn(json, i);
			if (json.get(i).getAsJsonObject().get(ENKey).getAsString().equals(employeeNumber)
					&& dateTime.getMonth().equals(month)) {
				numberOfElements++;
			}
		}
		return numberOfElements;
	}

	/*****************************
	 * TIME IN AND TIME OUT
	 *****************************/

	public static LocalDateTime getTimeIn(JsonArray json, int i) {
		String time_in = json.get(i).getAsJsonObject().get("time_in").getAsString();
		String date = json.get(i).getAsJsonObject().get("date").getAsString();

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm");
		LocalDateTime dateTime = LocalDateTime.parse(date + " " + time_in, formatter);
		return dateTime;
	}

	public static LocalDateTime getTimeInOrOut(JsonObject json, String inOrOut) {
		String timeInOrOut = json.get(inOrOut).getAsString();
		String date = json.get("date").getAsString();

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm");
		LocalDateTime dateTime = LocalDateTime.parse(date + " " + timeInOrOut, formatter);
		return dateTime;
	}

	public static LocalDateTime getTimeOut(JsonArray json, int i) {
		String time_out = json.get(i).getAsJsonObject().get("time_out").getAsString();
		String date = json.get(i).getAsJsonObject().get("date").getAsString();

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm");
		LocalDateTime dateTime = LocalDateTime.parse(date + " " + time_out, formatter);
		return dateTime;
	}

	/*****************************
	 * ATTENDANCE
	 *****************************/

	public static long[] getAttendance(JsonArray json, String ENKey, String employeeNumber, int numberOfElements,
			Month currentMonth) {
		long[] attendance = new long[numberOfElements];
		AtomicInteger index = new AtomicInteger(0);

		for (int i = 0; i < json.size(); i++) {
			getAttendanceResult(i, ENKey, employeeNumber, json, currentMonth, attendance, index);
		}
		return attendance;
	}

	public static String getAttendance(JsonObject json, Month currentMonth, AtomicInteger presentsNum,
			AtomicInteger latesNum, AtomicInteger absentsNum, AtomicInteger hoursRenderedNum) {
		long attendance = 0;
		LocalDateTime dateTime1 = SalaryCalculator.getTimeInOrOut(json, "time_in");
		LocalDateTime dateTime2 = SalaryCalculator.getTimeInOrOut(json, "time_out");

		long duration = java.time.Duration.between(dateTime1, dateTime2).toHours();
		long mins = java.time.Duration.between(dateTime1, dateTime2).toMinutes();

		if (dateTime1.getMonth().equals(currentMonth)) {
			if (mins > 529 && mins < 540) {
				presentsNum.incrementAndGet();
				attendance = duration + 1;
			} else {
				checkIfPresent(mins, presentsNum);
				attendance = duration;
			}
		}

		if (mins < 530 && mins > 0) {
			latesNum.incrementAndGet();
		}

		if (mins == 0) {
			absentsNum.incrementAndGet();
		}

		hoursRenderedNum.addAndGet((int) attendance);

		return String.valueOf(attendance);
	}

	private static void getAttendanceResult(int i, String ENKey, String employeeNumber, JsonArray json,
			Month currentMonth, long[] attendance, AtomicInteger index) {
		if (json.get(i).getAsJsonObject().get(ENKey).getAsString().equals(employeeNumber)) {

			LocalDateTime dateTime1 = getTimeIn(json, i);
			LocalDateTime dateTime2 = getTimeOut(json, i);

			long duration = java.time.Duration.between(dateTime1, dateTime2).toHours();
			long mins = java.time.Duration.between(dateTime1, dateTime2).toMinutes();

			if (dateTime1.getMonth().equals(currentMonth)) {
				if (mins > 529 && mins < 540) {
					attendance[index.getAndIncrement()] = duration + 1;
				} else {
					attendance[index.getAndIncrement()] = duration;
				}
			}
		}
	}

	public static long getSumOfAttendance(long[] attendance) {
		long sum = 0;
		for (int i = 0; i < attendance.length; i++) {
			sum += attendance[i];
		}
		return sum;
	}

	/*****************************
	 * DEDUCTIONS
	 *****************************/

	public static double getPhilHealth(double salary) {
		if (salary > 60000)
			return 1800 / 2;

		if ((salary < 60000) && (salary > 10000)) {
			double result = (salary * 0.03) / 2;
			return result;
		}

		if ((salary <= 10000) && (salary > 0))
			return 300 / 2;

		return 0;
	}

	public static double getSSS(double salary) {
		double[] compensationRanges = { 3250, 3750, 4250, 4750, 5250, 5750, 6250, 6750, 7250, 7750, 8250, 8750, 9250,
				9750, 10250, 10750, 11250, 11750, 12250, 12750, 13250, 13750, 14250, 14750, 15250, 15750, 16250, 16750,
				17250, 17750, 18250, 18750, 19250, 19750, 20250, 20750, 21250, 21750, 22250, 22750, 23250, 23750, 24250,
				24750, Double.MAX_VALUE };

		double[] contributions = { 135.00, 157.50, 180.00, 202.50, 225.00, 247.50, 270.00, 292.50, 315.00, 337.50,
				360.00, 382.50, 405.00, 427.50, 450.00, 472.50, 495.00, 517.50, 540.00, 562.50, 585.00, 607.50, 630.00,
				652.50, 675.00, 697.50, 720.00, 742.50, 765.00, 787.50, 810.00, 832.50, 855.00, 877.50, 900.00, 922.50,
				945.00, 967.50, 990.00, 1012.50, 1035.00, 1057.50, 1080.00, 1102.50, 1125.00 };

		double contribution = 0.0;

		if (salary != 0) {
			for (int i = 0; i < compensationRanges.length; i++) {
				if (salary < compensationRanges[i]) {
					contribution = contributions[i];
					break;
				}
			}
		}
		return contribution;
	}

	public static double getPagibig(double salary) {
		if (salary > 1500)
			return 100;

		if ((salary < 1500) && (salary > 1000))
			return 50;

		return 0;
	}

	public static double getWithholding(double salary) {
		double result = 0;
		if (salary >= 666667)
			return result = ((salary - 666667) * 0.35) + 200833.33;

		if ((salary < 666667) && (salary >= 166667))
			return result = ((salary - 166667) * 0.32) + 40833.33;

		if ((salary < 166667) && (salary >= 66667))
			return result = ((salary - 66667) * 0.30) + 10833;

		if ((salary < 66667) && (salary >= 33333))
			return result = ((salary - 33333) * 0.25) + 2500;

		if ((salary < 33333) && (salary >= 20833))
			return result = ((salary - 20833) * 0.20);

		if (salary <= 20832)
			return 0;

		return 0;
	}

	/***********************************************
	 * METHODS CALLED WITHIN THE CLASS / OTHER METHODS
	 ***********************************************/

	private static void checkIfPresent(long mins, AtomicInteger presentsNum) {
		if (mins != 0)
			presentsNum.incrementAndGet();
	}

}
