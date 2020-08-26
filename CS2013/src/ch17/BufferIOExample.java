package ch17;

import java.io.DataOutputStream;
import java.io.BufferedOutputStream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

public class BufferIOExample {
	public static void main(String[] args) {
		File outFile = new File("buffered_data.dat");
		
		try {
			DataOutputStream output = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(outFile)));
			
			
			Random r = new Random();
			long start = System.currentTimeMillis();

			for (int i=1;i <= 10000000; i++) {
				output.write(r.nextInt(256));
			}
			output.close();
			long end = System.currentTimeMillis();
			System.out.println((end-start) + "ms");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
