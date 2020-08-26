package ch24;

public class LinkedListTester {

	public static void main(String[] args) {
		LinkedList<Integer> list= new LinkedList<>();
		
		list.addLast(1);
		list.addLast(2);
		list.addLast(3);
		list.addLast(4);
		
		for (int i = 10; i <= 15; i++) {
			list.insert(list.size() - 1,i);
		}
		
		System.out.println(list);
		System.out.println(list.size());
		
		list.deleteFirst();
		list.delete(3);
		System.out.println(list);
		System.out.println(list.size());
	}

}
