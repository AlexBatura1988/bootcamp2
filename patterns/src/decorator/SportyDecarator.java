package decorator;

public class SportyDecarator extends Decorator {

	public SportyDecarator(Dress wrapee) {
		super(wrapee);

	}

	public void create() {
		super.create();
		System.out.println("spotry added");
	}

}
