package cars;

public class Engine implements Cloneable, Comparable<Engine>{
	private double displacement;
	private String type;
	
	public Engine(double displacement, String type) {
		super();
		this.displacement = displacement;
		this.type = type;
	}
	
	public Engine clone() {
		String newType = new String(type);
		return new Engine(displacement, newType);
		
	}
	
	@Override
	public int compareTo(Engine other) {
		if (other.displacement == this.displacement) {
			return 0;
		} else if (this.displacement < other.displacement) {
			return -1;
		} else {
			return 1;
		}
		
	}
	
	
	public boolean equals(Object other) {
		if(other == this) return true;
		if(other == null) return false;
		if(! (other instanceof Engine)) return false;
		Engine otherEngine = (Engine) other;
		if(this.displacement == otherEngine.displacement && this.type.equals(otherEngine.type)) return true;
		return false;		
	}

	@Override
	public String toString() {
		return "Engine [displacement=" + displacement + ", type=" + type + "]";
	} 
	
	
	
}

