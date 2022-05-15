package command;

import java.util.ArrayList;
import java.util.List;

public class HistoryCommand {
	private List<Command> history;

	public HistoryCommand() {

		this.history = new ArrayList<>();
	}
	
	public void add(Command comand) {
		history.add(comand);
	}
	
	public List<Command> getHistory(){
		return history;
	}
	
	public boolean isEmty() {
		return history.isEmpty();	}
	

}
