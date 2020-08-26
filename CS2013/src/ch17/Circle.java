package ch17;

import java.io.Serializable;

public class Circle implements Serializable{

	//private static final long serialVersionUID = 1L;
	
	private double radius;
	private String color;
	private boolean filled;
	private final double PI = 3.14159;
	
	public Circle(double radius, String color, Boolean filled) {
		this.radius = radius;
		this.setColor(color);
		this.setFilled(filled);
	}
	
	
	public double getMeasurement() {
		return radius;
	}
	
	
	public void setMeasurement(double radius) {
		this.radius = radius;
	}
	
	
	public double computeArea(double radius) {
		return Math.pow(radius, 2) * PI;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}


	public boolean isFilled() {
		return filled;
	}


	public void setFilled(boolean filled) {
		this.filled = filled;
	}
	
	@Override
	public String toString() {
		return "\n Radius: " + String.valueOf(radius) + "\n Color: " + color + " \n Filled: " + String.valueOf(filled) + "\n";
	}
}

