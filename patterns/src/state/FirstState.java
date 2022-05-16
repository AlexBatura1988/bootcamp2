package state;

public class FirstState extends State {

	public FirstState(GumDispenser dispenser) {
		super(dispenser);
		
	}

	@Override
	public boolean insert5() {
		System.out.println("balanse 5");
		dispenser.changeState(new State5(dispenser));
		return false;
	}

	@Override
	public boolean insert10() {
		System.out.println("balanse 10");
		dispenser.changeState(new State10(dispenser));
		return false;
	}

	@Override
	public boolean takeGum() {
		System.out.println("put more money");
		return false;
	}

}
