package exam5.ex1;

public class BadHelicopter {

	private String name;
	private int number;

	public BadHelicopter(String name, int number) {
		this.name = name;
		this.number = number;
	}

	public void yawsRight() {
		System.out.println("yaws right");

	}

	public void yawsLeft() {
		System.out.println("yaws left");

	}

	public void flyForward() {
		System.out.println("fly up");

	}

	public void flyBackward() {
		System.out.println("fly down");

	}

	public void launcchesMissile() {
		System.out.println("launches a missile");

	}

	@Override
	public String toString() {
		return "BadHelicopter [name=" + name + ", number=" + number + "]";
	}
	
	

}
