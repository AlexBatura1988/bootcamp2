package state;

public class State20 extends State {

	public State20(GumDispenser dispenser) {
		super(dispenser);
		
	}

	@Override
	public boolean insert5() {
		System.out.println("balance 25");
		dispenser.changeState(new CollectGum(dispenser));
		return false;
	}

	@Override
	public boolean insert10() {
		System.out.println("more money");
		return false;
	}

	@Override
	public boolean takeGum() {
		System.out.println("put more money");
		return false;
	}

}
