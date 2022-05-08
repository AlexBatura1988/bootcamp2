package ex1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MyList<T> implements Reversable<T> {
	
	protected T t;
	

	public MyList(T t) {
		this.t = t;
	}


	@Override
	public List<T> reverse(List<T> t) {
		List<T> reverseL = new ArrayList<>(t);
		Collections.reverse(t);
		return t;
		
		
	}


	

}
