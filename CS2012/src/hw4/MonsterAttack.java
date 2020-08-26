package hw4;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class MonsterAttack {
	private String monsterName;
	private String attackLocation;
	private Date date = new Date();
	private double damagesInMillionUSD;
	
	public MonsterAttack() {
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter the monster name: ");
		String name = input.nextLine();
		this.monsterName = name;
		System.out.println("Please enter the attack location: ");
		String location = input.nextLine();
		this.attackLocation = location;
		System.out.println("Please enter the attack damages cost in millions USD: ");
		double damages = input.nextDouble();
		this.damagesInMillionUSD = damages;
		System.out.println("Please enter the month of the attack with numbers (Ex: 1 for January): ");
		int month = input.nextInt();
		System.out.println("Please enter the day of the attack");
		int day = input.nextInt();
		System.out.println("Please enter all four digits of the year of the attack (Ex: 2019)");
		int year = input.nextInt();
		this.date = new Date(year-1900, month-1, day);
	}
	
	public MonsterAttack(int i) {
		
	}
	
	public void setMonsterName(String name) {
		this.monsterName = name;
	}
	
	public void setMonsterLocation(String location) {
		this.attackLocation = location;
	}
	
	public void setMonsterDate(int month, int day, int year) {
		 this.date = new Date(year-1900, month-1, day);
		
	}
	
	public void setMonsterDamage(double damages) {
		this.damagesInMillionUSD = damages;
	}
	
	
	public String getMonsterName() {
		return this.monsterName;
		
	}
	
	public String getMonsterLocation() {
		return this.attackLocation;
	}
	
	public Date getMonsterDate() {
		return this.date;
	}
	
	public String getDateToString() {
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");  
		String strDate = dateFormat.format(date);  
		return strDate;
	}
	
	public double getMonsterDamage() {
		return this.damagesInMillionUSD;
	}
}
