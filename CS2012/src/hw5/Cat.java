package hw5;

public class Cat extends Predator {
	public Cat(String name, double weight) {
		super(weight,name);
	}

	@Override
	public void call() {
		System.out.println(this.getName() + " says 'Meow'.");
	}
	
	@Override 
	public String toString() {
		return this.getName() + " is a Cat weighing " + this.getWeight() + " grams";
	}
}
