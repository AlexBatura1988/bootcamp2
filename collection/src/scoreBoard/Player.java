package scoreBoard;

import java.util.Objects;

public class Player implements Comparable<Player> {

	private String name;
	private String country;
	private int score;
	private int rank;

	public Player(String name, String country, int score, int rank) {
		this.name = name;
		this.country = country;
		this.score = score;
		this.rank = rank;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	@Override
	public int hashCode() {
		return Objects.hash(score);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Player other = (Player) obj;
		return score == other.score;
	}

	@Override
	public int compareTo(Player o) {

		return this.getScore() - o.getScore();
	}

	@Override
	public String toString() {
		return "Player [name=" + name + ", country=" + country + ", score=" + score + ", rank=" + rank + "]";
	}

}
