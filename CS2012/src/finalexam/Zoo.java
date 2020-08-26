package finalexam;
import java.util.ArrayList;

public class Zoo {
	ArrayList<Animal> zooList = new ArrayList<Animal>();
	public void addAnimal(Animal a) {
		zooList.add(a);
	}
	public void listAnimals() {
		System.out.println("The zoo contains the following animals:");
		for (int i = 0; i < zooList.size(); i++) {
			System.out.println("Animal " + i + zooList.get(i).toString());
		}
	}
	public void makeNoise() {
		for (int i = 0; i < zooList.size(); i++) {
			System.out.println("Animal " + i + zooList.get(i).call());
		}
	}
	
	public void jailBreak() { 
		for (int i = 0; i < zooList.size(); i++) {
			System.out.println("Animal " + i + zooList.get(i).attack());
		}
	}
}
