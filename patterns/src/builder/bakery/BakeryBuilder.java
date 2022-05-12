package builder.bakery;

public class BakeryBuilder implements Builder {

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
	public void setMushroom(int mashrooms) {
		this.mushrooms = mashrooms;

	}

	@Override
	public void setPineapple(int pineapple) {
		this.pineapple = pineapple;

	}

	public Bakery getBakery() {
		return new Bakery(name, mozzarela, feta, mushrooms, pineapple);
	}

}
