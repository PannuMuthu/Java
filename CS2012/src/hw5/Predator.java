package hw5;

public abstract class Predator extends Animal {
	public Predator(double weight, String name) {
		super(weight, name);
	}
	
	public void predate(Prey prey) {
		super.eat(prey.getWeight());
		System.out.println(this.getName() + " eats " + prey.getName());
	}
}
