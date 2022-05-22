package ex7;

import java.util.ArrayList;
import java.util.List;

public class Runner {

	private static final int ARR_SIZE = 50;
	static List<Integer> numbers = new ArrayList<Integer>();
	static int sum = 0;

	public static void main(String[] args) throws InterruptedException {
		for (int i = 1; i < ARR_SIZE; i++) {
			numbers.add(i);
		}
		System.out.println(numbers);
		
		for (int i = 0; i <= numbers.size()-1; i++) {
			sum += numbers.get(i);
		}
		System.out.println("sum is " +sum);
		sum = 0;
		

		Thread thread1 = new Thread(new SumRunnable(numbers, 0, numbers.size() / 2), "First half thread");
		Thread thread2 = new Thread(new SumRunnable(numbers, numbers.size()/2, numbers.size() -1 ), "First half thread");
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        
        System.out.println("Thread sum : " + sum);
	}

	static class SumRunnable implements Runnable {

		int start;
		int end;
		List<Integer> list;

		public SumRunnable(List<Integer> list, int start, int end) {
			this.start = start;
			this.end = end;
			this.list = list;
		}

		@Override
		public void run() {
			for (int i = start; i <= end; i++) {
				sum += list.get(i);
			}
		}
	}

}
