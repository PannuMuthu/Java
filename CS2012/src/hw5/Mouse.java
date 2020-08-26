package hw5;

public class Mouse extends Prey {
	public Mouse(double weight, String name) {
		super(weight,name);
	}

	@Override
	public void call() {
		System.out.println(this.getName() + " says 'Squeak'.");
	}
	
	@Override 
	public String toString() {
		return this.getName() + " is a Mouse weighing " + String.valueOf(this.getWeight()) + " grams";
	}

	@Override
	public void flee() {
		System.out.println(this.getName() + " scurried away just in time.");
		
	}
}
