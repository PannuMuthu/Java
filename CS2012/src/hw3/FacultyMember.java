package hw3;
import java.util.ArrayList;
import java.util.Scanner;

public class FacultyMember extends Person {
	Scanner input = new Scanner(System.in);
	private int employeeID;
	private ArrayList<Course> teachingSchedule = new ArrayList<>();
	
	public FacultyMember() {
		super();
		System.out.println("Please enter the employee ID: ");
		int employeeID = input.nextInt();
		this.employeeID = employeeID;
	}
	
	public int getEmployeeID() {
		return employeeID;
	}
	
	public void addCourseToSchedule(Course course) {
		String key = course.getCourse();
		if (teachingSchedule.size() == 0) {
			teachingSchedule.add(course);
		} else {
			for (int j = 0; j < teachingSchedule.size(); j++) {
			if (!teachingSchedule.get(j).getCourse().equals(key)) {
					teachingSchedule.add(course);
					System.out.println("You have successfully added this course to your schedule.");
				} else {
					System.out.println("This course is already in your schedule.");
				}
			 }
		}
		
	}
	
	public void dropCoursefromSchedule(Course course) {
		for (int i = 0; i < teachingSchedule.size(); i++) {
			if (course.getCourse().equals(teachingSchedule.get(i).getCourse())) {
				teachingSchedule.remove(i);
				System.out.println("You have successfully removed this course from your teaching schedule.");
			} else {
				System.out.println("This course is not on your teaching schedule, you may have already removed it.");
			}
		}
	}
	
	public ArrayList<Course> getTeachingSchedule() {
		return teachingSchedule;
	}
	
	public void showTeachingSchedule() {
			System.out.println("Faculty Member Teaching Schedule");
			System.out.println();
			System.out.println("Number of Courses: " + teachingSchedule.size());
			for (int i = 0; i < teachingSchedule.size(); i++) {
				System.out.println("Course ID: " + teachingSchedule.get(i).getCourse() + ", Units: " + teachingSchedule.get(i).getUnits());
			}
			System.out.println();
	}
	
}
