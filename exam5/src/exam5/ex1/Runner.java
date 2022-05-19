package exam5.ex1;

public class Runner {
	
	//Using design pattern adapter

	public static void main(String[] args) {
		EnemyTank enemyTank = new EnemyTank("Tank-1", 123);
		BadHelicopter badHelicopter = new BadHelicopter("Helicopter",111);
		Enemy enemyAdapter = new EnemyAdapter(badHelicopter);
		
		enemyTank.turnRight();
		badHelicopter.yawsRight();
		enemyAdapter.turnRight();

	}

}
