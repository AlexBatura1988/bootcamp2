package single_responsibility;

import java.util.ArrayList;

public class Board {

	public ArrayList<String> spots;

	public Board() {
		this.spots = new ArrayList<String>();
		for (int i = 0; i < spots.size(); i++) {
			this.spots.add(String.valueOf(i));
		}
	}

}
