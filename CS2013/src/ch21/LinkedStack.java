package ch21;
import java.util.LinkedList;

public class LinkedStack<E> extends Stack<E> {
	
	//Adapter Design Pattern
	private LinkedList<E> stack = new LinkedList<E>();
	
	public LinkedStack()  {
		
	}
	
	@Override
	public int size() {
		return this.stack.size();
	}
	
	
	
	@Override
	public void push(E element) {
		this.stack.addFirst(element);
	}

	@Override
	public E peek() {
		return this.stack.getFirst();
	}

	@Override
	public E pop() {
		return this.stack.removeFirst();
	}
	
}
