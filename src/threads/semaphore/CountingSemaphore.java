/*-
 * This computer program is the confidential information and proprietary trade
 * secret of Cisco Systems, Inc. Possessions and use of this program must
 * conform strictly to the license agreement between the user and Cisco Systems,
 * Inc., and receipt or possession does not convey any rights to divulge,
 * reproduce, or allow others to use this program without specific written
 * authorization of Cisco Systems, Inc.
 * 
 * Copyright 2011-2013 Cisco Systems, Inc. All rights reserved.
 * 
 * Created on Sep 28, 2013
 */
package threads.semaphore;


public class CountingSemaphore {
    private int signals = 0;
    private int MAX_COUNT =5;
    
    public static void main(String[] args){
    	CountingSemaphore semaphore = new CountingSemaphore();

    	//ConsumerThread consumer = new ConsumerThread(semaphore);
    	ProducerThread producer = new ProducerThread(semaphore);
        
    	for(int i=0;i<6;i++){
    		ConsumerThread consumer = new ConsumerThread(semaphore,i);
    		consumer.start();
    	}
    	
        producer.start();
    }
    
	public synchronized void acquire() throws InterruptedException {
		while (signals == MAX_COUNT) {
			System.out.println("Reached bound");
			wait();
		}
		this.signals++;
		System.out.println("Acquiring semaphore..Signal count =" + signals);
		this.notify();
	}

    public synchronized void release() throws InterruptedException{
      while(this.signals == 0) {
    	  System.out.println("waiting to release");
    	  wait();
      }
      this.signals--;
	  System.out.println("Releasing.. Signal count=" +signals);
      notify();
    }

    
  }

class ProducerThread  extends Thread{
	CountingSemaphore semaphore = null;

    public ProducerThread(CountingSemaphore semaphore){
      this.semaphore = semaphore;
    }

    public void run(){
      while(true){
        //do something, then signal
    	  
        try {       	
			this.semaphore.acquire();
			Thread.sleep(1000);
			System.out.println("Producing..");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

     }
    }
  }

 class ConsumerThread extends Thread{
	 CountingSemaphore semaphore = null;
	 int i;
    public ConsumerThread(CountingSemaphore semaphore, int i){
      this.semaphore = semaphore;
      this.i= i;
    }

    public void run(){
    	System.out.println("Thread = "+ i);
      while(true){
        try {
			System.out.println("Consuming..");
            Thread.sleep(4000);
            this.semaphore.release();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //receive signal, then do something...
      }
    }
  }