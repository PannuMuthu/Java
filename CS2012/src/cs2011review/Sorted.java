package cs2011review;
import java.util.Scanner;

public class Sorted {
	public static void main (String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("How many numbers?");
		int arrLength = input.nextInt();
		int[] list = new int[arrLength];
		for (int i=0;i<list.length;i++) {
			list[i]=input.nextInt();
		}
		if (isSorted(list)==true) {
			System.out.println("Your list is sorted in ascending order.");
		} else {
			System.out.println("Your list is not sorted in ascending order.");
		}
	}
	public static boolean isSorted(int[] list) {
			for (int i = 1; i < list.length; i++) {
				if (list[i-1]>list[i]) {
					return false;
				}
			}
			return true;
	}
}
