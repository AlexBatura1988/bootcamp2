package single_responsibility;

import java.util.ArrayList;

public class Spot implements Display  {
	public ArrayList<String> spots;

	@Override
	public void print() {
		String formattedRow = "";
		for(int i = 0; i < spots.size(); i++) {
			formattedRow = spots.get(i) + " | ";
		}
		System.out.println(formattedRow);
		
	}

}
