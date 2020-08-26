package InvalidRightTriangle;
import java.util.Scanner;

public class TriangleDriver {
	public static void main(String[] args) {
		RightTriangle t = new RightTriangle(1,2,3);
		try {
			t.inputValid();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
