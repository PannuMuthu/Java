package ch19;

public class GenericStackTester {
	public static void main(String[] args) {
		GenericStack<Integer> stackInt = new GenericStack<>();
		stackInt.push(134);
		stackInt.push(241);
		stackInt.push(300);
		stackInt.push(484);
		System.out.println(stackInt);
		
		GenericStack<String> stackString = new GenericStack<>();
		stackString.push("java");
		stackString.push("python");
		stackString.push("c++");
		System.out.println(stackString);
		
		stackString.pop();
		stackString.pop();
		stackInt.pop();
		System.out.println(stackInt);
		System.out.println(stackString);
	}
}
