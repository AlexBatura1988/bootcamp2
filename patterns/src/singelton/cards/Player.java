package singelton.cards;

public class Player {
	private String name;
	private int score;
	private int card;
	private Deck deck;

	public Player(String name) {
		this.name = name;
		this.score = 0;
		this.card = 0;
		this.deck = Deck.getInstance();
	}

	public void takeCard() {
		card = deck.takeCard();

	}

	public int getCard() {
		return card;
	}

	public void addScore() {
		score++;
	}

	public int getScore() {
		return score;
	}

	public Deck getDeck() {
		return deck;
	}

	@Override
	public String toString() {
		return "Player [name=" + name + ", score=" + score + ", card=" + card + "]";
	}
	

	

}
