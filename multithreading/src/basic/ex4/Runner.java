package basic.ex4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Runner {
	final static int SIZE = 100000;
	static List<Integer> list1 = new ArrayList<>(SIZE);
	static List<Integer> list2 = new ArrayList<>(SIZE);

	public static void main(String[] args) {
		for(int i = 0; i < SIZE; i++) {
			list1.add(i);
			list2.add(i +SIZE);
		}
		list1.set(100, -2);
		
		Thread t1 = new Thread(hasNegative,"Negative finder Thread");
		Thread t2 = new Thread(hasCommonElement,"Common finder thread");
		t2.setDaemon(true);
		t1.start();
		t2.start();
		

	}
	
	static Runnable hasCommonElement = () -> {
		for(Integer i : list1) {
			int result = Collections.binarySearch(list2, i);
			if(result == 0) {
				System.out.println(Thread.currentThread().getName() + " FOUND a common value");
			}
			
		}
		System.out.println(Thread.currentThread().getName() + " NOT found a common value");
		
	};
	
	static Runnable hasNegative = () ->{
		for(Integer i : list1) {
			try {
				Thread.sleep(1);
				if(i < 0) {
					System.out.println(Thread.currentThread().getName() + " Found negative value");
					return;
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		System.out.println(Thread.currentThread().getName() + " NOT Found negative value");
		
	};

}
