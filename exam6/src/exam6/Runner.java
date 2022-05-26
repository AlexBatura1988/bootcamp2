package exam6;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.function.ToDoubleFunction;

public class Runner {

	private final static List<Command> commands = new ArrayList<>();
	private static ThreadPoolExecutor threadPoolExecutor;
	private static Future<Double> totalSum;

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		createExecutor();

		totalSum = threadPoolExecutor.submit(new SumTask());
		printInfo(totalSum.get());

		createCommands();

		totalSum = threadPoolExecutor.submit(new SumTask());
		threadPoolExecutor.shutdown();
		printInfo(totalSum.get());

	}

	private static void printInfo(double total) {
		System.out.println("Total founds: " + total);
		System.out.println(StocksDB.getStockByName("doodle"));
		System.out.println(StocksDB.getStockByName("BARVAZON"));
		System.out.println(StocksDB.getStockByName("headbook"));
	}

	private static void createExecutor() {
		threadPoolExecutor = new ThreadPoolExecutor(2, 4, 1, TimeUnit.MINUTES, new ArrayBlockingQueue<>(1),
				new ThreadPoolExecutor.CallerRunsPolicy());
	}

	private static void createCommands() {
		threadPoolExecutor.execute(buyStock("doodle"));
		threadPoolExecutor.execute(sellStock("doodle"));
		threadPoolExecutor.execute(buyStock("BARVAZON"));
		threadPoolExecutor.execute(buyStock("headbook"));
		threadPoolExecutor.execute(sellStock("BARVAZON"));
		threadPoolExecutor.execute(buyStock("doodle"));
		threadPoolExecutor.execute(sellStock("headbook"));
		threadPoolExecutor.execute(buyStock("BARVAZON"));
		threadPoolExecutor.execute(sellStock("doodle"));
		threadPoolExecutor.execute(sellStock("BARVAZON"));
		// wrong name
		threadPoolExecutor.execute(sellStock("AMAZON"));

		
	}

	static Runnable buyStock(String stockName) {
		return new Runnable() {
			@Override
			public void run() {
				synchronized (commands) {
					try {
						Stock stock = StocksDB.getStockByName(stockName);
						stock.buy();
						commands.add(new Command(stock.getName(), Command.Operation.BUY));
					} catch (IllegalArgumentException e) {
						System.out.println(e.getMessage());
					}
				}
			}
		};
	}

	static Runnable sellStock(String stockName) {
		return new Runnable() {
			@Override
			public void run() {
				synchronized (commands) {
					try {
						Stock stock = StocksDB.getStockByName(stockName);
						stock.sell();
						commands.add(new Command(stock.getName(), Command.Operation.SELL));
					} catch (IllegalArgumentException e) {
						System.out.println(e.getMessage());
					}
				}
			}
		};
	}

	static class SumTask implements Callable<Double> {
		@Override
		public Double call() {
			synchronized (commands) {
				return commands.stream().mapToDouble(new ToDoubleFunction<Command>() {
					@Override
					public double applyAsDouble(Command operation) {
						if (operation.operation == Command.Operation.BUY) {
							return StocksDB.getStockByName(operation.stockName).getBuyPrice();
						} else
							return StocksDB.getStockByName(operation.stockName).getSellPrice();
					}
				}).sum();
			}
		}
	}

}
