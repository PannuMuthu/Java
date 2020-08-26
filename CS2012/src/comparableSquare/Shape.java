package comparableSquare;

public abstract class Shape {
	private double area;
	private double measurement;
	private String color = "";
	
	public Shape(double measurement, String color) {
		this.measurement = measurement;
		this.color = color;
	}
	
	public double getArea() {
		return this.area;
	}
	
	public void setArea(double area) {
		this.area = area;
	}
	
	public String getColor() {
		return this.color;
	}
	
	public double getMeasurement() {
		return this.measurement;
	}
	
	public abstract double computeArea();
	
}
