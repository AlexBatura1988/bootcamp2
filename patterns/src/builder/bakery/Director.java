package builder.bakery;

public class Director {
	private final  String PIZZA = "Hawaiian piza";
	private final int MOZZ_PIZZA = 100;
	private final int FETTA_PIZZA = 40;
	private final int MUSHROOM_PIZZA = 20;
	private final int PINAPPLE_PIZZA = 25;
	
	private final String DOM = "Dominican";
	private final int MOZZ_DOM = 10;
	private final int FETTA_DOM = 100;
	private final int MUSHROOM_DOM = 20;
	private final int PINAPPLE_DOM = 15;
	
	public void buildPizza(Builder builder) {
		builder.setName(PIZZA);
		builder.setMozzCheese(MOZZ_PIZZA);
		builder.setFetaCheese(FETTA_PIZZA);
		builder.setMushroom(MUSHROOM_PIZZA);
		builder.setPineapple(PINAPPLE_PIZZA);
	}
	
	public void buildDominican(Builder builder) {
		builder.setName(DOM);
		builder.setMozzCheese(MOZZ_DOM);
		builder.setFetaCheese(FETTA_DOM);
		builder.setMushroom(MUSHROOM_DOM);
		builder.setPineapple(PINAPPLE_DOM);
	}
	
	

}
