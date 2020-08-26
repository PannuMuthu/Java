package hw5;
import java.util.Random;
import java.util.ArrayList;

public class AnimalDriver {
	public static void main(String[] arg) {
		Random r = new Random();
		Cat precious = new Cat("Precious", 1223.34);

		ArrayList <Prey> prey = new ArrayList<Prey>();
		Mouse m1 = new Mouse(25.3, "Mickey");
		Mouse m2 = new Mouse(28.0, "Minnie");
		Bird b1 = new Bird(50.9, "Daisy");
		Bird b2 = new Bird(55.1, "Donald");

		prey.add(m1);
		prey.add(m2);
		prey.add(b1);
		prey.add(b2);

		System.out.println(precious.toString());
		precious.call();
		
		StringBuilder sb = new StringBuilder();
		for (Prey p : prey)
			sb.append(p.toString() + "\n");
		System.out.println(sb);

		for (Prey p : prey) {
			p.call();
			if (r.nextBoolean() == false)
				p.flee();
			else
				precious.predate(p);
		}
	}
}
