package ch24;

public class LinkedList<E extends Comparable<E>> {
	private Node<E> head;
	private Node<E> tail;
	private int size;
	
	public LinkedList() { 
		
	}
	
	
	//Adding to the first position of the linked list, O(1)
	public void addFirst(E data) {
		Node<E> newNode = new Node<>(data);
		
		//Case when list is empty
		if (this.head == null) { 
			this.head = newNode;
			this.tail =  newNode;
		}
		else {
			newNode.next = this.head;
			this.head = newNode;
		}
		
		this.size++;
	}
	
	//Adding to the last position of the linked list, O(1)
	public void addLast(E data) {
		Node<E> newNode = new Node<>(data);
		
		//When list is empty
		if (this.head == null) { 
			this.head = newNode;
			this.tail = newNode;
		} else {
			this.tail.next = newNode;
			this.tail = newNode; //Alternative: this.tail = this.tail.next
		}
		
		this.size++;
	}
	
	//Inserting to anywhere between the linked list, O(n)
	public void insert(int index, E data) {
		if (index < 0 || index > this.size) {
			throw new IndexOutOfBoundsException("Invalid Index!");
		} else if (index == 0) {
			this.addFirst(data);
		} else if (index == size) {
			this.addLast(data);
		} else {
			Node<E> newNode = new Node<>(data);
			Node<E> current = this.head;
			
			int count = 0;
			
			while(count < index - 1) { 
				current = current.next;
				count++;
			}
			
			newNode.next = current.next;
			current.next = newNode;
		}
		size++;
	}
	
	//Deleting the first node, O(1)
	public void deleteFirst() { 
		if (this.head == null) {
			//throw an exception
			//show exception
		}
		else if (this.size == 1){
			this.head = null;
			this.tail = null;
			
			this.size--;
		}
		else {
			this.head = this.head.next;
			this.size--;
		}
		
	}
	
	//Deleting the last node, O(n)
	public void deleteLast() {
		if (this.head == null) {
			//throw exception
			//show exception
			return;
		} else if(this.size == 1) {
			this.head = null;
			this.tail = null;
			size--;
		} else {
			Node<E> current = this.head;
			Node<E> previous = this.head;
			while (current.next != null) {
				previous = current;
				current = current.next;
			}
			previous.next = null;
			this.tail = previous;
			this.size--;
		}
	}
	
	//Deleting a node, O(n)
	public void delete(int index) {
		if (index < 0 || index >= this.size) {
			throw new IndexOutOfBoundsException("Invalid Index!");
		}
		
		if (index == 0) {
			this.deleteFirst();
		} else if (index == this.size - 1) { 
			this.deleteLast();
		} else {
			Node<E> current = this.head;
			int count = 0;
			while(count < index - 1) { 
				count++;
				current = current.next;
			}
			System.out.println("current node " + current);
			current.next = current.next.next;
			size--;
		}
	}
	
	
	//Printing a linked list, O(n)
	@Override
	public String toString() { 
		StringBuilder sb = new StringBuilder();
		
		Node<E> current = this.head;
		
		//DO NOT USE HEAD OR ELSE THE HEAD WILL MOVE TO THE END OF THE LIST AND WILL NEVER BE ACCESSIBLE AGAIN
		while(current != null) {
			sb.append(current + " ");
			current = current.next;
		}
		
		return sb.toString();
	}
	
	public int size() {
		return this.size;
	}
}
