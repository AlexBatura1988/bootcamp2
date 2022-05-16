package state;

public class CollectGum extends State {

	public CollectGum(GumDispenser dispenser) {
		super(dispenser);
		
	}

	@Override
	public boolean insert5() {
		System.out.println("take the gum first");
		return false;
	}

	@Override
	public boolean insert10() {
		System.out.println("take the gum first");
		return false;
	}

	@Override
	public boolean takeGum() {
		System.out.println("nyam nyam very tasty");
		return true;
	}

}
