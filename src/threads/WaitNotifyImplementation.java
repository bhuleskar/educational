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
 * Created on Sep 22, 2013
 */
package threads;

public class WaitNotifyImplementation {

    private boolean pizzaArrived = false;
    
    public static void main(String[] args) {
        final WaitNotifyImplementation wn = new WaitNotifyImplementation();


        
        for (int i = 0; i < 5; i++) {
            new Thread("I am " + i){
                public void run(){
                    wn.eatPizza();
                }
              }.start();
        }
        
        Thread t1 = new Thread("Pizza Thread") {
            public void run() {
                wn.pizzaGuy();
            }
        };
        t1.start();

    }
    
    public void pizzaGuy(){
        synchronized(this){
                System.out.println("Piza guy arrived");
                pizzaArrived = true;
                this.notifyAll();
        }            
    }
    
    public void eatPizza(){
        synchronized(this){
            while(!pizzaArrived){
                try {
                    System.out.println("waiting.." + Thread.currentThread().getName());
                    this.wait();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                pizzaArrived = false;
            }
        }

        System.out.println("yumyum.." + Thread.currentThread().getName());
        
    }
}