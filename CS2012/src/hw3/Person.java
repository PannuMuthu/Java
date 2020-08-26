package hw3;
import java.util.Scanner;

public class Person {
	protected String name;
	protected Address address;
	Scanner input = new Scanner(System.in);
	
	public Person() {
		System.out.println("Please enter the person's name: ");
		String name = input.nextLine();
		this.name = name;
		Address address = new Address();
		this.address = address;
	}

	
	public String getName() {
		return name;
	}
	
	public Address getAddress() {
		return address;
	}

	
}
