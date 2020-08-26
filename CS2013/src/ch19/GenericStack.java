package ch19;
import java.util.ArrayList;

public class GenericStack<E> {
	//Design Pattern: Adaptor Design Pattern
	//cant extend arraylist bc it doesnt extend arraylist
	private ArrayList<E> list = new ArrayList<>();
	
	public GenericStack() {
		
	}
	
	public int getSize() {
		return list.size();
	}
	
	public E peek() {
		return list.get(getSize() - 1);	
	}
	
	public void push(E o) {
		list.add(o);
	}
	
	public E pop() { 
		E o = list.get(getSize()-1);
		list.remove(getSize()-1);
		return o;
		
	}
	
	public boolean isEmpty() {
		return list.isEmpty();
	}
	
	@Override
	public String toString() {
		return "Stack: " + this.list;
	}
	
}
