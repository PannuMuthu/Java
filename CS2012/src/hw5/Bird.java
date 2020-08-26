package hw5;

public class Bird extends Prey {
	public Bird(double weight, String name) {
		super(weight,name);
	}

	@Override
	public void call() {
		System.out.println(this.getName() + " says 'Chirp Chirp'.");
	}
	
	@Override 
	public String toString() {
		return this.getName() + " is a Bird weighing " + String.valueOf(this.getWeight()) + " grams";
	}

	@Override
	public void flee() {
		System.out.println(this.getName() + " flies away just in time.");
		
	}
}
