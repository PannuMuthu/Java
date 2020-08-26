package cars;

public class Car implements Comparable <Car>, Cloneable{
	private double weight;
	private Engine engine;
	
	public Car(double weight, Engine engine) {
		super();
		this.weight = weight;
		this.engine = engine;
	}
	
	public Car clone() {
		Car newCar = null;
		try {
			newCar = (Car) super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		newCar.engine = this.engine.clone();
		return newCar;
		
	}
	
	public int compareTo(Car otherCar) {
		if(Math.abs(weight - otherCar.weight) < 0.001) return 0;
		if(this.weight < otherCar.weight ) return -1;
		return 1;
		
	}
	
	public boolean equals(Object other) {
		if(other == this) return true;
		if(other == null) return false;
		if(!(other instanceof Car)) return false;
		Car otherCar = (Car) other;
		if(weight != otherCar.weight) return false;
		if(!(engine.equals(otherCar.engine))) return false;
		return true;
		
	}
	

	@Override
	public String toString() {
		return "Car [weight=" + weight + ", engine=" + engine + "]";
	}
	
	
	
}

