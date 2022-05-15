package command;

import java.time.LocalTime;

public class TurnOnCommand implements Command {
	private final int MAX_TIME = 90;

	private int time;

	public TurnOnCommand(int time) {

		setTime(time);
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		if (time > 0 && time <= MAX_TIME) {
			this.time = time;
		}
		else {
			this.time = MAX_TIME;
		}
	}

	@Override
	public String execute() {

		return " Heater turned on for " + time + " munutes on  " + LocalTime.now();
	}

	
	

}
