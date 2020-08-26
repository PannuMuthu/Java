package ch21;

public abstract class Stack<E> {
	protected int size;
	
	public Stack() {
		
	}
	
	public int size() {
		return this.size;
		
	}
	
	public boolean isEmpty() {
		return this.size==0;
	}
	
	public abstract void push(E element);
	public abstract E peek();
	public abstract E pop();
}
