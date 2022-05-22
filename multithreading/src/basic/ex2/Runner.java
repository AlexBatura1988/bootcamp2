package basic.ex2;

public class Runner {
	public static int num = 10;

	public static void main(String[] args) throws InterruptedException {
		System.out.println("num is " + num);
		
		Thread t1 = new Thread(() -> doubleNum());
		Thread t2 = new Thread(() -> addTwoToNum());
		Thread t3 = new Thread(() -> divideByTwo());
		t1.setPriority(Thread.MIN_PRIORITY);
		t3.setPriority(Thread.MAX_PRIORITY);
		
		t3.start();
		t2.start();
		t1.start();
		t1.join();
		t2.join();
		t3.join();
		System.out.println("num is " + num);
		
		

	}
	
	public static void doubleNum() {
		Thread thread = Thread.currentThread();
		for(int i = 0; i < 3; i++) {
			num *= 2;
			System.out.println(thread.getName() + " " + num);
		}
	}
	public static void addTwoToNum() {
		Thread thread = Thread.currentThread();
		for(int i = 0; i < 3; i++) {
			num += 2;
			System.out.println(thread.getName() + " " + num);
		}
	}
	public static void divideByTwo() {
		Thread thread = Thread.currentThread();
		for(int i =0; i < 2; i++) {
			num /=2;
			System.out.println(thread.getName() + " "+ num);
		}
	}

}
