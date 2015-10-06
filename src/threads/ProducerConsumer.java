package threads;
/*
import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumer {
    Queue lst = new LinkedList();

    public static void main(String[] args) {
        ProducerConsumer rw = new ProducerConsumer();
        Thread[] producer = new Thread[10];
        Thread[] consumer = new Thread[10];
        consumer[0] = new Thread(new Consumer(rw), "Consumer ");
        consumer[0].start();
        for(int i=0;i<3;i++){
            System.out.println("Starting Thread " + i);
            producer[i] = new Thread(new Producer(rw), "Producer " + i);
            
            producer[i].start();
        }

    }

    public void produce(int i) {
        synchronized (this) {
            while (!lst.isEmpty()) {
                try {
                   // System.out.println("Waiting in Producer , queue count:  " + lst.size() );
                    wait();
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
             lst.add(i);
            System.out.println("Added element: " +i +" , Queue Count: " + lst.size() +" Current Thread =" +Thread.currentThread().getName());
 
            notifyAll();
        }
    }

    public void consume() {
        synchronized (this) {
            while (lst.isEmpty()) {
                try {
                   // System.out.println("Waiting in consumer , queue count : " + lst.size() );
                   wait();
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
            
            System.out.println("Removed element: " +lst.remove() +" , Queue Count: " + lst.size() +" Current Thread =" +Thread.currentThread().getName());
            notifyAll();
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
            for (int i = 0; i < 4; i++) {
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
*/