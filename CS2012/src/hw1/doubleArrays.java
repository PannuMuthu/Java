// Pratyush Muthukumar
// CS 2012-01
// 8/29/19
package hw1;
import java.util.Scanner;

public class doubleArrays {
	
	public static void main(String[] args) {
		
		// Initialize array and print 
		double[] array = inputArr();
		System.out.println("Initial array: ");
		display(array);
		System.out.println();
		
		// Call cube method and print
		cubed(array);
		System.out.println("Cubed method output array: ");
		display(array);
		System.out.println();
		
		// Call 250-cap array and print
		cap250(array);
		System.out.println("250-capped method output array: ");
		display(array);
		System.out.println();
		
		// Copy array for inverse method and print both
		double[] copy = inverse(array);
		System.out.println("Inverse method output of original array:");
		display(array);
		System.out.println();
		System.out.println("Inverse method output of copied array:");
		display(copy);
	}
	
	// Method to initialize and validate user input of 10 nonnegative doubles. 
	public static double[] inputArr() {
		
		// Initialize variables
		Scanner input = new Scanner(System.in); 
		double[] array = new double[10]; 
		System.out.println("This program will take 10 nonnegative doubles.");
		
		// Loop over every element of input array
		for (int i = 0; i< array.length; i++) {
			
			// Loops while array value is less than or equal to 0. 
			do {
				System.out.println("Please enter a nonnegative double: ");
				
				// Check for bad string input
				if (!input.hasNextDouble()) {
					String invalidStr = input.next();
					System.out.println(invalidStr+" is an invalid input.");
				}
				
				// Check for bad double input
				else {
					double testDouble = input.nextDouble();
					if (testDouble < 0) {
						System.out.println(testDouble + " is an invalid input.");
					} 
					
					// If double passes all tests, add to array
					else {
						array[i]=testDouble;
					}
				} 
			} while(array[i] <= 0);
		}
		
		// Output array reference
		return array;
	}
	
	// Method that calculates and prints cube of each element
	public static void cubed(double[] array) {
		
		// Loops over every element to print cube 
		for (int i = 0; i < array.length; i++) {
			System.out.println("Cube of " + array[i] + ": " + Math.pow(array[i],3));
		}
		System.out.println();
	}
	
	// Method that caps any element value > 250 to 250. 
	public static void cap250(double[] array) {
		
		// Loop over every element of array
		for (int  i = 0; i < array.length; i++) {
			
			// Check to see if element > 250
			if (array[i] > 250) {
				array[i] = 250;
			}
		}
	}
	
	public static double[] inverse(double[] array) {
		
		// Loop over every element to copy each element into new array.
		double[] copyArr = new double[array.length];
		for (int i = 0; i < array.length; i++) {
			copyArr[i]=array[i];
		}
		
		// Replace original array values with inverse values
		for (int j = 0; j < array.length; j++) {
			array[j] = (double)(1 / array[j]);
		}
		
		// Return reference to copied array
		return copyArr;
	}
	
	// Method to print double array
	public static void display(double[] array) {
		
		// Loop through each element to print array
		for (int i = 0; i < array.length; i++) {
			if (i==0) {
				System.out.print("[ " + array[i] +", ");
			} else if (i==(array.length-1)){
				System.out.print(array[i]+"]");
			} else {
				System.out.print(array[i]+ ", ");
			}
			
		}
		System.out.println();
	}

}
