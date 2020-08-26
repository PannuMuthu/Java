package hw3;
import java.util.Scanner;

public class Address {
	Scanner input = new Scanner(System.in);
	private int streetNum;
	private String streetName;
	private String city;
	private String state;
	private String country;
	
	
	public Address() {
		System.out.println("Please enter the street number: ");
		int streetNum = input.nextInt();
		this.streetNum = streetNum;
		input.nextLine();
		System.out.println("Please enter the street name: ");
		String streetName = input.nextLine();
		this.streetName = streetName;
		System.out.println("Please enter the city: ");
		String city = input.nextLine();
		this.city = city;
		System.out.println("Please enter the state: ");
		String state = input.nextLine();
		this.state = state;
		System.out.println("Please enter the country: ");
		String country =  input.nextLine();
		this.country = country;
	}
	
	
	public String displayAllAddress() {
		return String.valueOf(streetNum) + " " + streetName + ", " + city + ", " + state + ", ";
	}
	
	
}
