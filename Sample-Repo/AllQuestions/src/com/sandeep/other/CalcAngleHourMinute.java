package com.sandeep.other;

public class CalcAngleHourMinute {

	public static void main(String[] args) {
		
		System.out.println(calcAngle(9, 30));

	}

	private static int calcAngle(double hour, double min) {
		
		if (hour < 0 || min < 0 || hour > 12 || min > 60) {
			System.out.println("Wrong input");
		}

		if (hour == 12) {
			hour = 0;
		}
		
		if (min == 60) {
			min = 60;
		}
		
		int hourAngle = (int)(0.5 * ((60 * hour) + min));
		int minAngle = (int)(6 * min);
		
		int angle = Math.abs(hourAngle - minAngle);
		
		// if angle > 180, subtract it with 360 degrees
		// and return the minimum of those angles
		angle = Math.min(360 - angle, angle);
		
		return angle;
		
	}

}
