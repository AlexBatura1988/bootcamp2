package threadPool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Runner {
	// thread pools executor
	private static final int CORE_THREADS = 2;
	private static final int MAX_POOL_SIZE = 4;
	private static final long KEEP_ALIVE_TIME = 3;
	private static final int CAPACITY = 6;

	private static final BlockingQueue<Runnable> tasks = new ArrayBlockingQueue<>(CAPACITY);

	public static void main(String[] args) {

		ThreadPoolExecutor pool = new ThreadPoolExecutor(CORE_THREADS, MAX_POOL_SIZE, KEEP_ALIVE_TIME, TimeUnit.SECONDS,
				tasks,
				(Runnable r, ThreadPoolExecutor ex)->{
					r.run();
				});

		for (int i = 0; i < 11; i++) {
			try {
				pool.execute(new Runnable() {
					@Override
					public void run() {

						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						System.out.println("Java Thread");

					}
				});
			} catch (RejectedExecutionException e) {
				System.out.println("Rejected exeption");
			}
			System.out.println(pool.getPoolSize());
		}

//		pool.execute(() -> System.out.println("Java Thread"));
//		System.out.println(pool.getPoolSize());
//		
//		pool.execute(() -> System.out.println("Java Thread"));
//		System.out.println(pool.getPoolSize());
//		
//		pool.execute(() -> System.out.println("Java Thread"));
//		System.out.println(pool.getPoolSize());

		// gracefully shutdown
		pool.shutdown();

	}

}
