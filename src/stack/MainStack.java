package stack;
//http://www.java-tips.org/java-se-tips/java.lang/array-based-stack-implementation-in-java.html
 class Stack {

	public int[] top;
	
	int index=-1;
	
	public Stack(){
		top = new int[5];
	}
	
	public void push(int data){
		if(index == 5){
			System.out.println("Stack full");
		}
		top[++index] = data;
	}
	
	public int pop(){
		if(index==-1){
			throw new UnderflowException( "ArrayStack top" );
		}
		return top[index--];
	}
	
	public int top(){
		if(isEmpty()){
			throw new UnderflowException( "ArrayStack pop" );
		}
		return top[index];
	}
	
	public boolean isEmpty() {
        return index == -1;
    }
	
	public Stack sort(){
		Stack sortStck = new Stack();
		while(!this.isEmpty()){
			int temp = this.pop();
			while(!sortStck.isEmpty() && sortStck.top() > temp){
				this.push(sortStck.pop());
			}
			sortStck.push(temp);
		}
		return sortStck;
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



 
 public class MainStack{
	 public static void main(String[] args){
		 int num;
		 Stack stk = new Stack();
		 stk.push(10);
		 stk.push(2);
		 stk.push(3);
		 stk.push(4);
		 stk.push(5);
//		 stk.pop();
//		 stk.pop();
//		 stk.pop();
//		 stk.pop();
		 //System.out.println(stk.top());
		 Stack newStck = stk.sort();
		while (!newStck.isEmpty()) {
			System.out.println(newStck.pop());
		}
	 }
 }
