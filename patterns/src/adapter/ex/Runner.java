package adapter.ex;

public class Runner {

	public static void main(String[] args) {
		Sparrow sparrow = new Sparrow();
		PlasticToyDuck duck = new PlasticToyDuck();
		
		sparrow.fly();
		sparrow.speak();
		
		BirdToToyDuckAdapter adapter = new BirdToToyDuckAdapter(sparrow);
		duck.squeak();
		adapter.squeak();
		
		

	}

}
