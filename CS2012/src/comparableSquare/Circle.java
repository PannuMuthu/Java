package comparableSquare;

public class Circle extends Shape implements Comparable<Shape>, Cloneable{
	private final double PI = 3.14159;
	public Circle(double measurement, String color) {
		super(measurement,color);
	}
	
	@Override
	public double computeArea(){
		return PI*(Math.pow(this.getArea(),2));
	}
	
	@Override
	public int compareTo(Shape o) {
		if(this.getArea() > o.getArea()) {
			return 1;
		} else if (this.getArea() < o.getArea()) {
			return -1;
		} else {
			return 0;
		}
	}
	
	@Override
	public Circle clone() {
		try {
			Circle cloned = (Circle) super.clone();
			return cloned;
		} catch(CloneNotSupportedException e) {
			return null;
		}
	}
	
	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		} else if(other == null){
			return false;
		} else if(!(other instanceof Circle)) {
			return false;
		}
		Circle o = (Circle) other;
		if (o.getMeasurement() == this.getMeasurement() && o.getColor() == this.getColor()) {
			return true;
		} else {
			return false;
		}
	}
	 
}
