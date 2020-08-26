package comparableSquare;

public class Square extends Shape implements Comparable<Shape>, Cloneable{

	
	public Square(double measurement, String color) {
		super(measurement, color);
	}

	@Override
	public double computeArea() {
		return Math.pow(this.getMeasurement(),2);
	}

	@Override
	public int compareTo(Shape o) {
		if(this.getArea() > o.getArea()) {
			return 1;
		}
		else if(this.getArea() < o.getArea()){
			return -1;
		} else {
			return 0;
		}
	}
	
	@Override 
	public Square clone() {
		try {
			Square cloned = (Square) super.clone();
			return cloned;
		} catch(CloneNotSupportedException e){
			return null;
		}
		
	}
	

}
