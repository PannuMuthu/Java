package ch22;

public class BigOExamples {
	public static void main (String[] args) {
		//O(1) time
//		int x = 1;
//		int n = 1000;
//		
//		//O(log n) time
//		while(n > 1) {
//			n/=2;
//		}
//		
//		//O(n) time
//		while(x < n) {
//			x++;
//		}
		
		//O(log n) time
		System.out.println("n = 10 | " + countReps(10));
		System.out.println("n = 100 | " + countReps(100));
		System.out.println("n = 1000 | " + countReps(1000));
		System.out.println("n = 10000 | " + countReps(10000));
		System.out.println("n = 1000000 | " + countReps(1000000));

	}
	
	public static int countReps(int n) {
		int count = 0;
		while(n > 1) {
			n/=2;
			count++;
		}
		return count;
		
	}
}
