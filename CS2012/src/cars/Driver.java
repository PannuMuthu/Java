package cars;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Driver {
	public static void main(String[] args) {
	Engine e1 = new Engine(2034, "gasoline");
	Engine e2 = new Engine(3123, "gasoline");
	Engine e3 = e2.clone();
	
	System.out.println(e1 == e2);
	System.out.println(e1.equals(e2));
	System.out.println(e2 == e3);
	System.out.println(e2.equals(e3));
	
	
	Car c1 = new Car(1000, e1);
	Car c2 = new Car(2000, e2);
	Car c3 = c2.clone();
	
	System.out.println(c1.equals(c2));
	System.out.println(c2 == c3);
	System.out.println(c2.equals(c3));
	
	
	
	}
}
