package hw3;
import java.util.ArrayList;
import java.util.Scanner;

public class Student extends Person {
	Scanner input = new Scanner(System.in);
	private int CIN;
	private ArrayList<Course> studentCourseList = new ArrayList<Course>();
	
	public Student() {
		super();
		System.out.println("Please enter the CIN: ");
		int CIN = input.nextInt();
		this.CIN = CIN;	
		}
	
	public Student(int CIN, String name, Address address) {
		this.CIN = CIN;
		this.name = name;
		this.address = address;
	}
	
	public int getCIN() { 
		return CIN;
	}
	
	public ArrayList<Course> getStudentCourseList() {
		return studentCourseList;
	}
	
	public void addCourseToSchedule(Course course) {
		String key = course.getCourse();
		if (studentCourseList.size() == 0) {
			studentCourseList.add(course);
		} else {
			for (int j = 0; j < studentCourseList.size(); j++) {
			if (!studentCourseList.get(j).getCourse().equals(key)) {
					studentCourseList.add(course);
					System.out.println("You have successfully added this course to your schedule.");
				} else {
					System.out.println("This course is already in your schedule.");
				}
			 }
		}
	}
	
	public void dropCourseFromSchedule(Course course) {
		for (int i = 0; i < studentCourseList.size(); i++) {
			if (course.getCourse().equals(studentCourseList.get(i).getCourse())) {
				studentCourseList.remove(i);
				System.out.println("You have successfully dropped this course from your schedule.");
			} else {
				System.out.println("This course is not on your schedule, you may have already dropped it.");
			}
		}
	}
	
	public void showCourseSchedule() {
		System.out.println("Student Course Catalog");
		System.out.println();
		System.out.println("Number of Courses: " + studentCourseList.size());
		for (int i = 0; i < studentCourseList.size(); i++) {
			System.out.println("Course ID: " + studentCourseList.get(i).getCourse() + ", Units: " + studentCourseList.get(i).getUnits());
		}
		System.out.println();
	}
	
}
