package Deamond;

public class Runner {

	public static void main(String[] args) {
		Thread thread1 = new Thread(new SleeperRunneble(10), "Sleeping Beauty Thread");
		Thread thread2 = new Thread(new SleeperRunneble(5), "Prince Charming Thread");
		thread1.setDaemon(true);
		thread1.start();
		thread2.start();
	}

	static class SleeperRunneble implements Runnable {
		private final int numSeconds;

		public SleeperRunneble(int numSeconds) {

			this.numSeconds = numSeconds;
		}

		@Override
		public void run() {
			for (int i = 0; i < numSeconds; i++) {
				try {
					System.out.println(Thread.currentThread().getName() + " sleep for " + (i + 1) + " seconds");
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
			}

		}

	}

}
