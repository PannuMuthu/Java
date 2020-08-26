package inClassStuff;

public class ComparableCircle extends Circle implements Comparable<Shape>{
	
	public ComparableCircle(double radius) {
		super(radius);
	}

	public Circle clone() {
		try {
			Circle circleClone = (Circle) super.clone();
			return circleClone;
		} catch(Exception e) {
			return null;
		}
	}
	
	@Override
	public int compareTo(Shape o) {
		
		return 0;
	}
	

}
