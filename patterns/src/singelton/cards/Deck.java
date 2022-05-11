package singelton.cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Deck {
	private final int SIZE = 60;
	private List<Integer> cards;

	private static Deck instance;

	private Deck() {
		cards = new ArrayList<>();
		for (int i = 1; i <= SIZE; i++) {
			cards.add(i);
		}
		Collections.shuffle(cards, new Random());
	}

	public static Deck getInstance() {
		if (instance == null) {
			instance = new Deck();
		}
		return instance;
	}

	public int takeCard() {
		int card = 0;
		if (!cards.isEmpty()) {
			card = cards.get(0);
			cards.remove(cards.get(0));

		}
		return card;
	}
	

	public List<Integer> getCards() {
		return cards;
	}

	public boolean isEmpty() {
		return cards.isEmpty();
	}

	@Override
	public String toString() {
		return "Deck [cards=" + cards + "]";
	}

}
