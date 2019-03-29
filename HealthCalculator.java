package all_code;

import java.util.Scanner;

/*
 * name:Jeehyuep Kwon
 * date: November 19, 2018
 * Purpose : display the Health status of user.
 */

public class HealthCalculator {
	
	static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		String userName = "";
		byte userAge = 0;
		String userGender = "";
		float userHeight = 0;
		int userWeight = 0;
		byte maxmumHeartRate = 0;
		float targetHeartRate = 0;
		float bodyMassIndex = 0;
		String healthConditionCheck = "";
		
		displayPurpose();
		
		userName = getUserName(userName);
		userAge = getUserAge1(userName, userAge);
		userGender = getUserGender(userName, userGender);
		userHeight = getUserHeight(userName, userHeight);
		userWeight = getUserWeight(userName, userWeight);
		maxmumHeartRate = getMaxmumHeartRate(maxmumHeartRate);
		targetHeartRate = getTargetHeartRate(maxmumHeartRate, targetHeartRate);
		bodyMassIndex = getBodyMassIndex(userHeight, userWeight, bodyMassIndex);
		healthConditionCheck = getHealthStatus(bodyMassIndex);
		
		displayOutput(userName, userAge, userGender, userHeight, userWeight, maxmumHeartRate, targetHeartRate, bodyMassIndex, healthConditionCheck);
		
		
	}
	
	private static void displayPurpose() {
		System.out.println("=======================================");
		System.out.println("====display the Health status of user==");
		System.out.println("=======================================");
		
	}
	
	private static String getUserName(String userName) {
		
		System.out.print("Put your name : ");
		userName = input.nextLine();
		return userName;
		
	}
	
	private static byte getUserAge1(String userName, byte userAge) {
		
		do {
			System.out.printf("%s, Put your age : ", userName);
			userAge = input.nextByte();
			input.nextLine();
			
			if(userAge < 0 || userAge > 120) {
				System.out.printf("%s, Put your age again : ", "Invalid!!");
			}
		} while (userAge < 0 || userAge > 120);
		
		return userAge;
	}
	
	private static String getUserGender(String userName, String userGender) {
		
		System.out.printf("%s, Put your gender(M or F) : ", userName);
		userGender = input.nextLine();
		userGender = userGender.trim();
		
		while(!userGender.equalsIgnoreCase("M") && !userGender.equalsIgnoreCase("F")) {
			System.out.printf("%s %s, Put your gender(M or F) again : %n", "Invalid!!", userName);
			userGender = input.nextLine();
			userGender = userGender.trim();
		}
		return userGender;
		
		
	}
	
	private static float getUserHeight(String userName, float userHeight) {
		
		do {
			System.out.printf("%s, Put your height(inch): %n", userName);
			userHeight = input.nextFloat();
			if(userHeight < 21.5 || userHeight >107.1) {
				System.out.printf("%s %s, Put your height(inch) again : %n", "Invalid!!", userName);
				userHeight = input.nextFloat();
			}
		} while (userHeight < 21.5 || userHeight >107.1);
		
		return userHeight;
	}
	
	private static int getUserWeight(String userName, int userWeight) {
		
		System.out.printf("%s, Put your weight(pound): %n", userName);
		userWeight = input.nextInt();
		while(userWeight < 1 || userWeight > 1400) {
			
			System.out.printf("%s %s, Put your weight(pound) again : %n", "Invalid!!", userName);
			userWeight = input.nextInt();
		}
		return userWeight;
	}
	
	private static byte getMaxmumHeartRate(byte maxmumHeartRate) {
		
		return (byte) (maxmumHeartRate - 220);
	}
	
	private static float getTargetHeartRate(byte maxmumHeartRate, float targetHeartRate) {
		return targetHeartRate  = (float) (maxmumHeartRate * 0.5 * 100);
	}
	
	private static float getBodyMassIndex(float userHeight, int userWeight, float bodyMassIndex) {
		return bodyMassIndex = (userWeight * 703)/(userHeight * userHeight);	
	}
	
	private static String getHealthStatus(float bodyMassIndex) {
		if(bodyMassIndex > 0 ||bodyMassIndex < 18.5) {
			return "underweight";
		} else if ((bodyMassIndex < 24.9)){
			return "normal weight";
		}else if ((bodyMassIndex < 29.9)){
			return "overweight";
		}else if ((bodyMassIndex > 30)){
			return "obese";
		}
		return "Invalid!!";
	}
	
	public static void displayOutput(String userName, byte userAge, String userGender, float userHeight, int userWeight, byte maxmumHeartRate, float targetHeartRate, float bodyMassIndex, String healthConditionCheck){
		
		System.out.println("----------------------Output-----------------------");
		System.out.printf("%30s : %s%n", "Your name", userName);
		System.out.printf("%30s : %s%n", "Your age", userAge);
		System.out.printf("%30s : %s%n", "Your gender", userGender);
		System.out.printf("%30s : %s%n", "Your height", userHeight);
		System.out.printf("%30s : %s%n", "Your weight", userWeight);
		System.out.printf("%30s : %s%n", "Your maxmumHeartRate", maxmumHeartRate);
		System.out.printf("%30s : %s%n", "Your targetHeartRate", targetHeartRate);
		System.out.printf("%30s : %s%n", "Your bodyMassIndex", bodyMassIndex);
		System.out.printf("%30s : %s%n", "Your healthConditionCheck", healthConditionCheck);
		System.out.println("---------------------------------------------------");
	}

	
	
	
	
}
