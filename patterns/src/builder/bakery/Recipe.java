package builder.bakery;

public class Recipe {
	
	private String name;
	private int mozzarela;
	private int feta;
	private int mushrooms;
	private int pineapple;
	
	public Recipe(String name, int mozzarela, int feta, int mushrooms, int pineapple) {
		this.name = name;
		this.mozzarela = mozzarela;
		this.feta = feta;
		this.mushrooms = mushrooms;
		this.pineapple = pineapple;
	}

	@Override
	public String toString() {
		return "Recipe [name=" + name + ", mozzarela=" + mozzarela + ", feta=" + feta + ", mushrooms=" + mushrooms
				+ ", pineapple=" + pineapple + "]";
	}
	
	
	
	
	

}
