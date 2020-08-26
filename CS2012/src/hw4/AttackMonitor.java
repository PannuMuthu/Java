package hw4;
import java.util.Scanner;
import java.util.Date;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class AttackMonitor {
	Scanner input = new Scanner(System.in); 
	ArrayList<MonsterAttack> attacks = new ArrayList<>();
	private MonsterAttack in;
	 
	public void reportAttack() {
			System.out.println("Attack "+ (attacks.size()+1)+":");
			in = new MonsterAttack();
			attacks.add(in);
	}
	
	public void showAttack() { 
		for (int i = 0; i < attacks.size(); i++) {
			System.out.println("Attack "+ (i+1) + ":");
			System.out.println("Monster Name: " + attacks.get(i).getMonsterName());
			System.out.println("Attack Location: " + attacks.get(i).getMonsterLocation());
			System.out.println("Attack Date: " + attacks.get(i).getMonsterDate().toString());
			System.out.println("Damages in Million USD: " + attacks.get(i).getMonsterDamage());
			System.out.println();
		}
	}
	
	public void showDamages() {	
		double totalDamages = 0;
		for (int i = 0; i < attacks.size(); i++) {
			totalDamages += attacks.get(i).getMonsterDamage();
		}
		System.out.println("The total amount of all attacks in millions USD is " + totalDamages);
		System.out.println("The mean of the damages in millions USD is " + (totalDamages/5));
	}
	
	public void showMonsters() {
		ArrayList<Boolean> visited = new ArrayList<Boolean>(); 
	    for (int index = 0; index < attacks.size(); index++) {
	    	visited.add(false);
	    }
	   
	    for (int i = 0; i < attacks.size(); i++) { 
	        if (visited.get(i) == true) 
	            continue; 
	        
	        int count = 1; 
	        for (int j = i + 1; j < attacks.size(); j++) { 
	            if (attacks.get(i).getMonsterName().equals(attacks.get(j).getMonsterName())) { 
	                visited.set(j, true); 
	                count++; 
	            } 
	        } 
	        System.out.println(attacks.get(i).getMonsterName() + ": " + count + " attacks(s)"); 
	    } 
	}
	
	public void findEarliestAttack() {
		ArrayList<Date> dates = new ArrayList<Date>(); 
		Date min = new Date();
		int index = 0;
		for (int i = 0; i < attacks.size(); i++) {
			dates.add(attacks.get(i).getMonsterDate());
		}
		for (int j = 0; j < dates.size(); j++) {
			if (dates.get(j).before(min)) {
				min = dates.get(j);
				index = j;
			}
		}
		System.out.println("Earliest attack: \nAttack " + (index+1) + " ");
		System.out.println("Monster Name: " + attacks.get(index).getMonsterName());
		System.out.println("Attack Location: " + attacks.get(index).getMonsterLocation());
		System.out.println("Attack Date: " + attacks.get(index).getMonsterDate());
		System.out.println("Damages in Million USD: " + attacks.get(index).getMonsterDamage());
	}
	
	public void saveToFile() {
		System.out.println("What is the complete intended filepath of the file? (Ex: ~/User/Desktop/attacks.txt) ");
		String path = input.nextLine();
		try {
			PrintWriter output = new PrintWriter(path);
			for (int i = 0; i< attacks.size(); i++) {
				output.print(attacks.get(i).getMonsterName() + ",");
				output.print(attacks.get(i).getMonsterLocation() + ",");
				output.print(attacks.get(i).getDateToString() + ",");
				output.print(attacks.get(i).getMonsterDamage());
				output.println();
			}
			output.close();
		} catch (FileNotFoundException e) {
			System.out.println("Invalid file path format (Tips: do not add extension to file name, and add the final / after your file path)");
		}
	}
	
	public void readFromFile() {
		System.out.println("Please enter the complete filepath of the source file: ");
		String path = input.nextLine();
		File sourceFile = new File(path);
		ArrayList<String> monsters = new ArrayList<>(); 
		try (Scanner inp = new Scanner(sourceFile)) {
			attacks.clear();
			while(inp.hasNextLine()) {
				String monster = inp.nextLine();
				monsters.add(monster);
			}
		} catch (FileNotFoundException e) {
			System.out.println("Source file not found.");
		}
		for (int i = 0; i < monsters.size(); i++) {
			MonsterAttack in = new MonsterAttack(i);
			String[] fields = monsters.get(i).split(",");
			String[] dateField = fields[2].split("/");
			in.setMonsterName(fields[0]);
			in.setMonsterLocation(fields[1]);
			in.setMonsterDate(Integer.parseInt(dateField[0]), Integer.parseInt(dateField[1]), Integer.parseInt(dateField[2]));
			in.setMonsterDamage(Double.parseDouble(fields[3]));
			attacks.add(in);
		}
	}
}


