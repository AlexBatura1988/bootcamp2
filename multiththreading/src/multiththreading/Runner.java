package multiththreading;

public class Runner {
	private final static int NUM_LOOP = 3;
	public static int num = 10;

	public static void main(String[] args) throws InterruptedException {
		
		MyThred t1 = new MyThred();
		MyThred t2 = new MyThred();
		MyThread1 thread = new MyThread1();
		Thread t3 = new Thread(thread);
		
		t3.setPriority(Thread.MAX_PRIORITY);
		t1.setPriority(Thread.MIN_PRIORITY);
		

		doubleNum(t3);
		t3.start();
		addTwo(t2);
		t2.start();
		divideTwo(t1);
		t1.start();

		t1.join();
		t2.join();
		t3.join();
		
		System.out.println("num is "+num);

	}

	static class MyThred extends Thread {
		public void run() {
			System.out.println(Thread.currentThread().getName() );
		}
	}

	static class MyThread1 implements Runnable {

		@Override
		public void run() {

			System.out.println(Thread.currentThread().getName());
			
		}

	}

	public static void doubleNum(Thread t) {
		Thread thread = Thread.currentThread();
		for (int i = 0; i < NUM_LOOP; i++) {
			num *= 2;
			System.out.println(thread.getName() + ": " + num);
		}
	}

	public static void addTwo(Thread t) {
		Thread thread = Thread.currentThread();
		for (int i = 0; i < NUM_LOOP; i++) {
			num += 2;
			System.out.println(thread.getName() + ": " + num);
		}
	}

	public static void divideTwo(Thread t) {
		Thread thread = Thread.currentThread();

		for (int i = 0; i < NUM_LOOP; i++) {
			num /= 2;
			System.out.println(thread.getName() + ": " + num);
		}

	}

}
