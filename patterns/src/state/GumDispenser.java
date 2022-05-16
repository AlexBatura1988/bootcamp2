package state;

public class GumDispenser {
	private State state;

	public GumDispenser() {
		this.state = new FirstState(this);
	}

	public State getState() {
		return state;
	}
	
	public void changeState(State state) {
		this.state = state;
	}
	
	
	
	
	
	

}
