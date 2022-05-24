package threadPool.alice;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class Pool {
	private final int CORE_THREADS = 4;
	private final int MAX_POOL_SIZE = 8;
	private final long KEEP_ALIVE_TIME = 3;
	// private final int CAPACITY = 100;

	private ConcurrentMap<String, Integer> map = new ConcurrentHashMap<>();
	//private Map<String, Integer> map = new HashMap<>();

	File file = new File("Myfiles/alice.txt");

	private final BlockingQueue<Runnable> tasks = new LinkedBlockingQueue<>();
	private ThreadPoolExecutor pool;

	public Pool() {
		// RejectedExecutionHandler rejectedExecutionHandler = (r, ex) -> r.run();
		pool = new ThreadPoolExecutor(CORE_THREADS, MAX_POOL_SIZE, KEEP_ALIVE_TIME, TimeUnit.SECONDS, tasks);

	}

	public void runPool() {
		try {
			Scanner sc = new Scanner(file);
			while (sc.hasNextLine()) {

				String line = sc.nextLine();
				pool.execute(new Runnable() {
					@Override
					public void run() {
						ProcessLine(line);

					}
				});
			}
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (RejectedExecutionException e) {

			e.printStackTrace();

		}
		pool.shutdown();

	}

	public void ProcessLine(String line) {
		Integer count;

		String[] words = line.replaceAll("[^\\w\\s]", "").split(" ");

		for (String word : words) {
			if (word.equals(""))
				continue;
			synchronized(map) {

			count = map.get(word);
			if (count == null) {
				count = 0;
			}
			count++;
			map.put(word, count);
			}
		}

	}

	public void print() {

		Map<String, Integer> sortedMap = map.entrySet().stream().sorted(Map.Entry.comparingByValue())
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> {
					throw new AssertionError();
				}, () -> new LinkedHashMap<>()));

		sortedMap.entrySet().forEach((m) -> System.out.println(m.getKey() + " = " + m.getValue()));
	}

}
