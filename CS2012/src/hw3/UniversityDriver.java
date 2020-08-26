package hw3;
import java.util.Scanner;

public class UniversityDriver {
	public static void main (String[] args) {
		Scanner input = new Scanner(System.in);
		University university = new University();
		int response;
		System.out.println("This program will simulate a university's records.");
		do {
			System.out.println("What would you like to do? Enter 1 to add information, 2 to remove information, 3 to view information, or 4 to change individual people's schedules. Enter 0 at any time to quit the program.");
			response = input.nextInt();
			if (response == 1) {
				System.out.println("What information would you like to add? Enter 1 to add courses, 2 to add students, or 3 to add faculty members. Enter 0 to go back.");
				int addKey = input.nextInt();
				if (addKey == 1) { 
					university.addCourse();
				} else if (addKey == 2) {
					university.addStudent();
				} else if (addKey == 3) {
					university.addFaculty();
				} else if (addKey == 0) {
					continue;
				}
			} else if (response  == 2) {
				System.out.println("What information would you like to remove? Enter 1 to remove a student, or enter 2 to remove a faculty member. Enter 0 to go back.");
				int removeKey = input.nextInt();
				if (removeKey == 1) { 
					university.removeStudent();
				} else if (removeKey == 2) {
					university.removeFaculty();
				} else if (removeKey == 0) {
					continue;
				} 
			} else if (response == 3) {
				System.out.println("What information would you like to see? Enter 1 to view the list of courses, enter 2 to view the list of students, enter 3 to view the list of faculty, or enter 4 to view an individual's personal schedule. Enter 0 to go back.");
				int viewKey = input.nextInt();
				if (viewKey == 1) {
					university.displayAvailable();
				} else if (viewKey == 2) {
					university.displayStudents();
				} else if (viewKey == 3) {
					university.displayFaculty();
				} else if (viewKey == 4) {
					university.displayIndividual();
				} else if (viewKey == 0) {
					continue;
				}
			} else if (response == 4) {
				System.out.println("Enter 1 to modify a specified student's course schedule or enter 2 to modify a specified faculty member's teaching schedule. Enter 0 to go back.");
				int modifyKey = input.nextInt();
				if (modifyKey == 1) {
					university.studentSelect();
				} else if (modifyKey == 2) {
					university.facultySelect();
				} else if (modifyKey == 0) {
					continue;
				}
				
			}
		} while (response != 0);
	}
}
