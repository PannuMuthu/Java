package cs2011review;
import java.io.File;
import java.util.Scanner;

public class FileCount {
	public static void main (String[] args) throws Exception {
		
		if (args.length != 3) {
			System.out.println("Usage: java FileCount sourceFile");
			System.exit(1);
		}	
		
		File sourceFile = new File(args[0]);
		if (!sourceFile.exists()) {
			System.out.println("Source file " + args[0]+" does not exist");
		}
		
		Scanner input = new Scanner(sourceFile);
		int lineCount = 0;
		int wordCount = 0;
		int charCount = 0;
		while(input.hasNextLine()) {
			String instLine = input.nextLine();
			String[] array = instLine.split("\n");
			for (int i = 0; i<array.length; i++) {
				System.out.println(array[i]);
			}
			lineCount++;
			
		}
	}
}
