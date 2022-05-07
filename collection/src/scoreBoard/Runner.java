package scoreBoard;

public class Runner {

	public static void main(String[] args) {
		ScoreBoard scoreTable = new ScoreBoard();
		System.out.println("----------------");
		scoreTable.showByUserName();
		scoreTable.showByUserCountry();
		scoreTable.showByUserRank();

	}

}
