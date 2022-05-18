package json;

public class Ingredient {
	private String name;
	private double weight;

	public Ingredient() {

	}

	public Ingredient(String name, double weight) {
		this.name = name;
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Ingredient [name=" + name + ", weight=" + weight + "]";
	}
	
	

}
