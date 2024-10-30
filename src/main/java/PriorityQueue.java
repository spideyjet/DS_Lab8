import java.util.Comparator;

public class PriorityQueue<T> extends Queue<T>
{

   Comparator<T> compare;

   public PriorityQueue(Comparator<T> comp)
   {
      compare = comp;
   }


    //@Override
   public void push(T val)
   {
	   Node<T> newNode = new Node<>(val);
	   
	   if (isEmpty())
	   {
			   first = newNode;
			   last = newNode;
			   return;
	   }
	   
	   if (compare.compare(val, first.name) > 0)
	   {
		   newNode.next = first;
		   first = newNode;
		   return;
	   }
	   
	   Node<T> curr = first;
	   Node<T> prev = null;
	   
	   while (curr != null && compare.compare(val, curr.name)<= 0)
		{
		   prev = curr;
		   curr = curr.next;
		}
	   if (prev != null)
	   {
		   prev.next = newNode;
		   newNode.next = curr;
	   }
	   if(newNode.next == null)
	   {
		   last = newNode;
	   }
   }


}
