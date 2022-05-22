package synchronizarion.ex1;

public class SumListSection implements Runnable {
	public static Object object = new Object();
	private int start;
	private int end;
	private Runner runner;
	
	
	public SumListSection(int start, int end, Runner runner) {
		this.start = start;
		this.end = end;
		this.runner = runner;
	}




	@Override
	public void run() {
		for (int i = start; i < end; i++) {
			//synchronized block
			synchronized (runner) {
				runner.addToSum(i);
			}
		}
		
		//synchronized method
		
//		for (int i = start; i < end; i++) {
//			runner.addToSumSync(i);
//		}
		
	}

}
