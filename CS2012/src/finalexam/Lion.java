package finalexam;

public class Lion extends Animal{
	public Lion() {
		this.weight = (Math.random()*1000);
	}
	@Override
	public String call() {
		return " roars";
	}

	@Override
	public String attack() {
		return " bares teeth and bites";
	}
	
	@Override 
	public String toString() {
		return " is a " + String.valueOf(weight) + " kg lion";
	}

}
