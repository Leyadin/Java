//Jason Rutledge
//Assignment 5
//Purpose: Implement synchronization to make a program thread safe

package assignment5;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SynchronizeThreads {
	//Create an object to allow synchronization
	static TestObj sync = new TestObj();	
	
	public static class AddOne implements Runnable {
		@Override
		public void run() {
			synchronized(sync) {
				sync.plusOne();
			}
		}
	}
	
	public static void main(String[] args) {
		ExecutorService threads = Executors.newFixedThreadPool(1000);
		
		//Generate 1000 threads
		for (int i = 0; i < 1000; i++)
			threads.execute(new AddOne());
		
		threads.shutdown();
		
		while(!threads.isTerminated()) {
		}
		
		System.out.println("The sum is: "  + sync.sum);			

	}
}
