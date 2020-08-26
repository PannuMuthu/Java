package ch20;

public class DynamicList<E extends Comparable<E>> {
	private E[] elements;
	private final static int CAPACITY = 10;
	private int size = 0;
	
	public DynamicList() {
		this.elements = (E[]) new Comparable[DynamicList.CAPACITY];
	}
	
	public DynamicList(int capacity) { 
		this.elements = (E[]) new Comparable[capacity];
	}
	
	public int size() { 
		return this.size;
	}
	
	public void append(E item) {
		if (this.size == this.elements.length) {
	       this.resize();
	    }
	    this.elements[this.size] = item;
	    this.size++;
	}
	
	//Return first occurance of item
	//Return -1 if not found
	public int find (E item) {
		return 0;
	}
	
	public void insert(int index, E item) {
		//O(n)
	}
	
	public E get(int index) { 
		if (index < 0 || index >= this.size) { 
			throw new IndexOutOfBoundsException(index  + " is out of bounds.");
		}
		
		return this.elements[index];
	}
	
	private void resize() { 
		E[] temp = (E[]) new Comparable[this.elements.length *2];
		System.arraycopy(this.elements, 0, temp, 0, this.size);
		this.elements = temp;
	}
	
	public boolean contains(E item) {
		for (int i = 0; i < this.size; i++) { 
			if (item.equals(this.elements[i])) { 
				return true;
			}
		}
		return false;
	}
	
	public E delete(int index) {
		if (index < 0 || index >= this.size) { 
			throw new IndexOutOfBoundsException(index  + " is out of bounds.");
		}
		
		E temp = this.elements[index];
		
		for (int i = index; i < this.size - 1; i++) {
			this.elements[i] = this.elements[i+1];
		}
		
		this.size--;
		this.elements[this.size] = null;
		
		return temp;
	}
		
	@Override 
	public String toString() {
		StringBuilder result = new StringBuilder("[");
		
		for (int i = 0 ; i < this.size; i++) {
			result.append((i != this.size - 1)? this.elements[i] + ", " : this.elements[i] + "]");

		}
		
		return result.toString();
	}
}
