package singelton.cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Runner {
	static List<Player> players = new ArrayList<>();

	public static void main(String[] args) {

		Deck deck = Deck.getInstance();
		System.out.println(deck);
		Player player1 = new Player("alex");
		Player player2 = new Player("mike");
		Player player3 = new Player("bob");
		players.add(player1);
		players.add(player2);
		players.add(player3);

		int i = 1;
		while (!deck.isEmpty()) {

			playRound();
			showRound(i);
			showWinner();

			i++;
		}
		
		System.out.println("the win player is: " + players.get(0));

	}

	private static void playRound() {

		players.forEach(p -> p.takeCard());
		Player maxPlayer = Collections.max(players, (p1, p2) -> p1.getCard() - p2.getCard());
		maxPlayer.addScore();
	}

	private static void showRound(int i) {
		System.out.println("----------Round " + i++);
		for (Iterator<Player> iterator = players.iterator(); iterator.hasNext();) {
			System.out.println(iterator.next());
		}
	}

	private static void showWinner() {
		System.out.println("\n******----------And The winner is ---------*****");
		Player maxPlayer = Collections.max(players, (p1, p2) -> p1.getScore() - p2.getScore());
		System.out.println(maxPlayer);
	}

}
