package builder.bakery;

public class Runner {

	public static void main(String[] args) {
		Director director = new Director();
		BakeryBuilder bakeryBuilder = new BakeryBuilder();
		
		director.buildDominican(bakeryBuilder);
		
		Bakery dominican = bakeryBuilder.getBakery();
		System.out.println(dominican);
		
		director.buildPizza(bakeryBuilder);
		Bakery pizza = bakeryBuilder.getBakery();
		
		System.out.println(pizza);
		
		RecipeBuilder recipeBuilder = new RecipeBuilder();
		director.buildDominican(recipeBuilder);
		
		Recipe pizzaRec = recipeBuilder.getRecipe();
		System.out.println(pizzaRec);
		
	}

}
