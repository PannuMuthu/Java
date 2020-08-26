package hw3;
import java.util.ArrayList;
import java.util.Scanner;

public class University {
	Scanner input = new Scanner(System.in);
	private ArrayList<Course> availableCourses = new ArrayList<>();
	private ArrayList<Student> studentList = new ArrayList<>();
	private ArrayList<FacultyMember> facultyList = new ArrayList<>();
	private Course in;
	
	
	public void addCourse() {
		in = new Course();
		availableCourses.add(in);	
	}
	
	public ArrayList<Course> getCourseList(){
		return availableCourses;
	}
	
	
	public void displayAvailable() {
		//Show course number
		System.out.println("University Course Catalog");
		System.out.println();
		System.out.println("Number of Courses: " + availableCourses.size());
		for (int i = 0; i < availableCourses.size(); i++) {
			System.out.println("Course " + (i+1) + " | "+"Course ID: " + availableCourses.get(i).getCourse() + ", Units: " + availableCourses.get(i).getUnits());
		}
		System.out.println();

	}
		
	public void addStudent() {
		Student in = new Student();
		studentList.add(in);
	}
	
	public void removeStudent() {
		displayStudents();
		System.out.println("Please enter the number of the student you want to remove: ");
		int key = input.nextInt();
		if (key <= studentList.size() && key >= 1) {
			studentList.remove(key - 1);
		} else {
			System.out.println("Invalid input.");
		}
		
		
	}
	
	public ArrayList<Student> getStudentList() {
		return studentList;
	}
	
	public void addFaculty() {
		FacultyMember in = new FacultyMember();
		facultyList.add(in);
	}
	
	public void removeFaculty() {
		displayFaculty();
		System.out.println("Please enter the number of the faculty member you want to remove: ");
		int key = input.nextInt();
		if (key <= facultyList.size() && key >= 1) {
			facultyList.remove(key - 1);
		} else {
			System.out.println("Invalid input.");
		}
	}
	
	public void displayStudents() {
		System.out.println("List of Students");
		System.out.println();
		System.out.println("Number of Students: " + studentList.size());
		for (int i = 0; i < studentList.size(); i++) {
			System.out.println("Student " + (i+1) + ": " + "Name: " + studentList.get(i).getName() + ", CIN: " + studentList.get(i).getCIN());
		}
		System.out.println();

	}
	
	public void displayFaculty() {
		System.out.println("List of Faculty Members");
		System.out.println();
		System.out.println("Number of Faculty Members: " + facultyList.size());
		for (int i = 0; i < facultyList.size(); i++) {
			System.out.println("Faculty Member " + (i+1) + ": " + "Name: " + facultyList.get(i).getName() + ", Employee ID: " + facultyList.get(i).getEmployeeID());
		}
		System.out.println();
	}
	
	public void studentSelect() {
		displayStudents();
		System.out.println("Please enter the number of the student: ");
		int key = (input.nextInt()-1);
		if (key < studentList.size() && key >= 0) {
			System.out.println("You have selected " + studentList.get(key).getName());
			System.out.println("Enter 1 to add a course to the student's schedule, enter 2 to remove a course from the student's schedule, or enter 3 to view the student's schedule.");
			int action = input.nextInt();
			if (action == 1) {
				displayAvailable();
				System.out.println("Which course would you like to add to " + studentList.get(key).getName()+"'s schedule? Please enter the course number: ");
				int courseIndex = (input.nextInt()-1);
				studentList.get(key).addCourseToSchedule(availableCourses.get(courseIndex));
			} else if (action == 2) {
				studentList.get(key).showCourseSchedule();
				System.out.println("Which course would you like to remove from " + studentList.get(key).getName()+"'s schedule? Please enter the course number: ");
				int dropIndex = (input.nextInt()-1);
				studentList.get(key).dropCourseFromSchedule(studentList.get(key).getStudentCourseList().get(dropIndex));
			} else if (action == 3) {
				studentList.get(key).showCourseSchedule();
			} else {
				System.out.println("Invalid input.");
			}
		} else {
			System.out.println("Invalid input.");
		}
	}
	
	public void displayIndividual() {
		System.out.println("Enter 1 to view a student's course schedule or enter 2 to view a faculty member's teaching schedule.");
		int seeKey = input.nextInt();
		if (seeKey == 1) {
			displayStudents();
			System.out.println("Please enter the number of the student: ");
			int key = (input.nextInt()-1);
			if (key < studentList.size() && key >= 0) {
				System.out.println("You have selected " + studentList.get(key).getName());
				studentList.get(key).showCourseSchedule();
			}
		} else if (seeKey == 2) {
			displayFaculty();
			System.out.println("Please enter the number of the faculty member: ");
			int key = (input.nextInt()-1);
			if (key < facultyList.size() && key >= 0) {
				System.out.println("You have selected " + facultyList.get(key).getName());
				facultyList.get(key).showTeachingSchedule();
			}
		} else {
			System.out.println("Invalid input");
		}
	}
	
	public void facultySelect() {
		displayFaculty();
		System.out.println("Please enter the number of the faculty member: ");
		int key = (input.nextInt()-1);
		if (key < facultyList.size() && key >= 0) {
			System.out.println("You have selected " + facultyList.get(key).getName());
			System.out.println("Enter 1 to add a course to the faculty member's schedule, enter 2 to remove a course from the faculty member's schedule, or enter 3 to view the faculty member's schedule.");
			int action = input.nextInt();
			if (action == 1) {
				displayAvailable();
				System.out.println("Which course would you like to add to " + facultyList.get(key).getName()+"'s schedule? Please enter the course number: ");
				int courseIndex = (input.nextInt()-1);
				facultyList.get(key).addCourseToSchedule(availableCourses.get(courseIndex));
			} else if (action == 2) {
				facultyList.get(key).showTeachingSchedule();
				System.out.println("Which course would you like to remove from " + studentList.get(key).getName()+"'s schedule? Please enter the course number: ");
				int dropIndex = (input.nextInt()-1);
				facultyList.get(key).dropCoursefromSchedule(facultyList.get(key).getTeachingSchedule().get(dropIndex));
			} else if (action == 3) {
				facultyList.get(key).showTeachingSchedule();
			} else {
				System.out.println("Invalid input.");
			}
		} else {
			System.out.println("Invalid input.");
		}
	}
	
}
