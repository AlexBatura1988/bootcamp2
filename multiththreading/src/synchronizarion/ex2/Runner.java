package synchronizarion.ex2;

import java.util.ArrayList;
import java.util.List;

public class Runner {

	private static final int SIZE = 5;
	

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();

		Thread pr = new Thread(new Service(list));
		Thread con = new Thread(new Marketing(list));
		
		con.start();
		pr.start();

	}

}
