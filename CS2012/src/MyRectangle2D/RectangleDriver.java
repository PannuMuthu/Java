package MyRectangle2D;

public class RectangleDriver {

	public static void main(String[] args) {
		MyRectangle2D r1 = new MyRectangle2D(2, 2, 5.5, 4.9);

	    System.out.println("area: " + r1.getArea());
	    System.out.println("perimeter: " + r1.getPerimeter());
	    System.out.println("contains(3, 3): " + r1.contains(3, 3));
	    System.out.println("contains(new MyRectangle2D(4, 5, 10.5, 3.2)): " +
	      r1.contains(new MyRectangle2D(4, 5, 10.5, 3.2)));
	    System.out.println("overlaps(new MyRectangle2D(3, 5, 2.3, 5.4)): " +
	      r1.overlaps(new MyRectangle2D(4, 5, 10.5, 3.2)));
	}

}
