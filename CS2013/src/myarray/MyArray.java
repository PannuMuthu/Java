package myarray;

import java.util.Random;

public class MyArray<E extends Comparable> {
	//No other data fields necessary.
    public E[] data;

    public MyArray(int size) {
        this.data = (E[])(new Comparable[size]);
    }

    //This constructor can accept an array or a comma-separated list of values.
    public MyArray(E ... elements) {
        this.data = (E[])(new Comparable[elements.length]);
        //Make a deep copy to prevent shared references.
        System.arraycopy(elements, 0, this.data, 0, elements.length);
    }
    
    public E get(int index){
    	return data[index];
    }
    
    public MyArray<E> get(int start, int end) {
    	if (start > end || start < 0 || end > data.length-1) { 
    		throw new IndexOutOfBoundsException();
    	}
    	MyArray<E> miniArray = new MyArray<>((end-start)+1);
    	int j = 0;
    	for (int i = start; i <= end; i++) {
    		miniArray.put(j, data[i]);
    		j++;
    	}
    	return miniArray;
    	
    }
    
    public void put(int index, E value) {
    	if (index < 0 || index > data.length - 1) {
    		throw new IndexOutOfBoundsException();
    	}
    	data[index] = value;
    	
    }
    
    public void put(int start, int end, E ... array) {
    	if (start > end || start < 0 || end > data.length-1) { 
    		throw new IndexOutOfBoundsException();
    	}
    	if (array.length != (end-start + 1)) { 
    		throw new InvalidNumberOfValuesException("You are trying to add too many or too few values!");
    	}
    	System.arraycopy(array, 0, this.data, start, array.length);
    }
    
    @Override
    public boolean equals(Object other) {
    	if (other == this) {
			return true;
		} else if(other == null){
			return false;
		} else if(!(other instanceof MyArray)) {
			return false;
		}
		MyArray<E> o = (MyArray<E>) other;
		if (o.size() != data.length) {
			return false;
		}
		for (int i= 0; i < o.data.length; i++) {
			if (o.data[i] == this.data[i]) {
			} else {
				return false;
			}
		}
		
		return true;
		
    }
    
    public E min() {
    	E temp = data[0];
    	for (int i = 0; i < data.length; i++) {
    		if (temp.compareTo(data[i]) > 0) {
    			temp = data[i];
    		}
    	}
    	return temp;
    }
    
    public E max() { 
    	E temp = data[0];
    	for (int i = 0; i < data.length; i++) {
    		if (temp.compareTo(data[i]) < 0) {
    			temp = data[i];
    		}
    	}
    	return temp;
    }
    
    public void reverse() {
    	E temp;
    	for (int i = 0; i < (data.length/2); i++) {
    		temp = data[i];
    		data[i] = data[data.length - i - 1];
    		data[data.length - i - 1] = temp;
    	}
    }
    
    public void shuffle() {
    	Random random = new Random();
    	
    	for (int i = 0; i < data.length; i++) {
    		int randomIndex = random.nextInt(data.length);
    		E temp = data[i];
    		data[i] = data[randomIndex];
    		data[randomIndex] = temp;
    	}
    }
    public void leftShift(int shiftDistance) {
    	if (shiftDistance < 0) {
    		throw new ShiftDistanceCannotBeNegativeException("The shift distance cannot be negative!");
    	}
    	for (int  i = 0; i < shiftDistance; i++) { 
    		int j;
    		E temp;
    		temp = data[0];
    		for (j = 0; j < data.length - 1; j++) {
    			data[j] = data[j + 1];
    		}
    		data[j] = temp;
    	}
    }
    
    public void rightShift(int shiftDistance) { 
    	if (shiftDistance < 0) {
    		throw new ShiftDistanceCannotBeNegativeException("The shift distance cannot be negative!");
    	}
    	for (int  i = 0; i < shiftDistance; i++) { 
    		int j;
    		E temp;
    		temp = data[data.length-1];
    		for (j = data.length-1; j > 0; j--) {
    			data[j] = data[j - 1];
    		}
    		data[j] = temp;
    	}
    }
    
    public int size() { 
    	return data.length;
    }
    
    @Override
    public String toString() {
		String out = "";
		for (int i = 0; i < data.length; i++) {
			out +=  String.valueOf(data[i]) + ", ";
		}
    	return out;
    }
    
    public void sort() {
    	 boolean sorted = true;
    	    do {
    	      sorted = false;
    	      for (int j = 0; j < data.length - 1; j++) {
    	        if (data[j].compareTo(data[j+1]) > 0) {
    	          E temp = data[j];
    	          data[j] = data[j + 1];
    	          data[j + 1] = temp;
    	          sorted = true;
    	        }
    	      }
    	    } while (sorted);
    }
    
    

}
