package synchronizarion.ex2;

import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;



public class Marketing implements Runnable {
	
//	 private  Lock lock = new ReentrantLock();
//	 private  Condition condition = lock.newCondition();
	
	private List<String> reports;
	
	
	public Marketing(List<String> reports) {
		this.reports = reports;
		
	}
	
	public void consume() throws InterruptedException {
		Service.lock.lock();
		
			if(reports.isEmpty()) {
				System.out.println("waiting for report");
				Service.condition.await();
			}
			Thread.sleep(1000);
			
			System.out.println("report" + reports.size() + "  consumed");
			reports.remove(reports.size() - 1 );
			
			
			if (reports.size() == reports.size() - 1) {
				Service.condition.signal();
			}
			Service.lock.unlock();
				
			
		
	}

	@Override
	public void run() {
		while(true) {
			try {
				consume();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	

}
