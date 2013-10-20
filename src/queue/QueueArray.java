package queue;
//http://www.java-tips.org/java-se-tips/java.lang/array-based-stack-implementation-in-java.html
 class Queue {

	public int[] top;
	
	int index=-1;
	int front=0;
	int back=0;
	
	public Queue(){
		top = new int[5];
	}
	
	public void enque(int data){
		if(index == top.length){
			System.out.println("Queue Full. Remove items from Queue before adding");
		}
		index++;
		top[back++] = data;
	}
	
	public int deque(){
	    
		if(index==-1){
			throw new UnderflowException( "No elements in queue" );
		}
		index--;
		int a =top[front];
		top[front++] = -1;
		return a;
	}
	
	
	public boolean isEmpty() {
        return index == -1;
    }
}
 
class UnderflowException extends RuntimeException {
	    /**
	     * Construct this exception object.
	     * @param message the error message.
	     */
	    public UnderflowException( String message ) {
	        super( message );
	    }
	}



 
 public class QueueArray{
	 public static void main(String[] args){
		 int num;
		 Queue queue = new Queue();
		 queue.enque(10);
		 queue.enque(2);
		 queue.enque(3);
		 queue.enque(4);
		 System.out.println("Dequeued :" + queue.deque());
		 System.out.println("Dequeued :" + queue.deque());
		 System.out.println("Dequeued :" + queue.deque());
		 queue.enque(5);
		 for(int i=0;i<queue.top.length; i++){
		     System.out.println("Element " + i +"  of queue is:" + queue.top[i]);
		 }
		 //System.out.println(stk.top());

	 }
 }
