package cs2011review;
import java.util.Scanner;

public class Array {
	public static void main (String[] args) {
		Scanner input = new Scanner(System.in);
		double[] array =  new double[10]; 
		System.out.println("Enter 10 numbers");
		for (int i = 0; i<array.length; i++) {
			array[i]=input.nextDouble();
		}
		System.out.println("The average of the 10 numbers is "+average(array));
	}
	public static int average(int[] arr) {
		int sum = 0;
		for (int i =0; i< arr.length; i++) {
			sum += arr[i];
		}
		return sum/arr.length;
	}
	public static double average(double[] arr) {
		double sum = 0;
		for (int j = 0; j < arr.length; j++) {
			sum += arr[j];
		}
		return sum/arr.length;
	}
}