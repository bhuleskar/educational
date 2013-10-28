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

    
    public static void main(String[] args){
        Semaphore semaphore = new Semaphore();

        SendingThread sender = new SendingThread(semaphore);

        ReceivingThread receiver = new ReceivingThread(semaphore);

        receiver.start();
        sender.start();
    }
    
    public synchronized void take() {
      this.signals++;
      this.notify();
    }

    public synchronized void release() throws InterruptedException{
      while(this.signals == 0) wait();
      this.signals--;
    }

    
  }