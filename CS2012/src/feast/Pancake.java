package feast;

public class Pancake extends Portion{
	private double radius;
	private final double PI = 3.14159;
	public Pancake(double radius) {
		this.radius = radius;
		this.calories = 10*PI*Math.pow(radius, 2);
	}
	
	@Override 
	public String toString() {
		return "Customer eats a pancake with radius " + String.valueOf(radius) + " and " + String.valueOf(calories) + " calories.";
	}
}
