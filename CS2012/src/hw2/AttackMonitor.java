package hw2;
import java.util.Scanner;
import java.util.Date;

public class AttackMonitor {
	 MonsterAttack[] attacks = new MonsterAttack[5];

	public MonsterAttack[] reportAttacks() {
		for (int  i = 0; i < attacks.length; i++) {
			Scanner input = new Scanner(System.in);
			attacks[i] = new MonsterAttack();
			System.out.println("Attack "+ (i+1)+":");
			System.out.println("Please enter the monster name: ");
			attacks[i].setMonsterName(input.nextLine());
			System.out.println("Please enter the attack location: ");
			attacks[i].setMonsterLocation(input.nextLine());
			System.out.println("Please enter the attack damages cost in millions USD: ");
			attacks[i].setMonsterDamage(input.nextDouble());
			System.out.println("Please enter the month of the attack with numbers (Ex: 1 for January): ");
			int month = input.nextInt();
			System.out.println("Please enter the day of the attack");
			int day = input.nextInt();
			System.out.println("Please enter all four digits of the year of the attack (Ex: 2019)");
			int year = input.nextInt();
			attacks[i].setMonsterDate(month, day, year);
		}
		
		return attacks;
		
	}
	
	public void showAttack() { 
		for (int i = 0; i < attacks.length; i++) {
			System.out.println("Attack "+ (i+1) + ":");
			System.out.println("Monster Name: " + attacks[i].getMonsterName());
			System.out.println("Attack Location: " + attacks[i].getMonsterLocation());
			System.out.println("Attack Date: " + attacks[i].getMonsterDate().toString());
			System.out.println("Damages in Million USD: " + attacks[i].getMonsterDamage());
			System.out.println();
		}
	}
	
	public void showDamages() {	
		double totalDamages = 0;
		for (int i = 0; i < attacks.length; i++) {
			totalDamages += attacks[i].getMonsterDamage();
		}
		System.out.println("The total amount of all attacks in millions USD is " + totalDamages);
		System.out.println("The mean of the damages in millions USD is " + (totalDamages/5));
	}
	
	public void showMonsters() {
		boolean visited[] = new boolean[5]; 
	    for (int index = 0; index < visited.length; index++) {
	    	visited[index] = false;
	    }
	  
	    
	    for (int i = 0; i < attacks.length; i++) { 
	  
	        
	        if (visited[i] == true) 
	            continue; 
	  
	        
	        int count = 1; 
	        for (int j = i + 1; j < attacks.length; j++) { 
	            if (attacks[i].getMonsterName().equals(attacks[j].getMonsterName())) { 
	                visited[j] = true; 
	                count++; 
	            } 
	        } 
	        System.out.println(attacks[i].getMonsterName() + ": " + count + " attacks(s)"); 
	    } 
	}
	
	public void findEarliestAttack() {
		Date[] dates = new Date[5]; 
		Date min = new Date();
		int index = 0;
		for (int i = 0; i < attacks.length; i++) {
			dates[i] = attacks[i].getMonsterDate();
		}
		for (int j = 0; j < dates.length; j++) {
			if (dates[j].before(min)) {
				min = dates[j];
				index = j;
			}
		}
		System.out.println("Earliest attack: Attack " + (index+1) + ": ");
		System.out.println("Monster Name: " + attacks[index].getMonsterName());
		System.out.println("Attack Location: " + attacks[index].getMonsterLocation());
		System.out.println("Attack Date: " + attacks[index].getMonsterDate());
		System.out.println("Damages in Million USD: " + attacks[index].getMonsterDamage());
	}
}


