package project3;

import java.util.*;

/**
 * This class is my implementation of java's queue class. It will be used in the depth first algorithm for image segmentation
 * @author anisa.matthews
 *
 * @param <E> this stack is a generic class
 */
public class MyStack<E> {
	
	private MyNode<E> head; //a reference -> index if you will
	
	/**MyStack
	 * Constructor method that sets the head reference to null
	 * @throws ClassCastException
	 */
	public MyStack() throws ClassCastException {
		head = null;
	}
	
	/** peek
	 * Returns the element at the top of this stack without removing it from the stack.
	 * @return data of the head bode
	 * @throws EmptyStackException when user attempts to peek an empty stack
	 */
	public E peek() throws EmptyStackException{
		if (this.isEmpty())
			throw new EmptyStackException();
		else
			return head.getData();
	}
	
	/** pop
	 * Removes the element at the top of this stack and returns that element as the value of this function.
	 * @return
	 * @throws EmptyStackException
	 */
	public E pop() throws EmptyStackException{
		MyNode<E> temp = head;
		if (!isEmpty()){
			head = head.getNext();
		}
		else
			throw new EmptyStackException();
		return temp.getData();
	}
	
	/** push
	 * Pushes an item onto the top of this stack. Returns the item itself
	 * @param item
	 * @return
	 */
	public E push(E item){
		//create a node, point next to current head, make head the new node.
		
		MyNode<E> first = new MyNode<E>(item);
		first.setNext(head);
		head = first;
		return head.getData();
		
	}
	
	/** isEmpty
	 *  Tests if this stack is empty.
	 * @return true or false depending on whether the stack is empty or not
	 */
	public boolean isEmpty() {
	      return (head == null);
	}
	
	/** length
	 * 
	 * @return the number of nodes in the stack
	 */
	private int length() { 
		int length = 0; 
		MyNode<E> current = head; 
		// Starts counting from head - first node 
		while(current != null){ 
			length ++; current = current.getNext(); 
		} 
		return length;
	}
	
	/** contains
	 * wrapper method. determines if any nodes within the stack contain the given data
	 * @param data
	 * @return true or false depending on whether the data was found
	 */
	private boolean contains(E data){
		MyNode <E> current = head;
		return containsHelper(data, current);
				
		}
	
	/** containsHelper
	 * recursive method. determines if any nodes within the stack contain the given data
	 * @param data
	 * @param current node being looked at
	 * @return true or false depending on whether the data was found
	 */
	private boolean containsHelper(E data, MyNode <E> current){
		if (current.getData() == null)
			return false;
		if (current.getData().equals(data))
			return true;
		else
			current = current.getNext();
			return contains(data);
	}
}
