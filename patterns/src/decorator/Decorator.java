package decorator;

public class Decorator implements Dress {
	
	private Dress wrapee;
	
	public Decorator(Dress wrapee) {
		
		this.wrapee = wrapee;
	}



	@Override
	public void create() {
		wrapee.create();
		
	}

}
