package feast;

public class Cupcake extends Portion{
	private double radius;
	private double height;
	private double volume;
	private final double PI = 3.14159;
	public Cupcake(double radius, double height) {
		this.radius = radius;
		this.height = height;
		this.volume = Math.pow(radius, 2)*height;
		this.calories = 4*volume;
	}
	
	@Override 
	public String toString() {
		return "Customer eats a cupcake with volume " + String.valueOf(volume) + " and " + String.valueOf(calories) + " calories.";
	}
}
