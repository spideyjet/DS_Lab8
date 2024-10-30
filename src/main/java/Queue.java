public class Queue<T>
{
    //be sure that your attributes are protected, so subclasses can use them
	protected class Node<T> {
		T name;
		Node<T> next;
		
		Node(T name) {
			this.name = name;
			this.next = null;
		}
	}
	protected Node<T> first;
	protected Node<T> last;

   public Queue()
   {
   first = null;
   last = null;
   }


    /**Adds val to the end of the queue
     */
   public void push(T val)
   {
	   Node<T> newNode = new Node<>(val);
	   
	   
	   if (first == null)
	   {
		   first = newNode;
		   last = newNode;
	   }
	   else
	   {
		
		   last.next = newNode;
		   last = newNode;
	
	   }
	   
		
   }


    /**
       removes and returns the oldest value in the queue
       throws QueueUnderFlowException if the queue is empty
     */
   public T pop()
   {

		if (isEmpty()) {
			throw new QueueUnderFlowException("queue is empty. Can't pop");
		}
		T popName = first.name;
		first = first.next;	
		return popName;
   }    


    /**
      returns true if the queue is empty
     */

   public boolean isEmpty()
   {
       return first == null;
   }




}
