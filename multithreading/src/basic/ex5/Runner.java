package basic.ex5;

import java.lang.Thread.UncaughtExceptionHandler;
import java.util.ArrayList;
import java.util.List;

public class Runner {
	
	final static int SIZE = 10;
	static List<Integer> list = new ArrayList<>(SIZE);
	static List<Integer> doubleByTwoList = new ArrayList<>();
	static List<String> stringList = new ArrayList<>();
	static List<Double> doubleValueList = new ArrayList<>(); 
			
	
	
	

	public static void main(String[] args) throws InterruptedException {
		initList();
		list.set(5, null);
		list.set(8, null);
		list.set(9, null);
		System.out.println(list);
		
		Thread t1 = new Thread(doubleElement,"Thread1");
		Thread t2 = new Thread(stringElement, "Thread2");
		Thread t3 = new Thread(divideElement,"Thread3");
		
		t2.setUncaughtExceptionHandler(new UncaughtExceptionHandler() {
			@Override
			public void uncaughtException(Thread t, Throwable e) {
				System.out.println("Found Null in " + Thread.currentThread().getName());
				System.out.println("stringList size is " +stringList.size());
			}
		});
		
		Thread.setDefaultUncaughtExceptionHandler(new UncaughtExceptionHandler() {
			
			@Override
			public void uncaughtException(Thread t, Throwable e) {
				System.out.println("Found Null in " + Thread.currentThread().getName());
				System.out.println("doubleValueList size is " +doubleValueList.size());
				
			}
		});
		
		t1.start();
		t2.start();
		t3.start();
		
		t1.join();
		t2.join();
		t3.join();
		System.out.println(doubleByTwoList);
		System.out.println(stringList);
		System.out.println(doubleValueList);
		
		

	}
	
	public static void initList() {
		for(int i = 0; i < SIZE; i++) {
			list.add((int) (Math.random() * 999));
		}
	}
	
	public static Runnable doubleElement = () ->{
		for(Integer i : list) {
			try {
			doubleByTwoList.add(i * 2);
			}catch (NullPointerException e) {
				System.out.println("Found Null in " + Thread.currentThread().getName());
			}
		}
		System.out.println("doubleList size is " + doubleByTwoList.size());
		
	};
	
	public static Runnable stringElement = () -> {
		for(Integer i : list) {
			stringList.add("" + (i +1));
		}
		System.out.println("stringList size is " + stringList.size());
		
	};
	
	public static Runnable divideElement = () ->{
		for(Integer i : list) {
			doubleValueList.add((double) i / 5);
			
		}
		System.out.println("double valueList size " + doubleValueList.size());
		
	};

}
