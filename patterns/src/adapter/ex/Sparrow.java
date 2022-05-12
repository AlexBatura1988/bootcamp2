package adapter.ex;

public class Sparrow implements Flyable, Speakable {

	@Override
	public void speak() {
		System.out.println("Chirp,Chirp");
		
	}

	@Override
	public void fly() {
		System.out.println("Flying");
		
		
	}

}
