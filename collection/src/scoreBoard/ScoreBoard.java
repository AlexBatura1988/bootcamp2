package scoreBoard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class ScoreBoard {
	private final int SIZE = 4;
	private List<Player> players;
	List<Player> playersHighestScore = new ArrayList<>(SIZE);

	public ScoreBoard() {
		init();
	}

	private void init() {
		players = new ArrayList<>();
		Player player = new Player("Alex", "Israel", 100, 2);
		Player player1 = new Player("Den", "Russia", 100, 3);
		Player player2 = new Player("Bob", "USA", 100, 4);
		Player player3 = new Player("Lisa", "Argentina", 100, 5);
		Player player4 = new Player("Moshe", "Brasil", 100, 10);
		Player player5 = new Player("Margarete", "Germane", 100, 8);
		Player player6 = new Player("Roman", "Ukraine", 100, 1);
		players.add(player);
		players.add(player1);
		players.add(player2);
		players.add(player3);
		players.add(player4);
		players.add(player5);
		players.add(player6);
		System.out.println(players);
		update();
		System.out.println(players);
		showHighestScore();

	}

	public void update() {

		Random random = new Random();
		for (Player player : players) {
			if (random.nextBoolean()) {
				player.setScore((int) (player.getScore() + Math.random() * 20));
			} else {
				player.setScore((int) (player.getScore() - Math.random() * 20));
			}
		}
		Collections.sort(players);

	}

	public void showHighestScore() {

		int index = players.size();
		for (int i = 0; i < SIZE; i++) {
			playersHighestScore.add(players.get(--index));
		}
		System.out.println(playersHighestScore);
	}

	public void showByUserName() {
		Comparator<Player> nameComporator = new Comparator<Player>() {

			@Override
			public int compare(Player o1, Player o2) {
				return o1.getName().compareTo(o2.getName());
			}
		};
		Collections.sort(playersHighestScore, nameComporator);
		System.out.println(playersHighestScore);
	}
	
	public void showByUserCountry() {
		Comparator<Player> countryComporator = new Comparator<Player>() {

			@Override
			public int compare(Player o1, Player o2) {
				return o1.getCountry().compareTo(o2.getCountry());
			}
		};
		Collections.sort(playersHighestScore, countryComporator);
		System.out.println(playersHighestScore);
	}
	
	public void showByUserRank() {
		Comparator<Player> rankComporator = new Comparator<Player>() {

			@Override
			public int compare(Player o1, Player o2) {
				return o1.getRank() - o2.getRank();
			}
		};
		Collections.sort(playersHighestScore, rankComporator);
		System.out.println(playersHighestScore);
	}


	@Override
	public String toString() {
		return "ScoreTable [players=" + players + "]";
	}

}
