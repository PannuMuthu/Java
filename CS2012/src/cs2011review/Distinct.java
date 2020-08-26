package cs2011review;			
import java.util.Scanner;

public class Distinct{
	public static void main (String[] args){
		Scanner input = new Scanner(System.in);
		System.out.println("This will count the distinct numbers. Please enter # of #s: ");
		int arrLength = input.nextInt();
		int[] array = new int[arrLength];
		System.out.println("Enter the numbers one at a time: ");
		for (int i = 0; i< array.length; i++){
			array[i]=input.nextInt();
		}
		distinct(array);
	}
	public static void distinct(int[] array){
		int[] result = new int[array.length]; 
		int finalIndex = 0;
		int distinctCount = 0;
		for (int i=0; i<result.length; i++){
			if (linearSearch(array, array[i], i)==-1){
				result[finalIndex]=array[i];
				distinctCount++;
				finalIndex++;
			}
		}
		System.out.println("Distinct List: ");
		for (int j = 0; j < result.length; j++){
			System.out.print(result[j]+" ");
		}
		System.out.println("There were "+distinctCount+" distinct numbers and "+(array.length-distinctCount)+" repeated numbers.");
	}
	public static int linearSearch(int[] array, int key, int index){
		for (int i = 0; i < array.length; i++){
			if(array[i]==key && i != index){
				return i;
			}
		}
		return -1;
	}
}