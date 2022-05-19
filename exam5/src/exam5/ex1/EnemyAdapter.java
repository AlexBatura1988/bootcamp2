package exam5.ex1;

public class EnemyAdapter implements Enemy {
	
	BadHelicopter helicopter;

	public EnemyAdapter(BadHelicopter helicopter) {
		super();
		this.helicopter = helicopter;
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
		System.out.println("drive forward");
		
	}

	@Override
	public void driveBackward() {
		System.out.println("drive backward");
		
	}

	@Override
	public void fireWeapon() {
		System.out.println("fire ");
		
	}
	

}
