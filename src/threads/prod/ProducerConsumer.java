package threads.prod;
///*-
// * This computer program is the confidential information and proprietary trade
// * secret of Cisco Systems, Inc. Possessions and use of this program must
// * conform strictly to the license agreement between the user and Cisco Systems,
// * Inc., and receipt or possession does not convey any rights to divulge,
// * reproduce, or allow others to use this program without specific written
// * authorization of Cisco Systems, Inc.
// * 
// * Copyright 2011-2013 Cisco Systems, Inc. All rights reserved.
// * 
// * Created on Sep 26, 2013
// */

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumer {
    Queue lst = new LinkedList();

    public static void main(String[] args) {
        ProducerConsumer rw = new ProducerConsumer();
        Thread[] producer = new Thread[10];
        Thread[] consumer = new Thread[10];
        
        for(int i=0;i<1;i++){
            consumer[i] = new Thread(new Consumer(rw));
            producer[i] = new Thread(new Producer(rw));
            consumer[i].start();
            producer[i].start();
        }

    }

    public void produce(int i) {
        synchronized (lst) {
            while (!lst.isEmpty()) {
                try {
                   // System.out.println("Waiting in Producer , queue count:  " + lst.size() );
                    lst.wait();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println("Added element: " +i +" ->"+ lst.add(i));
 
            lst.notify();
        }
    }

    public void consume() {
        synchronized (lst) {
            while (lst.isEmpty()) {
                try {
                   // System.out.println("Waiting in consumer , queue count : " + lst.size() );
                    lst.wait();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            
            System.out.println("Removed element: " +lst.remove() +" , Queue Count: " + lst.size());
            lst.notify();
        }

    }
}

class Producer implements Runnable {
    ProducerConsumer pc;
    public Producer(ProducerConsumer pc){
        this.pc = pc;
    }

    @Override
    public void run() {
        //while (true) {
            for (int i = 0; i < 20; i++) {
                pc.produce(i);
            }
        //}
}
}


class Consumer implements Runnable {
    ProducerConsumer pc;
    public Consumer(ProducerConsumer pc){
        this.pc = pc;
    }

    @Override
    public void run() {
        while(true){
            pc.consume();
        }
    }
}
