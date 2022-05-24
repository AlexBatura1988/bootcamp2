package threadPool.alice;

public class Runner {

	public static void main(String[] args) throws InterruptedException {
		Pool pool = new Pool();
		pool.runPool();
		pool.print();

	}

}
