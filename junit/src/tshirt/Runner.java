package tshirt;

import tshirt.Tshirt.Size;

public class Runner {

	public static void main(String[] args) {
		Tshirt[] shirts = new Tshirt[3];
		shirts[0] = new Tshirt();
		shirts[1] = new Tshirt(null, null, 0, 0);
		shirts[2] = new Tshirt(Size.XL, new Design(22.5d, 19.9d, "JAVA IS THE BEST", new Color(50, 50, 50), 11), 0.5d, 12.5d);

		for (Tshirt tShirt : shirts) {
			System.out.println(tShirt);
			System.out.println(tShirt.calculateFinalPrice()+" is expensive: "+tShirt.isExpensive());
			System.out.println("----------------------------");
		}

	}

}
