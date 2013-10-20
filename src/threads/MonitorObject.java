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

public class MonitorObject{
}

 class MyWaitNotify3{

    MonitorObject myMonitorObject = new MonitorObject();
    boolean wasSignalled = false;

    public void doWait(){
      synchronized(myMonitorObject){
        while(!wasSignalled){
          try{
            myMonitorObject.wait();
           } catch(InterruptedException e){
               
           }
        }
        //clear signal and continue running.
        wasSignalled = false;
      }
    }

    public void doNotify(){
      synchronized(myMonitorObject){
        wasSignalled = true;
        myMonitorObject.notify();
      }
    }
  }