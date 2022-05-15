package decorator;

public class Runner {

	public static void main(String[] args) {
		BasicDress basicDress = new BasicDress("red", 1);
		basicDress.create();
		System.out.println();
		
		Dress fancy = new FancyDecarator(basicDress);
		fancy.create();
		System.out.println();
		
		Dress casual = new CasualDecarator(basicDress);
		casual.create();
		System.out.println();
		
		Dress fancySporty = new SportyDecarator(fancy);
		fancySporty.create();
		System.out.println();
		
		Dress fancyCasualy = new CasualDecarator(fancy);
		fancyCasualy.create();
		System.out.println();
		
		Dress sportyCausal = new FancyDecarator(new SportyDecarator(new CasualDecarator(basicDress)));
		sportyCausal.create();

	}

}
