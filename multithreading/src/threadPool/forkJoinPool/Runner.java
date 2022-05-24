package threadPool.forkJoinPool;

public class Runner {

	public static void main(String[] args) throws InterruptedException {
		 int[] arr = new int[] {1, 2, 3, 4, 5, 6, 7, 8};
		 ForkJoinRecursiveSum forkJoinRecursiveSum = new ForkJoinRecursiveSum(arr, 0, arr.length);
		 
		 int sum  = forkJoinRecursiveSum.sum(arr);
			System.out.println("Sum: " + sum);

	}
}
