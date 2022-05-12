package builder.bakery;

public class RecipeBuilder implements Builder {
	
	private String name;
	private int mozzarela;
	private int feta;
	private int mushrooms;
	private int pineapple;
	

	@Override
	public void setName(String name) {
		this.name = name;
		
	}

	@Override
	public void setMozzCheese(int mozzCheese) {
		this.mozzarela = mozzCheese;
		
	}

	@Override
	public void setFetaCheese(int fetaCheese) {
		this.feta = fetaCheese;
		
	}

	@Override
	public void setMushroom(int mushrooms) {
		this.mushrooms = mushrooms;
		
	}

	@Override
	public void setPineapple(int pineapple) {
		this.pineapple = pineapple;
		
	}
	
	public Recipe getRecipe() {
		return new Recipe(name, mozzarela, feta, mushrooms, pineapple);
	}

}
