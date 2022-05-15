package command;

import java.time.LocalTime;

public class TurnOfCommand implements Command {

	@Override
	public String execute() {
		
		return "Heater turned off on: " + LocalTime.now();
	}

}
