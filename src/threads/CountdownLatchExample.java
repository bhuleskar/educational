package threads;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * CountDownLatch example class. 
 * @author sbalijep
 *
 */
public class CountdownLatchExample {

	public static void main(String[] args) {
		CountDownLatch latch = new CountDownLatch(3);

		ExecutorService executor = Executors.newFixedThreadPool(3);
		
		/*
		 * Countdownlatch is like a horsegate (releases everyone at once) .If
		 * you want to wait for all threads to finish, the number of tasks
		 * submitted (threads started by the executor) and the latch will need
		 * to be same. That way the latch object can await on all the threads.
		 * It is analogous to executor.awaitTermination(..) of the executor
		 * class.
		 */
		for (int i = 0; i < 10; i++) {
			executor.submit(new Processor(latch));
		}
		
		try {
			latch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Completed");
	}
}

class Processor implements Runnable {
	
	CountDownLatch latch ;
	
	Processor(CountDownLatch latch){
		this.latch = latch;
	}
	
	@Override
	public void run() {
	System.out.println("Started Thread" + Thread.currentThread().getId());
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		latch.countDown();
	}
	
	
}
