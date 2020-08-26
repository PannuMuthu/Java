package InvalidRightTriangle;


public class RightTriangle {
	
	private double side1;
	private double side2;
	private double side3;
	
	public RightTriangle(double side1, double side2, double side3) {
		this.side1 = side1;
		this.side2 = side2;
		this.side3 = side3;
	}
	
	public void inputValid() throws InvalidRightTriangleException{
		
		double longestSide = side1;
		double shorterSide1 = side2;
		double shorterSide2 = side3;
		
		if (side2 > longestSide) {
			longestSide = side2;
			shorterSide1 = side1;
			shorterSide2 = side3;
		} else if (side3 > longestSide) {
			longestSide = side3;
			shorterSide1 = side1;
			shorterSide2 = side2;
		}
		
		else if (Math.sqrt(Math.pow(shorterSide1, 2) + Math.pow(shorterSide2, 2))==longestSide) {
			System.out.println("This is a valid right triangle.");
		} 
		else {
			throw new InvalidRightTriangleException("Invalid right triangle. The longest side must be the square root of the sum of the shorter sides.");
		}
		
	}
}
