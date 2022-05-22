package synchronizarion.ex2;

import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Service implements Runnable {
	
	private List<String> reports;
	private final int MAX = 5;
	public static Lock lock = new ReentrantLock();
	public static Condition condition = lock.newCondition();
	
	public Service(List<String> reports) {
		
		this.reports = reports;
		
	}
	
	public void produce() throws InterruptedException {
		lock.lock();
			if(reports.size() == MAX) {
				System.out.println("produce wait...");
				condition.await();
			}
			Thread.sleep(2000);
		
		System.out.println("report" + reports.size() + "  produced");
		reports.add("report " + reports.size());
		
		
		if (reports.size() == 1) {
			condition.signal();
		}
		lock.unlock();
		
	}

	@Override
	public void run() {
		while(true) {
			try {
				produce();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	

}
