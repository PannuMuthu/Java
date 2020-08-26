package myarray;

public class InvalidNumberOfValuesException extends RuntimeException {
	// I used InvalidNumberOfValuesException instead of TooManyValuesException because there can also be the 
	//case where there aren't enough values in the input, so I lumped them together for the invalid number of values.
	public InvalidNumberOfValuesException(String message) {
		super(message);
	}
}
