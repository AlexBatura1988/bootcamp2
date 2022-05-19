package exam5.ex1;

public class EnemyTank implements Enemy {
	
	private String name;
	private int number;
	

	public EnemyTank(String name, int number) {
		this.name = name;
		this.number = number;
	}

	@Override
	public void turnRight() {
		System.out.println("turn right");
		
	}

	@Override
	public void turnLeft() {
		
		System.out.println("turn left");
	}

	@Override
	public void driveForward() {
		System.out.println("drive forwad");
		
	}

	@Override
	public void driveBackward() {
		System.out.println("drive backward");
		
	}

	@Override
	public void fireWeapon() {
		System.out.println("fire");
		
	}

	@Override
	public String toString() {
		return "EnemyTank [name=" + name + ", number=" + number + "]";
	}
	

}
