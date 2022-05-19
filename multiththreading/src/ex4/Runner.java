package ex4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Runner {
	public static final int SIZE = 1000;
	static List<Integer> list1 = new ArrayList<>();
	static List<Integer> list2 = new ArrayList<>();

	public static void main(String[] args) {


		for (int i = 0; i < SIZE; i++) {
			list1.add(i);
			list2.add(SIZE + i);
		}
		// System.out.println(list1);
		// System.out.println(list2);
		list1.set((int) (Math.random() * 999), -1);
		
		Thread thread1 = new Thread(hasNegative,"Negative Finder");
		Thread thread2 = new Thread(hasCommonElement,"Common finder");
		thread2.setDaemon(true);
		thread1.start();
		thread2.start();
		

	}

	static Runnable hasNegative =() ->{
		for(Integer i : list1) {
			try {
				Thread.sleep(0);
				if(i < 0) {
					System.out.println(Thread.currentThread().getName() + " found negative value");
					return;
				}
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName() + " not find negative value");
	};
	
	static Runnable hasCommonElement = ()->{
		for(Integer i : list1) {
			int res = Collections.binarySearch(list2, i);
			if(res >= 0) {
				System.out.println(Thread.currentThread().getName() + " found common value");
				return;
			}
		}
		System.out.println(Thread.currentThread().getName() + " dont found common value");
		
	};

}
