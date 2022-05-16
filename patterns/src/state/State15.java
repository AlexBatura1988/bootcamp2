package state;

public class State15 extends State {

	public State15(GumDispenser dispenser) {
		super(dispenser);
		
	}

	@Override
	public boolean insert5() {
		System.out.println("balance 20");
		dispenser.changeState(new State20(dispenser));
		return false;
	}

	@Override
	public boolean insert10() {
		System.out.println("balance 25");
		dispenser.changeState(new CollectGum(dispenser));
		return false;
	}

	@Override
	public boolean takeGum() {
		System.out.println("put more money");
		return false;
	}

}
