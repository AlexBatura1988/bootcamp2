package state;

public class State5 extends State {

	public State5(GumDispenser dispenser) {
		super(dispenser);
		
	}

	@Override
	public boolean insert5() {
		System.out.println("balanse 10");
		dispenser.changeState(new State10(dispenser));
		return false;
	}

	@Override
	public boolean insert10() {
		System.out.println("balanse 15");
		dispenser.changeState(new State15(dispenser));
		return false;
	}

	@Override
	public boolean takeGum() {
		System.out.println("put more money");
		return false;
	}

	

}
