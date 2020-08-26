package inClassStuff;

public class Circle implements Shape{
	private double radius;
	private final double PI = 3.14159;
	
	public Circle(double radius) {
		this.radius = radius;
	}
	
	@Override
	public double getMeasurement() {
		return radius;
	}
	
	@Override 
	public void setMeasurement(double radius) {
		this.radius = radius;
	}
	
	@Override
	public double computeArea(double radius) {
		return Math.pow(radius, 2) * PI;
	}
}
