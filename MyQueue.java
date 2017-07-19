package project3;

/**
 * This class is my implementation of java's queue class. It will be used in the breadth first algorithm for image segmentation
 * 
 * @author Anisa Matthews
 */
public class MyQueue<E> {

	private MyNode<E> front; //a reference
	private MyNode<E> back;
	
	/**MyQueue
	 * Constructor method that sets the front reference to null
	 **/
	public MyQueue (){
		front = null;
	}
	
	/** peek
	 * Retrieves, but does not remove, the head of this queue, or returns null if this queue is empty
	 * @return the data within the head of the queue
	 */
	public E peek(){
		if (this.isEmpty())
			return null;
		else
			return front.getData();
	}
	
	/** poll
	 * Retrieves and removes the head of this queue, or returns null if this queue is empty.
	 * @return the data of the head before it was removed
	 */
	public E poll(){
		MyNode<E> temp = front;
		if (isEmpty())
			return null;
		else{
			front = front.getNext();
			return temp.getData();	
		}
	}
	
	/** offer
	 * Inserts the specified element into this queue (if it doesn't conflict with capacity restrictions)
	 * @param item
	 * @return true because there are no capacity restrictions
	 * @throws ClassCastException if an element of a different class is added
	 * @throws IllegalArgumentException
	 * @throws NullPointerException if the data entered is null
	 */
	public boolean offer(E item) throws ClassCastException, IllegalArgumentException, NullPointerException {
		if (item == null)
			throw new NullPointerException();
		
		MyNode<E> node = new MyNode<E>(item);
		if (back == null){
			front = node;
			back = node;
		}
		else
			back.setNext(node);
		back = node;
		return true;
	}
	
	/** isEmpty
	 * Tests if this queue is empty
	 * @return whether the queue is empty or not
	 */
	private boolean isEmpty(){
		return this.front == null;
	}
}
