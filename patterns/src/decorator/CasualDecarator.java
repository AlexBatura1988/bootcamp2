package decorator;

public class CasualDecarator extends Decorator {

	public CasualDecarator(Dress wrapee) {
		super(wrapee);
		
	}
	public void create() {
		super.create();
		System.out.println("casual added");
	}

}
