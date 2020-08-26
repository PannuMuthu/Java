package ch17;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.ArrayList;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.File;

public class ObjectIO{
	public static void main(String[] args){
		try{
			File outFile = new File("out.dat");
			File inFile  = new File("out.dat");

			Car c1 = new Car("green", 324.22, true);
			Car c2 = new Car("red", 33.22, false);
			Car c3 = new Car("blue", 567, true);
			Car c4 = new Car("yellow", 6, false);
			Car c5 = new Car("black", 3235.676, true);

			ArrayList<Car> list = new ArrayList<>();

			list.add(c1);
			list.add(c2);
			list.add(c3);
			list.add(c4);
			list.add(c5);

			ObjectOutputStream output = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(outFile)));

			output.writeObject(list);
			output.close();

			ObjectInputStream input = new ObjectInputStream(new BufferedInputStream(new FileInputStream(inFile)));
			ArrayList<Car> copyCar = (ArrayList<Car>) input.readObject();
			input.close();
			System.out.print(copyCar);


		} catch (FileNotFoundException e) { 
			e.printStackTrace();
		} catch (IOException e){
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	} 
}