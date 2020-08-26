package ch21;

//Use array implementation of stack when you know the max elements needed for the stack
public class ArrayStack<E> extends Stack<E> {
	private E[] data;
	private int top;
	private final static int CAPACITY = 1000;
	
	public ArrayStack() {
		this(CAPACITY);
	}
	
	public ArrayStack(int capacity) {
		this.data = (E[]) new Object[capacity];
		this.top = 0;
	}
	
	//Adding an element to the top of the stack: O(1)
	@Override
	public void push(E element) {
		if (super.size() == this.data.length) { 
			throw new IllegalStateException("Stack is full!");
		} else {
			this.data[++this.top] = element;
			super.size++;
		}
	}
	
	//Getting the element at the top of the stack but not altering it: O(1) 
	@Override
	public E peek() {
		if (super.isEmpty()) { 
			return null;
		}
		
		return this.data[top];
	}
	
	//Getting the element at the top of the stack and removing it: O(1)
	@Override
	public E pop() {
		if (super.isEmpty()) { 
			return null;
		}
		E temp = this.peek();
		this.data[this.top] = null;
		this.top--;
		this.size--;
		return temp;
	}
}
