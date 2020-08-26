package InvalidTriangle;

public class TriangleDriver {
	public static void main(String[] args) {
		try {
			Triangle t = new Triangle(3,4,5);
		} catch (Exception e){
			e.printStackTrace();
		}
	}
}
