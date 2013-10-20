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

public class TwoThreadSynchronization {


        public synchronized void m1() {
            try {
                System.out.println("in m1()");
                Thread.sleep(2000); 
                }
            catch (InterruptedException ie) {}
        }

        public synchronized void m2() {
            try {
                System.out.println("in m2()");
                Thread.sleep(2000); 
                }
            catch (InterruptedException ie) {}
        }
        
        public synchronized void m3() {
            try {
                System.out.println("in m3()");
                Thread.sleep(2000);
                }
            catch (InterruptedException ie) {}
        }

        public static void main(String[] args) throws InterruptedException {
            final TwoThreadSynchronization t = new TwoThreadSynchronization();
            Thread t1 = new Thread() { public void run() { t.m1(); } };
            Thread t2 = new Thread() { public void run() { t.m2(); } };
            Thread t3 = new Thread() { public void run() { t.m3(); } };
            t1.start();
            Thread.sleep(500);
            
            t3.start();
            Thread.sleep(500);
            
            t2.start();
            Thread.sleep(500);

            System.out.println(t2.getState());
            System.out.println(t3.getState());
        }
}
