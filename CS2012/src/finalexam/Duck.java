package finalexam;

public class Duck extends Animal{
	
	public Duck() {
		this.weight = Math.random()*10;
	}
	
	@Override
	public String call() {
		return " quacks";
	}

	@Override
	public String attack() {
		return " pecks with its ferocious bill";
	}
	
	@Override 
	public String toString() {
		return " is a " + String.valueOf(weight) + " kg duck";
	}
	
}
