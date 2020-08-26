package hw3;

import java.util.Scanner;

public class Course {
	private String course;
	private int units;
	
	public Course(String course, int units) {
		this.course = course;
		this.units = units;
	}
	
	public Course() {
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter the course ID: ");
		String courseName = input.nextLine();
		this.course = courseName;
		System.out.println("Please enter the number of units: ");
		int units = input.nextInt();
		this.units = units;
	}
	
	public String getCourse() {
		return course;
	}
	
	public int getUnits() {
		return units;
	}
	
	public String displayCourse() {
		return "Course: " + course + ", Units: " + String.valueOf(units);
	}
}
