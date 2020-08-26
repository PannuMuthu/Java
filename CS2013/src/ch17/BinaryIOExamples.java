package ch17;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class BinaryIOExamples {
	public static void main(String[] args) {
		File outFile = new File("numbers.dat");
		File inFile = new File("numbers.dat");
		
		File filterOutput = new File("filtered_output.dat");
		File filterInput = new File("filtered_output.dat");
		
		try {
			DataOutputStream output = new DataOutputStream(new FileOutputStream(filterOutput));
			
			output.writeInt(Integer.MAX_VALUE);
			output.write(128);
			output.close();
			
			DataInputStream input = new DataInputStream(new FileInputStream(filterInput));
			System.out.println(input.read());
			System.out.println(input.readInt());
			input.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
