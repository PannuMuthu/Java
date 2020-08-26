package myarray;

public class MyArrayDriver {
	public static void main(String[] args) { 
		//Initializing various arrays
		MyArray<Integer> intArray = new MyArray<>(12,35,1,46,210);
		MyArray<Character> charArray = new MyArray<>('a','4','.','P','*');
		MyArray<String> stringArray = new MyArray<>("Zebra", "Baton", "Avocado" ,"Pencil", "Dog");
		
		//Using the 'toString' and 'size' methods
		System.out.println("Integer Array: " + intArray);
		System.out.println("Integer Array Size: " + intArray.size());
		System.out.println();
		
		System.out.println("Char Array: " + charArray);
		System.out.println("Char Array Size: " + charArray.size());
		System.out.println();

		
		System.out.println("String Array: " + stringArray);
		System.out.println("String Array Size: " + stringArray.size());
		System.out.println();

		
		//Using the 'get' method
		MyArray smallStringArray = stringArray.get(2,3);
		System.out.println("Small String Array(indexes 2-3): " + smallStringArray);
		System.out.println();

		
		//Using the 'equals' method
		System.out.println("Small String Array = String Array? " + smallStringArray.equals(stringArray));
		MyArray<Character> charArray2 = new MyArray<>('a','4','.','Q','&');
		System.out.println("Char Array = Char Array 2? " + charArray.equals(charArray2));
		System.out.println("Int Array = Int Array? " + intArray.equals(intArray));
		System.out.println();


		
		//Using the 'min'/'max' methods
		System.out.println("Min of Int Array: " + intArray.min());
		System.out.println("Max of String Array: " + stringArray.max());
		System.out.println();

		
		//Using the 'reverse' method
		System.out.println("Original Character Array: " + charArray);
		charArray.reverse();
		System.out.println("Reversing the Character Array: " + charArray);
		System.out.println();
		
		
		//Using the 'left shift' and 'right shift' methods
		System.out.println("Original String Array: " + stringArray);
		stringArray.leftShift(3);
		System.out.println("Left Shifted 3 Indexes: " + stringArray);
		stringArray.rightShift(1);
		System.out.println("Right Shifted 1 Index: " + stringArray);
		stringArray.rightShift(2);
		System.out.println("Right Shifted 2 More Indexes: " + stringArray);
		System.out.println();

		//Using the 'shuffle' method
		System.out.println("Original Int Array: " + intArray);
		intArray.shuffle();
		System.out.println("Shuffled Int Array: " + intArray);
		System.out.println();
		
		//Using the 'sort' method
		System.out.println("Original Int Array: " + intArray);
		intArray.sort();
		System.out.println("Sorted Int Array: " + intArray);
		System.out.println();
		System.out.println("Original String Array: " + stringArray);
		stringArray.sort();
		System.out.println("Sorted String Array: " + stringArray);
		System.out.println();
		
		//Testing the exceptions
		try { 
			System.out.println("Trying to use the 'put' method with a negative index:");
			stringArray.put(-1, "lion");
		} catch(IndexOutOfBoundsException e) {
			
			System.out.println("IndexOutOfBoundsException was thrown and caught");
		}
		
		System.out.println();
		
		try { 
			
			System.out.println("Trying to use the 'get' method with an index larger than the array length:");
			intArray.get(10, 5);
		} catch(IndexOutOfBoundsException e) {
			
			System.out.println("IndexOutOfBoundsException was thrown and caught");
		}
		
		System.out.println();
		
		try { 
			System.out.println("Trying to use the 'put' method with more values than are indicated with the indices:");
			stringArray.put(0, 2, "cat", "snake", "box", "water", "net", "bird");
		} catch(InvalidNumberOfValuesException e) {
			
			System.out.println("InvalidNumberOfValuesException was thrown and caught");
		}
		
		System.out.println();
		
		try { 
			System.out.println("Trying to use the 'put' method with less values than are indicated with the indices:");
			charArray.put(0, 4, '%', 'o');
		} catch(InvalidNumberOfValuesException e) {
			
			System.out.println("InvalidNumberOfValuesException was thrown and caught");
		}
		
		System.out.println();
		
		try { 
			System.out.println("Trying to use the 'leftShift' method with a negative shift distance:");
			stringArray.leftShift(-3);
		} catch(ShiftDistanceCannotBeNegativeException e) {
			System.out.println("ShiftDistanceCannotBeNegativeException was thrown and caught");
		}
		
		System.out.println();
		
		try { 
			System.out.println("Trying to use the 'rightShift' method with a negative shift distance:");
			charArray.rightShift(-3);
		} catch(ShiftDistanceCannotBeNegativeException e) {
			System.out.println("ShiftDistanceCannotBeNegativeException was thrown and caught");
		}
	}
}
