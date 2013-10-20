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
package threads;

public class BoundedSemaphore {

    private int bound;
    private int signal;
    
    public synchronized void release(){
        while(signal==0){
            try {
                wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        signal--;
        notify();
        
    }
    
    public synchronized void take(){
        while(signal==bound){
            try {
                wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        signal++;
        notify();
    }
}
