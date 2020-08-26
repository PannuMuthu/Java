package MyRectangle2D;

public class MyRectangle2D {
	private double x;
	private double y;
	private double width;
	private double height;
	
	public MyRectangle2D() {
		this.x = 0;
		this.y = 0;
		this.height = 1;
		this.width = 1;
	}
	
	public MyRectangle2D(double x, double y, double height, double width) {
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	public double getWidth() {
		return width;
	}
	
	public double getHeight() {
		return height;
	}
	
	public double getArea() {
		return width * height; 
	}
	
	public double getPerimeter() {
		return (2*width + 2*height);
	}
	
	public boolean contains(double x, double y) {
		boolean xValid = x <= (this.x + (width/2)) && x >= (this.x - (width/2));
		boolean yValid = y <= (this.y + (height/2)) && y >= (this.y - (height/2));
		if (xValid && yValid) {
			return true;
		} else {
			return false;
		}
		
	}
	
	public boolean contains(MyRectangle2D r) {
		double[][] corners = getCorners(r);
		for (int i = 0; i < corners.length; i++) {
			if (!contains(corners[i][0], corners[i][1])) {
				return false;
			}
		}
		return true;
	}
	
	public boolean overlaps(MyRectangle2D r) {
		if ((getY() + (getHeight() / 2) < r.getY() - (r.getHeight() / 2)) ||
		        (getY() - (getHeight() / 2) > r.getY() + (r.getHeight() / 2)) ||
		        (getX() + (getWidth() / 2) < r.getX() - (r.getWidth() / 2))   ||
		        (getX() - (getWidth() / 2)) > r.getX() + (r.getWidth() / 2))
			{
		      return false;
		    }
		    return true;
	}
	
	public double[][] getCorners(MyRectangle2D r) {
		double[][] corners = new double [4][2];
		corners[0][0]=r.getX()+(width/2);
		corners[0][1]=r.getY()-(height/2);
		corners[1][0]=r.getX()+(width/2);
		corners[1][1]=r.getY()+(height/2);
		corners[2][0]=r.getX()-(width/2);
		corners[2][1]=r.getY()-(height/2);
		corners[3][0]=r.getX()-(width/2);
		corners[3][1]=r.getY()+(height/2);
		return corners;
	}
}
