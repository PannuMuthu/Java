package finalexam;

public abstract class Animal {
	protected double weight;
	public double getWeight(Animal animal) {
		return animal.weight;
	}
	public abstract String call();
	public abstract String attack();
}
