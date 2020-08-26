package ch18;

import java.io.File;

public class RecursiveExamples {
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7,8,9,10};
		printArrRecursive(arr, 0);
		System.out.println();
		System.out.println(factorial(20));
		permutate("abcdefghijk");
	}
	
	public static void printArrRecursive(int[] arr, int index) {
		//Base case
		if (index == arr.length) {
			return;
		}
		//Recursive case
		else {
			System.out.print(arr[index] + " ");
			printArrRecursive(arr, index + 1);
			//OR
			//printArrRecursive(arr, ++index);
		}
	}
	
	public static long factorial(int n) {
		//Base case
		if (n == 0) {
			return 1;
		} 
		else {
			return n * factorial(n-1);
		}
	}
//	private static int RecursiveBinarySearch(int[] list, int key, int low, int high) {
//		if (low > high) {
//			return -low - 1;
//		}
//		int mid = (low+high)/2;
//		
//	}
	
	public static void permutate(String str) {
		permutate("",str);
	}
	private static void permutate(String prefix, String str) {
		if (str.isEmpty()) {
			System.out.println(prefix);
		}
		else {
			for (int i = 0; i < str.length(); ++i) { 
				String tempPrefix = prefix + str.charAt(i);
				String tempStr = str.substring(0,i) + str.substring(i+1);
				permutate(tempPrefix, tempStr);
			}
		}
	}
}
