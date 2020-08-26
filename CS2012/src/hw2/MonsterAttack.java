package hw2;
import java.util.Date;

public class MonsterAttack {
	private String monsterName;
	private String attackLocation;
	private Date date = new Date();
	private double damagesInMillionUSD;
	
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
	
	public double getMonsterDamage() {
		return this.damagesInMillionUSD;
	}
}