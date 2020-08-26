package inClassStuff;
import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;

public class Count {
	public static void main(String[] args) throws Exception {
		File sourceFile = new File(args[0]);
		ArrayList<String> lines = new ArrayList<>();
		if (!sourceFile.exists()) {
			System.out.println("Source file does not exist");
			System.exit(1);
		}
		
		if(args.length!=1) {
			System.out.println("Usage: java Count.java sourceFile");
			System.exit(2);
		}
		
		try (
				Scanner input = new Scanner(sourceFile);
				) {
			while(input.hasNextLine()) {
				String nextLine = input.nextLine();
				lines.add(nextLine);
			}
		}
		int lineCount = lines.size();
		int wordCount = 0;
		int charCount = 0;
		for (int i = 0; i < lines.size(); i++) {
			String[] words = lines.get(i).split(" ");
			wordCount += words.length;
			for (int j = 0; j < words.length; j++) {
				charCount += words[j].length();
			}
			if (words.length >= 2) {
				charCount += words.length - 1;
			}
		}
		System.out.println("File " + args[0] + " contains");
		System.out.println(charCount + " characters");
		System.out.println(wordCount + " words");
		System.out.println(lineCount + " lines");
		
	}
}
