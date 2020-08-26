package array2d;

public class Array2DTester {

	public static void main(String[] args) {
		System.out.println("Initializing a null 4 by 3 String Array2D: ");
		Array2D<String> list = new Array2D<>(4,3);
		System.out.println(list);
		System.out.println();
		
		System.out.println("Creating Array2D from Integer 2D array: ");
		Integer[][] input = {{3,4,1,6,4},{7,5,2,6,1},{7,6,2,2,5},{0,9,4,7,3}, {5,1,6,7,1}, {2,5,1,5,9}, {6,2,5,6,1}};
		Array2D<Integer> list2 = new Array2D<>(input);
		System.out.println(list2);
		System.out.println();
		
		System.out.println("Setting up new Array2D example:");
		String[][] input2 = {{"a","b","r","s"},{"f","e","d","i"},{"p","e","l","k"}, {"o","z","y","n"}};
		Array2D<String> list3 = new Array2D<>(input2);
		System.out.println(list3);
		
		System.out.println("Adding a column to the beginning of the list: ");
		list3.addFirstCol();
		System.out.println(list3);
		System.out.println("Adding a row to the beginning of the list: ");
		list3.addFirstRow();
		System.out.println(list3);
		System.out.println("Adding a column to the end of the list: ");
		list3.addLastCol();
		System.out.println(list3);
		System.out.println("Adding a row to the end of the list: ");
		list3.addLastRow();
		System.out.println(list3);
		
		System.out.println("Inserting a column in between the list:");
		list3.insertCol(2);
		System.out.println(list3);
		System.out.println("Inserting a row in between the list:");
		list3.insertRow(3);
		System.out.println(list3);
		
		System.out.println();
		System.out.println("Trying new Array2D Example:");
		System.out.println(list2);
		System.out.println("Deleting a column from the beginning of the list:");
		list2.deleteFirstCol();
		System.out.println(list2);
		System.out.println("Deleting a row from the beginning of the list:");
		list2.deleteFirstRow();
		System.out.println(list2);
		System.out.println("Deleting a column from the end of the list:");
		list2.deleteLastCol();
		System.out.println(list2);
		System.out.println("Deleting a row from the end of the list:");
		list2.deleteLastRow();
		System.out.println(list2);
		
		System.out.println("Deleting a column from in between the list:");
		list2.deleteCol(1);
		System.out.println(list2);
		System.out.println("Deleting a row from in between the list:");
		list2.deleteRow(2);
		System.out.println(list2);
		
		System.out.println();
		System.out.println("Setting up new Array2D example:");
		System.out.println();
		String[][] input3 = {{"lion","cat", "dog", "leopard", "coyote", "fish"}, {"panda","penguin","sheep","snake","goat","zebra"},{"octopus","moose","reindeer","snail","ant","bee"},{"lemur","monkey","human","shark","squid","bat"}};
		Array2D<String> list4 = new Array2D<>(input3);
		System.out.println(list4);
		System.out.println("Getting element of Array2D at specified index: (row=2, col=3)");
		System.out.println(list4.get(2, 3));
		System.out.println();
		System.out.println("Getting a column's data (col=4)");
		System.out.println(list4.getCol(4));
		System.out.println();
		System.out.println("Getting a row's data (row=0)");
		System.out.println(list4.getRow(0));
		System.out.println();
		System.out.println();
		System.out.println("Setting an element's data (row=3,col=1) = 'turtle':");
		System.out.println();
		list4.set(3,1,"turtle");
		System.out.println(list4);
		System.out.println("Checking size of Array2D:");
		System.out.println("Rows: " + list4.rowSize() + ", Cols: " + list4.colSize());
		System.out.println();
		System.out.println();
		System.out.println();

		System.out.println("Checking for exceptions:");
		System.out.println();
		System.out.println("Trying to input a negative column index in the 'set' method: ");
		try { 
			list4.set(3, -2, "rhino");
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Negative index exception successfully thrown + caught!");
		}
		System.out.println();
		System.out.println("Trying to input a row index larger than the size in the 'getRow' method: ");
		try { 
			list4.getRow(4);
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Out of bounds index exception successfully thrown + caught!");
		}
		System.out.println();
		System.out.println("Trying to print an empty Array2D in the 'toString' method:");
		try { 
			Array2D<Character> list5 = new Array2D<>();
			System.out.println(list5);
		} catch (NullPointerException e) {
			System.out.println("Unable to display empty list exception successfully thrown + caught!");
		}
		System.out.println();
		System.out.println();
		System.out.println("BONUS: Showing that all the doubly-linked connections work (by printing the array backwards with 'checkDoublyLinkedConnections' method)");
		System.out.println("\nOriginal List: ");
		System.out.println(list4);
		System.out.println(list4.checkDoublyLinkedConnections());


	}

}
