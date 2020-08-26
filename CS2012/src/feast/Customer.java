package feast;

public class Customer {
	private double calories = 0;
	private int pancakeCount = 0;
	private int cupcakeCount = 0;

	public double getCalories() {
		return calories;
	}

	public void setCalories(double calories) {
		this.calories = calories;
	}
	
	public boolean eat(Portion food) { 
		if (food instanceof Pancake) {
			pancakeCount++;
		} else if(food instanceof Cupcake){
			cupcakeCount++;
		}
		calories += food.getCalories();
		System.out.println(food.toString());
		if (calories > 10000) {
			System.out.println("Customer ate " + String.valueOf(pancakeCount) + " pancakes and " + String.valueOf(cupcakeCount) + " cupcakes before exploding.");
			return false;
		} 
		return true;
	}

	public int getPancakeCount() {
		return pancakeCount;
	}

	public void setPancakeCount(int pancakeCount) {
		this.pancakeCount = pancakeCount;
	}

	public int getCupcakeCount() {
		return cupcakeCount;
	}

	public void setCupcakeCount(int cupcakeCount) {
		this.cupcakeCount = cupcakeCount;
	}
	
}
