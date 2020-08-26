package finalexam;

public class ZooDriver {
	public static void main(String[] args) {
		Zoo zoo = new Zoo();
		Duck duck1 = new Duck();
		zoo.addAnimal(duck1);
		Lion lion1 = new Lion();
		zoo.addAnimal(lion1);
		Duck duck2 = new Duck();
		zoo.addAnimal(duck2);
		Duck duck3 = new Duck();
		zoo.addAnimal(duck3);
		Lion lion2 = new Lion();
		zoo.addAnimal(lion2);
		Duck duck4 = new Duck();
		zoo.addAnimal(duck4);
		
		zoo.listAnimals();
		zoo.makeNoise();
		zoo.jailBreak();
		
	}
}
