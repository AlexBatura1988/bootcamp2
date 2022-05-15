package command;

import java.util.List;

public class Runner {
	private static final int MAX_HISTORY = 5;
	
	public static HistoryCommand history = new HistoryCommand(); 
	
	public static void turnOn(int timeInMinutes) {
		Command command = new TurnOnCommand(timeInMinutes);
		history.add(command);
		System.out.println(command.execute());
	}
	
	public static void turnOff() {
		Command command = new TurnOfCommand();
		history.add(command);
		System.out.println(command.execute());
	}
	public static void showHistory() {
		if(history.isEmty()) {
			return;
		}
		List<Command> commands = history.getHistory();
		for(int i = 0; i < MAX_HISTORY; i++) {
			System.out.println(commands.get(i).execute());
		}
		
		
	}

	public static void main(String[] args) {
		
		turnOn(30);
		turnOff();
		turnOn(123);
		turnOn(23);
		turnOff();
		turnOff();
		turnOn(222);
		turnOff();
		turnOn(13);
		System.out.println();
		showHistory();
		

	}

}
