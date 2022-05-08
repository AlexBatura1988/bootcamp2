package ex1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Runner {

	public static void main(String[] args) {
		
		MyList<Integer> t = new MyList<>(5);
		List<Integer> list = Arrays.asList(100,200,300);
		//List<Integer> rev = t.reverse(list);
		t.reverse(list);
		
		System.out.println(list);
		
		
		
		
		
	

	}

}
