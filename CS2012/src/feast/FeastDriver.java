package feast;

import java.util.Random;

public class FeastDriver {
	public static void main(String[] args) {
		Customer customer = new Customer();
		Portion portion;
		Random random = new Random();
		do {
			if(random.nextBoolean()) {
				portion = new Cupcake(Math.random()*10,Math.random()*10);
			} else  {
				portion = new Pancake(Math.random()*10);
			}
		} while(customer.eat(portion));
	}
}
