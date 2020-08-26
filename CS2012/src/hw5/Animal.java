package hw5;

public abstract class Animal {
	private String name;
	private double weightInGrams;
	
	
	public Animal(double weight, String name) {
		this.name = name;
		this.weightInGrams = weight;
		
	}
	
	public void eat(double foodWeight) {
		weightInGrams+= foodWeight;
	}
	
	public abstract void call();
	
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public double getWeight() {
		return this.weightInGrams;
	}
	
	public void setWeight(double weight) {
		this.weightInGrams = weight;
	}
}
