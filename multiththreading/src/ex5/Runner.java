package ex5;

import java.util.ArrayList;
import java.util.List;

public class Runner {
	public final static int SIZE = 1000;
	public static List<Integer> list1 = new ArrayList<>();
	public static List<Integer> doubleList = new ArrayList<>();
	
	public	static List<String> stringValueList = new ArrayList<>();
	public static List<Double> doubleValueList = new ArrayList<>();

	public static void main(String[] args) {
		
		for (int i = 0; i < SIZE; i++) {
			list1.add((int) (Math.random()*999));
		}
		list1.set(10,null);
		
		Thread.setDefaultUncaughtExceptionHandler((Thread t, Throwable exception) -> {
			System.out.println("Found 10 in " + Thread.currentThread().getName());
			System.out.println("doubleValueList size is " + doubleValueList.size());
		});
		
		Thread thread1 = new Thread(doubleT, "Thread 1");
		thread1.start();
		
		

	}
	
	
	public static Runnable doubleT = () -> {
		for (int i : list1) {
			try {
				doubleList.add(i * 2);
			} catch (NullPointerException e) {
				System.out.println(" exseption " + Thread.currentThread().getName());
			}
		}
		System.out.println("size is: " + doubleList.size());
	};

}
