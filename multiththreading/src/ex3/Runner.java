package ex3;

public class Runner {
	public static int num = 1;

	public static void main(String[] args) throws InterruptedException {

		ThreadGroup group = new ThreadGroup("Group");

		Thread thread1 = new Thread(group, new MyThread(), "Thread1");
		Thread thread2 = new Thread(group, new MyThread(), "Thread2");
		Thread thread3 = new Thread(group, new MyThread(), "Thread3");

		thread1.start();
		thread2.start();
		thread3.start();

		Thread.sleep(1500);

		group.interrupt();

		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
		System.out.println(Integer.MIN_VALUE * 2);

	}

	static class MyThread extends Thread {
		@Override
		public void run() {
			while (true) {

				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					return;

				}
				num *= 2;
				System.out.println(num + " " + Thread.currentThread().getName());

			}
		}
	}
}
