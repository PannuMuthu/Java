package ch17;

import java.io.Serializable;

public class Car implements Serializable{
	private static final long SerialVersionUID = 1L;
	private String color;
	private double mileage;
	private boolean isHybrid;

	public Car(String color, double mileage, boolean isHybrid) {
		this.color = color;
		this.mileage = mileage;
		this.isHybrid = isHybrid;
	}

	public void setColor(String color){
		this.color = color;
	}

	public String getColor(){
		return color;
	}

	public void setMileage(double mileage){
		this.mileage = mileage;
	}

	public double getMileage(){
		return mileage;
	}

	public void setHybrid(boolean isHybrid){
		this.isHybrid = isHybrid;
	}

	public boolean getHybrid(){
		return isHybrid;
	}

	@Override
	public String toString() { 
		return "\n Color: " + color + "\n Mileage: " + String.valueOf(mileage) + "\n Hybrid: " + String.valueOf(isHybrid) + "\n";
	}
}