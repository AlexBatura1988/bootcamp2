package json;

import java.util.List;

public class Pastry {
	private String name;
	private double calories;
	private List<Ingredient> ingredient;
	private Label label;
	
	public Pastry() {}
	
	
	public Pastry(String name, double calories, List<Ingredient> ingredient, Label label) {
		
		this.name = name;
		this.calories = calories;
		this.ingredient = ingredient;
		this.label = label;
	}
	
	

	public Label getLabel() {
		return label;
	}


	@Override
	public String toString() {
		return "Pastry [name=" + name + ", calories=" + calories + ", ingredient=" + ingredient + ", label=" + label
				+ "]";
	}






	enum Label{
		DAIRY,MEAT,PAREVE
	}

}
