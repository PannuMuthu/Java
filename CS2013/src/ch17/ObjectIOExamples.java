package ch17;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ObjectIOExamples {
	public static void main(String[] args) {
		Circle c1 = new Circle(10.5, "blue", true);
		Circle c2 = new Circle(6, "green", false);
		Circle c3 = new Circle(123.27, "red", false);
		Circle c4 = new Circle(15, "yellow", false);
		Circle c5 = new Circle(158.35, "orange", true);
		
		ArrayList<Circle> list = new ArrayList<>();
		
		list.add(c1);
		list.add(c2);
		list.add(c3);
		list.add(c4);
		list.add(c5);
		
		
		try {
			ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("circles.dat"));
			output.writeObject(list);
			output.close();
			
			ObjectInputStream input = new ObjectInputStream(new FileInputStream("circles.dat"));
			ArrayList<Circle> copyList = (ArrayList<Circle>) input.readObject();
			input.close();
			System.out.print(copyList);
			System.out.println();
			
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
}
