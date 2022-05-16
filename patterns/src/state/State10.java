package state;

public class State10 extends State{

	public State10(GumDispenser dispenser) {
		super(dispenser);
		
	}

	@Override
	public boolean insert5() {
		System.out.println("balanse 15");
		dispenser.changeState(new State15(dispenser));
		return false;
	}

	@Override
	public boolean insert10() {
		System.out.println("balanse 20");
		dispenser.changeState(new State20(dispenser));
		return false;
	}

	@Override
	public boolean takeGum() {
		System.out.println("put more money");
		return false;
	}

}
