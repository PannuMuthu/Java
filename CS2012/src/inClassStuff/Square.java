package inClassStuff;

public class Square implements Shape{
	private double side;
	
	public Square(double side) {
		this.side = side;
	}
	
	@Override 
	public void setMeasurement(double side) {
		this.side = side;
	}
	
	@Override 
	public double getMeasurement() {
		return side;
	}
	
	@Override 
	public double computeArea(double side) {
		return Math.pow(side, 2);
	}
}
