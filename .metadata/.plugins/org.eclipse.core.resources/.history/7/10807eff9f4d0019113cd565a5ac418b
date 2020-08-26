package project2;
import java.util.Scanner;

public class Interest {
	public static void main(String[] args) {
		
		//Setting up user input
		System.out.println("This program by Pratyush Muthukumar in CS 2011-05/06 will compute the total investment, amount in account, and interest for each month in a 5 month interest when a customer inputs $50 a month with quarterly interest.");
		Scanner input = new Scanner(System.in);
		
		//Asking for interest rate
		System.out.println("Please enter the annual percentage rate: ");
		double annualInterestRate = input.nextDouble();

		//Calling the method to display the chart
		display(annualInterestRate);
	}
	
	//Method to calculate investment column for a given month
	public static double investment(int month) {
		double investmentAmount = 50.0 * month;
		return investmentAmount;
	}
	
	//Method to calculate interest column for a given month
	public static double interest(int month, double interestRate) {
		
		double interestAmount=0.0;
		double previousInterest = 0.0;
		double quarterlyRate = interestRate/4.0;
		
		//Calculating interest for every 3rd month
		if (month % 3 == 0) {
			
			//Looping to sum the previous interests from previous quarterly cycles
			for (int i = 1; i < (month / 3);i++) {
				previousInterest += quarterlyRate*investment(month-(3*i));
			}
			interestAmount = (investment(month)+previousInterest) * quarterlyRate;
		}
		
		else {
			//Removing interest for months that are not multiples of 3.
			interestAmount = 0.0;
		}
		return interestAmount;
	}
	
	//Method to calculate new amount column for a given month
	public static double newAmount(int month, double interestRate) {
		
		double previousAmount = 0.0;
		double finalAmount = 0.0;
		
		//Calculating previous amount based on interest
		for (int i = 1; i <= (month/3); i++) {
			previousAmount += interest(i*3,interestRate);
		}
		//Removing interest from new amounts with month multiple 3
		if (month % 3 == 0) {
		finalAmount = previousAmount+investment(month)-interest(month,interestRate);

		} else{
		//Adding previous interest amount to investment to get new amount for all other months
		finalAmount = previousAmount+investment(month);
		}
		
		return finalAmount;
	}
	
	//Method to calculate savings column for a given month
	public static double totalSavings(int month, double interestRate) {
		
		//Total savings is the sum of interest plus new amount
		double savings = interest(month, interestRate)+newAmount(month, interestRate);
		return savings;
		
	}

	//Method to display the chart for 60 months
	public static void display(double interestRate) {
		double decimal = interestRate/100.0;
		System.out.println("MONTH       INVESTMENT       NEW AMOUNT     INTEREST        TOTAL SAVING");
		System.out.println("____________________________________________________________________________");
		for (int i = 1; i <= 60; i++) {
			System.out.printf("\n %2d"
					+ " \t %10.2f"
					+ " \t %10.2f "
					+ "\t %10.2f "
					+ "\t %10.2f", i, investment(i),newAmount(i,decimal), interest(i,decimal), totalSavings(i,decimal));
		}
		System.out.println("\n ____________________________________________________________________________");
	}
}
