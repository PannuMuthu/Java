package array2d;

import java.util.ArrayList;

public class Array2D<E extends Comparable<E>> {
	private Array2DNode<E> head;
	private Array2DNode<E> tail;
	private int rows;
	private int cols;
	
	public Array2D() {
		
	}
	
	public Array2D(int rows, int cols) {
		if (rows < 0 || cols < 0) { 
			throw new IndexOutOfBoundsException("Invalid size!");
		}
		while (this.rows < rows) {
			this.addLastRow();
			while (this.cols < cols) {
				this.addLastCol();
			}
		}
	}
	
	public Array2D(E[][] array) {
		while (this.rows < array.length) { 
			this.addFirstRow();
			while (this.cols < array[0].length) {
				this.addFirstCol();
			}
		}
		
		for (int i = 0; i < array.length; i++) { 
			for (int j = 0; j < array[0].length; j++) { 
				this.set(i, j, array[i][j]);
			}
		}
		
	}
	
	
	public void addFirstCol() { 
		if (this.head == null) { 
			Array2DNode<E> start = new Array2DNode<>();
			this.head = start;
			this.tail = start;
			this.rows++;
			this.cols++;
		} else {
			Array2DNode<E> current = new Array2DNode<>();
			this.head.prevCol = current;
			current.nextCol = this.head;
			this.head = current;
			int currentRow = 0;
			while (currentRow < rows - 1) { 
				current.nextRow = new Array2DNode<>();
				current.nextRow.prevRow = current;
				current = current.nextRow;
				current.nextCol = current.prevRow.nextCol.nextRow;
				current.prevRow.nextCol.nextRow.prevCol = current;
				currentRow++;
			}
			this.cols++;
		}
		
	}
	
	public void addFirstRow() { 
		if (this.head == null) { 
			Array2DNode<E> start = new Array2DNode<>();
			this.head = start;
			this.tail = start;
			this.rows++;
			this.cols++;
		} else {
			Array2DNode<E> current = new Array2DNode<>();
			this.head.prevRow = current;
			current.nextRow = this.head;
			this.head = current;
			int currentCol = 0;
			while (currentCol < cols - 1) { 
				current.nextCol = new Array2DNode<>();
				current.nextCol.prevCol = current;
				current = current.nextCol;
				current.nextRow = current.prevCol.nextRow.nextCol;
				current.prevCol.nextRow.nextCol.prevRow = current;
				currentCol++;
			}
			this.rows++;
		}
	}
	
	public void addLastCol() { 
		if (this.head == null) { 
			Array2DNode<E> start = new Array2DNode<>();
			this.head = start;
			this.tail = start;
			this.rows++;
			this.cols++;
		} else {
			Array2DNode<E> current = this.head;
			while(current.nextCol != null) {
				current = current.nextCol;
			}
			int currentRow = 0;
			current.nextCol = new Array2DNode<E>();
			current.nextCol.prevCol = current;
			current = current.nextCol;
			while (currentRow <  this.rows - 1) { 
				current.nextRow = new Array2DNode<E>();
				current.nextRow.prevRow = current;
				current = current.nextRow;
				current.prevCol = current.prevRow.prevCol.nextRow;
				current.prevRow.prevCol.nextRow.nextCol = current;
				currentRow++;
			}
			this.tail = current;
			this.cols++;
		}
	}
	
	public void addLastRow() { 
		if (this.head == null) { 
			Array2DNode<E> start = new Array2DNode<>();
			this.head = start;
			this.tail = start;
			this.rows++;
			this.cols++;
		} else {
			Array2DNode<E> current = this.head;
			while(current.nextRow != null) {
				current = current.nextRow;
			}
			int currentCol = 0;
			current.nextRow = new Array2DNode<E>();
			current.nextRow.prevRow = current;
			current = current.nextRow;
			while (currentCol <  this.cols - 1) { 
				current.nextCol = new Array2DNode<E>();
				current.nextCol.prevCol = current;
				current = current.nextCol;
				current.prevRow = current.prevCol.prevRow.nextCol;
				current.prevCol.prevRow.nextCol.nextRow = current;
				currentCol++;
			}
			this.tail = current;
			this.rows++;
		}
	}
	
	public void insertCol(int index) { 
		if (index < 0 || index > this.cols) { 
			throw new IndexOutOfBoundsException("Invalid index!");
		} else if(index == 0) { 
			this.addFirstCol();
		} else if(index == this.cols) { 
			this.addLastCol();
		} else { 
			Array2DNode<E> newCol = new Array2DNode<>();
			Array2DNode<E> current = this.head;
			int count = 0;
			while (count < index - 1) { 
				current = current.nextCol;
				count++;
			}
			
			int currentRow = 0;
			newCol.prevCol = current;
			newCol.nextCol = current.nextCol;
			current.nextCol.prevCol = newCol;
			current.nextCol = newCol;
			while(currentRow < this.rows - 1) { 
				newCol.nextRow = new Array2DNode<>();
				newCol.nextRow.prevRow = newCol;
				newCol = newCol.nextRow;
				current = current.nextRow;
				newCol.prevCol = current;
				newCol.nextCol = current.nextCol;
				current.nextCol.prevCol = newCol;
				current.nextCol = newCol;
				
				currentRow++;
			}
			this.cols++;
		}
	}
	
	public void insertRow(int index) {
		if (index < 0 || index > this.rows) { 
			throw new IndexOutOfBoundsException("Invalid index!");
		} else if(index == 0) { 
			this.addFirstRow();
		} else if(index == this.rows) { 
			this.addLastRow();
		} else { 
			Array2DNode<E> newRow = new Array2DNode<>();
			Array2DNode<E> current = this.head;
			int count = 0;
			while (count < index - 1) { 
				current = current.nextRow;
				count++;
			}
			
			int currentCol = 0;
			newRow.prevRow = current;
			newRow.nextRow = current.nextRow;
			current.nextRow.prevRow = newRow;
			current.nextRow = newRow;
			while(currentCol < this.cols - 1) { 
				newRow.nextCol = new Array2DNode<>();
				newRow.nextCol.prevCol = newRow;
				newRow = newRow.nextCol;
				current = current.nextCol;
				newRow.prevRow = current;
				newRow.nextRow = current.nextRow;
				current.nextRow.prevRow = newRow;
				current.nextRow = newRow;
				
				currentCol++;
			}
			this.rows++;
		}
	}
	
	public void deleteFirstCol() { 
		if (this.head == null) { 
			throw new IndexOutOfBoundsException("There is no list to delete!");
		} else if (this.cols == 1 ) { 
			this.head = null;
			this.tail = null;
			this.cols--;
		} else { 
			Array2DNode<E> current = this.head.nextCol;
			this.head = this.head.nextCol;
			int currentRow = 0;
			while (currentRow < this.rows - 1) {
				current.prevCol = null;
				current = current.nextRow;
				currentRow++;
			}
			this.cols--;
		}
	}
	
	public void deleteFirstRow() { 
		if (this.head == null) { 
			throw new IndexOutOfBoundsException("There is no list to delete!");
		} else if (this.rows == 1) { 
			this.head = null;
			this.tail = null;
			this.rows--;
		} else {
			Array2DNode<E> current = this.head.nextRow;
			this.head = this.head.nextRow;
			int currentCol = 0;
			while (currentCol < this.cols - 1) {
				current.prevRow = null;
				current = current.nextCol;
				currentCol++;
			}
			this.rows--;
		}
	}
	
	public void deleteLastCol() { 
		if (this.head == null) { 
			throw new IndexOutOfBoundsException("There is no list to delete!");
		} else if (this.cols == 1) { 
			this.head = null;
			this.tail = null;
			this.cols--;
		} else {
			Array2DNode<E> current = this.tail.prevCol;
			this.tail = this.tail.prevCol;
			int currentRow = 0;
			while(currentRow < this.rows) {
				current.nextCol = null;
				current = current.prevRow;
				currentRow++;
			}
			this.cols--;
		}
	}
	
	public void deleteLastRow() { 
		if (this.head == null) { 
			throw new IndexOutOfBoundsException("There is no list to delete!");
		} else if (this.rows == 1) { 
			this.head = null;
			this.tail = null;
			this.rows--;
		} else {
			Array2DNode<E> current = this.tail.prevRow;
			this.tail = this.tail.prevRow;
			int currentCol = 0;
			while(currentCol < this.cols) {
				current.nextRow = null;
				current = current.prevCol;
				currentCol++;
			}
			this.rows--;
		}
	}
	
	
	public void deleteCol(int index) { 
		if (index < 0 || index >= this.cols) {
			throw new IndexOutOfBoundsException("Invalid Index!");
		}
		
		if (index == 0) {
			this.deleteFirstCol();
		} else if (index == this.cols - 1) { 
			this.deleteLastCol();
		} else {
			Array2DNode<E> current = this.head;
			int count = 0;
			while (count < index - 1) { 
				current = current.nextCol;
				count++;
			}
			current.nextCol = current.nextCol.nextCol;
			current.nextCol.prevCol = current;
			int currentRow = 0;
			while (currentRow < this.rows - 1) { 
				current = current.nextRow;
				current.nextCol = current.nextCol.nextCol;
				current.nextCol.prevCol = current;
				currentRow++;
			}
				this.cols--;
		}
	}
	
	public void deleteRow(int index) { 
		if (index < 0 || index >= this.rows) {
			throw new IndexOutOfBoundsException("Invalid Index!");
		}
		
		if (index == 0) {
			this.deleteFirstRow();
		} else if (index == this.rows - 1) { 
			this.deleteLastRow();
		} else {
			Array2DNode<E> current = this.head;
			int count = 0;
			while (count < index - 1) { 
				current = current.nextRow;
				count++;
			}
			current.nextRow = current.nextRow.nextRow;
			current.nextRow.prevRow = current;
			int currentCol = 0;
			while (currentCol < this.cols - 1) { 
				current = current.nextCol;
				current.nextRow = current.nextRow.nextRow;
				current.nextRow.prevRow = current;
				currentCol++;
			}
				this.rows--;
		}
	}
	
	public E get(int row, int col) { 
		if (row < 0 || row >= this.rows || col < 0 || col >= this.cols) {
			throw new IndexOutOfBoundsException("Invalid Index!");
		} else {
			Array2DNode<E> current = this.head;
			int currentRow = 0;
			int currentCol = 0;
			while(currentRow < row) { 
				current = current.nextRow;
				currentRow++;
			}
			while(currentCol < col) {
				current = current.nextCol;
				currentCol++;
			}
			
			return current.data;
		}
		
	}
	
	public ArrayList<E> getCol(int col) { 
		if (col < 0 || col >= this.cols) {
			throw new IndexOutOfBoundsException("Invalid Index!");
		} else {
			ArrayList<E> list = new ArrayList<>();
			Array2DNode<E> current = this.head;
			int count = 0;
			while(count < col) {
				current = current.nextCol;
				count++;
			}
			int currentRow = 0;
			while (currentRow < this.rows) { 
				list.add(current.data);
				current = current.nextRow;
				currentRow++;
			}
			return list;
		}
	}
	
	public ArrayList<E> getRow(int row) { 
		if (row < 0 || row >= this.rows) {
			throw new IndexOutOfBoundsException("Invalid Index!");
		} else {
			ArrayList<E> list = new ArrayList<>();
			Array2DNode<E> current = this.head;
			int count = 0;
			while(count < row) {
				current = current.nextRow;
				count++;
			}
			int currentCol = 0;
			while (currentCol < this.cols) { 
				list.add(current.data);
				current = current.nextCol;
				currentCol++;
			}
			return list;
		}
	}
	
	public void set(int row, int col, E data) { 
		if (row < 0 || col < 0 || row >= this.rows || col >= this.cols) {
			throw new IndexOutOfBoundsException("Invalid Index!");
		}
		Array2DNode<E> current = this.head;
		int currentCol = 0;
		int currentRow = 0;
		
		while(currentCol < col) {
			current = current.nextCol;
			currentCol++;
		}
		
		while (currentRow < row) {
			current = current.nextRow;
			currentRow++;
		}
		
		current.data = data;
	}
	
	
	public int colSize() {
		return this.cols;
	}
	
	public int rowSize() {
		return this.rows;
	}
	
	@Override
	public String toString() { 
		if (this.head == null) { 
			throw new NullPointerException("There is no list to display!");
		} else {
		StringBuilder sb = new StringBuilder();
		Array2DNode<E> currentRow = this.head;
		
		do {
			Array2DNode<E> currentCol = currentRow;
			while (currentCol != null) {
				sb.append(currentCol + " ");
				currentCol = currentCol.nextCol;
			}
			sb.append("\n");
			currentRow = currentRow.nextRow;
		} while(currentRow != null);
		return sb.toString();
		
	}
	}
	
	public String checkDoublyLinkedConnections() {
		if (this.head == null) { 
			throw new NullPointerException("There is no list to display!");
		} else {
		StringBuilder sb = new StringBuilder();
		Array2DNode<E> currentRow = this.tail;
		sb.append("Showing all prevRow connections:\n\n");
		do {
			Array2DNode<E> currentCol = currentRow;
			while (currentCol != null) {
				sb.append(currentCol + " ");
				currentCol = currentCol.prevCol;
			}
			sb.append("\n");
			currentRow = currentRow.prevRow;
		} while(currentRow != null);
		
		sb.append("\nShowing all prevCol connections:");
		sb.append("\n\n");
		currentRow = this.tail;
		do {
			Array2DNode<E> currentCol = currentRow;
			while (currentCol != null) {
				sb.append(currentCol + " ");
				currentCol = currentCol.prevRow;
			}
			sb.append("\n");
			currentRow = currentRow.prevCol;
		} while(currentRow != null);
		return sb.toString();
		
	}
	}
}
