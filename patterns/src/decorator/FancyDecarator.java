package decorator;

public class FancyDecarator extends Decorator {

	public FancyDecarator(Dress wrapee) {
		super(wrapee);
	}

	@Override
	public void create() {
		super.create();
		System.out.println("Fanciness added");
	}

}
