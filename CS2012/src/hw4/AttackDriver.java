package hw4;
import java.util.Scanner;

public class AttackDriver {
	private static Scanner input;

	public static void main (String[] args) {
		AttackMonitor monitor = new AttackMonitor();
		input = new Scanner(System.in);
		int response;
		System.out.println("This program will allow you to report and get information about monster attacks.");
		do {
			System.out.println("What would you like to do? Enter 1 to report a monster attack, 2 to show all attacks, 3 to show damages, 4 to show distinct monsters, 5 to find earliest attack, 6 to save to file, 7 to read from file. Press 0 to exit.");
			response = input.nextInt();
			if (response > 6 && response < 0) {
				System.out.println("Invalid input. Try again.");
			} 
			else {
				switch(response) {
					case 1:  monitor.reportAttack(); break;
					case 2:	 monitor.showAttack(); break; 
					case 3:  monitor.showDamages(); break; 
					case 4:  monitor.showMonsters(); break; 
					case 5:  monitor.findEarliestAttack(); break;
					case 6:  monitor.saveToFile(); break;
					case 7:  monitor.readFromFile(); break;
				}
			}
		} while(response != 0);
		
	}
}
