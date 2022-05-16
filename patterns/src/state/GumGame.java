package state;

import java.util.Scanner;

public class GumGame {
	private GumDispenser gumDispenser;

	public GumGame() {
		this.gumDispenser = new GumDispenser();
	}

	public void run() {
		Scanner scanner = new Scanner(System.in);
		boolean gotGum = false;

		while (!gotGum) {
			showMenu();
			int opt = Integer.parseInt(scanner.next());
			gotGum = act(opt);
		}

	}

	private boolean act(int opt) {
		System.out.println("Processing....");
		State state = gumDispenser.getState();
		return opt == 1 ? state.insert5() : opt == 2 ? state.insert10() : state.takeGum();
	}

	private void showMenu() {
		System.out.println("Please enter:");
		System.out.println("1 - if you're inserting a 5 cents coin");
		System.out.println("2 - if you're inserting a 10 cents coin");
		System.out.println("3 - To collect the gum...");
	}

}
