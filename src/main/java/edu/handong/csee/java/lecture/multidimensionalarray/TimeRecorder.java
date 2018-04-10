package edu.handong.csee.java.lecture.multidimensionalarray;

import java.util.Scanner;

public class TimeRecorder {
	//variable declaration
	private final int NUM_OF_WORK_DAYS = 5; // An employee works for five days from Monday to Friday 
	private int[][] hours;	//An employee working hours
	private enum WeekDays {Monday, Tuesday, Wendesday, Thursday, Friday};	//enumerate the date lists
	private int[] dayHours = new int[WeekDays.values().length];		//initialize the dayHours (integer value)
	private int[] weekHours;	//initialize the weekHours (integer value)
	
	public static void main(String[] args) {	//invoked by the system
		
		TimeRecorder myTimeRecoder = new TimeRecorder();		//Declaring the constructor
		
		myTimeRecoder.getData();		//Call the method getData
		
		myTimeRecoder.computeTotals();	//Call the method computeTotals
		
		myTimeRecoder.printResults();	//Call the method printResults

	}
	
	public void getData() {		//public void method for getting Data
		
		Scanner myScanner = new Scanner(System.in);		//create an object of the Scanner, data enter from the keyboard
		
		System.out.print("How many employees do you want" + "to process for their work time? "); //print out the question
		
		int numOfEmployees = myScanner.nextInt(); //read value from the keyboard and assign into number of Employees
		
		hours = new int[numOfEmployees][NUM_OF_WORK_DAYS]; //initialize arrays of hours
		
		for(int employeeCount=0; employeeCount < hours.length; employeeCount++) {		//repetitive statement for employee count
			
			System.out.println("Input work time for Employee " + (employeeCount+1) + ": ");		//print out the instruction
			
			for(WeekDays currentDay:WeekDays.values()) {		//repetitive statement for Weekdays
				
				System.out.print("  Input work time for Employee " + (employeeCount+1) 
									+ " on " + currentDay + ": ");		//print out the instruction
				hours[employeeCount][currentDay.ordinal()] = myScanner.nextInt();	//read value from the keyboard and assign into arrays of hours
			}
		}
		
		myScanner.close();	//close the void method
	}
	
	public void computeTotals() {		//public void method for computing the Totals
		weekHours = new int [hours.length];		//initialize the array of weekHours
		
		for(WeekDays currentDay:WeekDays.values()) {		//repetitive statement for WeekDays
			
			dayHours[currentDay.ordinal()] = 0;		//the array of dayHours is Null
			
			for(int employeeCount=0; employeeCount < hours.length; employeeCount++) {	//repetitive statement 
				dayHours[currentDay.ordinal()] = dayHours[currentDay.ordinal()] 	//calculation for dayHours
															+ hours[employeeCount][currentDay.ordinal()];
				weekHours[employeeCount] = weekHours[employeeCount] 		//calculation for weekHours
													+ hours[employeeCount][currentDay.ordinal()];
			}
		}
	}
	

	public void printResults() {	//public void method for printing the Results
		
		System.out.println();		//print out
		
		// print the first line: Employee   1   2   3   Totals
		System.out.print("Employee" + addSpace("Employee".length()));
		
		for(int employeeCount = 0; employeeCount < hours.length; employeeCount++) {		//repetitive statement for employee count
			System.out.print(employeeCount+1 + "\t");		//print out the employee count
		}
		
		System.out.print("Totals");		//print the Totals
		System.out.println();			//print
		
		// print work time per each weekday
		for(WeekDays currentDay:WeekDays.values()) {
			
			System.out.print(currentDay + addSpace(currentDay.name().length()));	//print out working time per each weekday
			for(int employCount = 0; employCount < hours.length ;employCount++) {
				System.out.print(hours[employCount][currentDay.ordinal()] + "\t");	//print the hours
			}
			System.out.print(dayHours[currentDay.ordinal()]);		//print work time per each day
			System.out.println();	//print in line breaks
		}
		
		// print total per employee
		System.out.print("Total = " + addSpace("Total = ".length()));	// print total per employee
		for(int employeeCount = 0; employeeCount < hours.length; employeeCount++) {		//repetitive statement for total
			System.out.print(weekHours[employeeCount] +"\t");	//print out working hours per week
		}
	}
	
	private String addSpace(int length) {		//private void method for strings
		
		final int maxWeekDayLength = 9;		//limit the length
		String spaces = " ";			//initialize the space
		
		for(int spaceCount=0; spaceCount < maxWeekDayLength-length; spaceCount++) {		//repetitive statement for space character
			spaces = spaces + " ";		//set the value
		}
		
		return spaces;		//return value
	}
}
