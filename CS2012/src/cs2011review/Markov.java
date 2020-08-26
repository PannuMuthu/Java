package cs2011review;
import java.util.Scanner;

public class Markov {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("This will check if the matrix is a Markov matrix. Please enter dimension of nxn matrix(n): ");
		int arrDim = input.nextInt();
		double[][] array = new double[arrDim][arrDim]; 
		System.out.println("Enter the values one by one");
		for (int i = 0; i< array.length; i++) {
			for (int j =0; j<array[i].length; j++) {
				array[i][j]= input.nextDouble();
			}
		}
		System.out.println("This is a Markov matrix: "+isMarkov(array));
	}
	public static boolean isMarkov(double[][] array) {
		for (int row = 0; row<array.length;row++) {
			for (int column = 0; column<array[row].length;column++) {
				if(array[row][column]<=0) {
					return false;
				}
			}
		}
		double sumCol = 0;
		for(int i=0; i<array.length;i++) {
			sumCol = 0;
			for(int j = 0; j<array.length;j++) {
				sumCol+=array[j][i];
			}
			if(sumCol != 1) {
				return false;
			} 
		}
		return true;
	}
}
