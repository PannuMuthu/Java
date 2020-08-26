package application;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class MonsterAttack {
	private String monsterName;
	private String attackLocation;
	private Date date = new Date();
	private double damagesInMillionUSD;
	
	public MonsterAttack(String name, String location, double damages, Date date) {
		this.monsterName = name;
		this.attackLocation = location;
		this.damagesInMillionUSD = damages;
		this.date = date;
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
