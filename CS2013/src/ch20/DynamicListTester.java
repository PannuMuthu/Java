package ch20;

import java.util.Random;

public class DynamicListTester {
	public static void main(String[] args) {
		DynamicList<Integer> list = new DynamicList(1);
		for (int i = 1 ; i <= 20; i++) {
			list.append(i);
		}
		
		Random r = new Random();
		
		for (int i = 1 ; i <= 20; i++) {
			int value = list.delete(r.nextInt(list.size()));
			System.out.println("deleted " + value);
			System.out.println(list);
		}
	
		System.out.println(list);
	}
}
