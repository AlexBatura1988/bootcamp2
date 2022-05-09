package learningLamda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Runner {

	public static void main(String[] args) {
		List<String> strList = Arrays.asList("1", "2", "3", "4");
		List<Integer> intList = new ArrayList<>();

		/**
		 * old way
		 */
//		for(int i = 0; i < strList.size(); i++) {
//			int parsed = Integer.parseInt(strList.get(i));
//			intList.add(parsed);
//		}
//		System.out.println(intList);

//	System.out.println("------------------------------------------------");

		/**
		 * new way
		 */

//		intList = strList.stream()
//				.map(str-> Integer.parseInt(str))
//				.collect(Collectors.toList());
//		System.out.println(intList);
		
		//System.out.println("------------------------------------------------------");
		
		Printable printable = new Printable() {
			
			@Override
			public void print(String message) {
				System.out.println(message);
				
			}
		};
		printable.print("this is the message from Printable");
		
		Printable p = (m) -> System.out.println(m);
		p.print("hello from lambda");
		

	}

}
