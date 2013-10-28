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

import java.util.LinkedList;
import java.util.List;

public class BlockingQueue {

    private List<Object> queue = new LinkedList<Object>();
    private int limit = 10;

    public BlockingQueue(int limit) {
        this.limit = limit;
    }

    public synchronized void enqueue(Object item)
            throws InterruptedException {
        while (this.queue.size() == this.limit) {
            wait();
        }

        //You are mentioning that things are added to the queue and get ready to consume it (all waiting consuming threads)

        if (this.queue.size() == 0) {
            notifyAll();
        }
        this.queue.add(item);
    }

    public synchronized Object dequeue()
            throws InterruptedException {
        while (this.queue.size() == 0) {
            wait();
        }
        //You are mentioning that things are being removed from the queue and get ready to produce it (all waiting producing threads)
        if (this.queue.size() == this.limit) {
            notifyAll();
        }

        return this.queue.remove(0);
    }

}
