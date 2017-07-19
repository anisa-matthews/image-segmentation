package project3;

/**
 * This class is my implementation of a node class within any linked list. It will be used in MyStack and MyQueue
 * @author anisa.matthews
 *
 * @param <E> this is a generic class
 */
public class MyNode<E> {

	//data and next
	private MyNode <E> next;
	private E data;
	
	/** MyNode
	 * Constructor method that creates node with given data. next is set to null
	 * @param data
	 */
	public MyNode (E data){
		this.data = data;
		//next = null by default
	}
	
	/** MyNode
	 * Constructor method that creates node with given data and next
	 * @param data
	 * @param next
	 */
	public MyNode (E data, MyNode <E> next){
		this.next = next;
		this.data = data;
	}

	/** getNext
	 * retrieves and returns the next of a given node
	 * @return next
	 */
	public MyNode<E> getNext() {
		return next;
	}

	/** setNext
	 * sets next of a given node
	 * @param next
	 */
	public void setNext(MyNode<E> next) {
		this.next = next;
	}

	/** getData
	 * retrieves and returns the data of a given node
	 * @return data
	 */
	public E getData() {
		return data;
	}
}
