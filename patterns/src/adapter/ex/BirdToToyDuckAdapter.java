package adapter.ex;

public class BirdToToyDuckAdapter implements DuckToyable {
	
	Speakable bird;
	
	

	public BirdToToyDuckAdapter(Speakable bird) {
		this.bird = bird;
	}



	@Override
	public void squeak() {
		System.out.println("This may sound like a bird but its a Toy duck squeaking: ");
		bird.speak();
		
	}

}
