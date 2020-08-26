package encryption;
import java.util.Arrays;
import java.util.Scanner;


public class Encryption {
	public static void main (String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Encode or decode? (1 for encode, 2 for decode)");
		//int response = input.nextInt();
		decode();
		/*if (response==1) {
			encode();
		} else if(response==2) {
			decode();
		} 
		*/
	}
	
	public static void encode() {
		String arrayString = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789 '()*+,-./;:<=>[]^?";
		Character[] arr = new Character[81];
		Character[][] array = new Character[9][9];
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the code word: ");
		String codeWord = input.nextLine();
		System.out.println("Enter the message: ");
		String message = input.nextLine();
		int index = 0; 
		String str = new String();
		 for (int i = 0; i < codeWord.length(); i++)  
	        { 
	            // character at i'th index of s 
	            char c = codeWord.charAt(i); 
	              
	            // if c is present in str, it returns 
	            // the index of c, else it returns -1 
	            if (str.indexOf(c) < 0) 
	            { 
	                // adding c to str if -1 is returned 
	                str += c; 
	            } 
	        } 
		 
		 /*
	     System.out.println(str);
		*/
		
		for (int i=0; i<str.length(); i++) {
			
			arr[index] = str.charAt(i);
			index++;
			
		}
		for (int j = 0; j < 200; j++) {
			if (index < 81) {
				if (str.indexOf(arrayString.charAt(j))<0) {
					arr[index]=arrayString.charAt(j);
					index++;
				}
			}
			
		}
		

		for(int i=0; i<9;i++) {
			for(int j=0;j<9;j++) {
				array[i][j] = arr[(j*9) + i]; 
			}
		}
			
				
		/*
		for (int k = 0; k < 9; k++) {
			System.out.println();
			for (int l = 0; l < 9; l++) {
				System.out.print(array[l][k]+ " ,");
			}
		}
		*/
		char I1 = 0;
		char I2 = 0;
		
		String encoded = "";
		int I1row = 0,I1col=0,I2row = 0,I2col = 0;
		for (int i = 0; i < message.length(); i+=2) {
			I1 = message.charAt(i);
			I2 = message.charAt(i+1);
			for (int j=0; j<9; j++) {
				for (int k=0;k<9; k++) {
					if (array[j][k]==I1) {
						I1row=j;
						I1col=k;
					}
				}
			}
			for (int j=0; j<9; j++) {
				for (int k=0;k<9; k++) {
					if (array[j][k]==I2) {
						I2row=j;
						I2col=k;
					}
				}
			}
			
			if (I1row==I2row) {
				if(I1col==8) {
					encoded += array[I1row][0];
				}
				else if(I2col==8) {
					encoded += array[I2row][0];
				}
				else {
					encoded += array[I1row][I1col+1];
					encoded += array[I2row][I2col+1];
				}
			}
			
			if (I1col==I2col) {
				if(I1row==8) {
					encoded += array[0][I1col];
				}
				else if(I2row==8) {
					encoded += array[0][I2col];
				}
				else {
					encoded += array[I1row+1][I1col];
					encoded += array[I2row+1][I2col];
				}
			}
			
			else {
				encoded += array[I1row][I2col];
				encoded += array[I2row][I1col];
			}
			
		}
		System.out.println(encoded);
	}
	public static void decode() {
		String arrayString = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789 '()*+,-./;:<=>[]^?";
		Character[] arr = new Character[81];
		Character[][] array = new Character[9][9];
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the code word: ");
		String codeWord = "Cryptography Is Fun.";
		System.out.println("Enter the encrypted code: ");
		String message = "rg3FpmJutugYFIaI.Xun[B";
		int index = 0; 
		String str = new String();
		 for (int i = 0; i < codeWord.length(); i++)  
	        { 
	            // character at i'th index of s 
	            char c = codeWord.charAt(i); 
	              
	            // if c is present in str, it returns 
	            // the index of c, else it returns -1 
	            if (str.indexOf(c) < 0) 
	            { 
	                // adding c to str if -1 is returned 
	                str += c; 
	            } 
	        } 
		 
		 /*
	     System.out.println(str);
		*/
		
		for (int i=0; i<str.length(); i++) {
			
			arr[index] = str.charAt(i);
			index++;
			
		}
		for (int j = 0; j < 200; j++) {
			if (index < 81) {
				if (str.indexOf(arrayString.charAt(j))<0) {
					arr[index]=arrayString.charAt(j);
					index++;
				}
			}
			
		}
		

		for(int i=0; i<9;i++) {
			for(int j=0;j<9;j++) {
				array[i][j] = arr[(j*9) + i]; 
			}
		}
		
		
		
		char I1 = 0;
		char I2 = 0;
		
		String decoded = "";
		int I1row = 0,I1col=0,I2row = 0,I2col = 0;
		for (int i = 0; i < message.length(); i+=2) {
			I1 = message.charAt(i);
			I2 = message.charAt(i+1);
			for (int j=0; j<9; j++) {
				for (int k=0;k<9; k++) {
					if (array[j][k]==I1) {
						I1row=j;
						I1col=k;
					}
				}
			}
			for (int j=0; j<9; j++) {
				for (int k=0;k<9; k++) {
					if (array[j][k]==I2) {
						I2row=j;
						I2col=k;
					}
				}
			}
			
			if (I1row==I2row) {
				if(I1col==0) {
					decoded += array[I1row][0];
				}
				else if(I2col==0) {
					decoded += array[I2row][0];
				}
				else {
					decoded += array[I1row][I1col-1];
					decoded += array[I2row][I2col-1];
				}
			}
			
			if (I1col==I2col) {
				if(I1row==0) {
					decoded += array[0][I1col];
				}
				else if(I2row==0) {
					decoded += array[0][I2col];
				}
				else {
					decoded += array[I1row-1][I1col];
					decoded += array[I2row-1][I2col];
				}
			}
			
			else {
				decoded += array[I1row][I2col];
				decoded += array[I2row][I1col];
			}
		
		
		}
		
		System.out.println(decoded);
	}
	
}
