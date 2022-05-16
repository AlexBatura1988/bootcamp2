package state;

public abstract class State {
	GumDispenser dispenser;
	
	
	
	public State(GumDispenser dispenser) {
		this.dispenser = dispenser;
	}
	
	public abstract boolean insert5();
	public abstract boolean insert10();
	public abstract boolean takeGum();

}
