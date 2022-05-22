package basic.ex1;

import java.util.Iterator;

public class Runner {
	public static int num = 10;

	public static void main(String[] args) throws InterruptedException {
		System.out.println("num is " + num);
		
		
//		DoubleNum doubleNum = new DoubleNum();
//		doubleNum.run();
		
		Thread t1 = new Thread(() -> doubleNum());
		Thread t2 = new Thread(() -> addTwoToNum());
		Thread t3 = new Thread(() -> divideByTwo());
		
		t1.start();
		t2.start();
		t3.start();
		t1.join();
		t2.join();
		t3.join();	
		
		System.out.println("num is  " + num);
		

	}
//	 static class DoubleNum implements Runnable{
//		 Thread thread = Thread.currentThread();
//
//		@Override
//		public void run() {
//			for(int i = 0; i < 3; i++) {
//				num *= 2;
//				System.out.println(thread.getName() + " " + num);
//			}
//			
//		}
//		 
//	 }
	
	public static void doubleNum() {
		Thread thread = Thread.currentThread();
		for(int i = 0; i < 3; i++) {
			num *= 2;
			System.out.println(thread.getName() + " " + num);
		}
	}
	public static void addTwoToNum() {
		Thread thread = Thread.currentThread();
		for(int i = 0; i < 3; i++) {
			num += 2;
			System.out.println(thread.getName() + " " + num);
		}
	}
	public static void divideByTwo() {
		Thread thread = Thread.currentThread();
		for(int i =0; i < 2; i++) {
			num /=2;
			System.out.println(thread.getName() + " "+ num);
		}
	}
		

}
