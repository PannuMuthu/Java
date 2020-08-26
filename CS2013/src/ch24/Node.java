package ch24;

public class Node<E extends Comparable<E>> {
	protected E data;
	protected Node<E> next;
	
	public Node(E data) {
		this.data = data;
	}
	
	@Override
	public String toString() { 
		return this.data.toString();
	}
	
}
