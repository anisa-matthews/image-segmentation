package project3;

import static org.junit.Assert.*;

import java.util.EmptyStackException;
import org.junit.Test;

public class MyStackTest {

	@Test
	
	//Test creation of stack. Makes sure it doesn't point to null, and that it's not an object of the wrong class
	public void testConstructor() {
		try {
			MyStack<Integer> testStack = new MyStack<Integer>();
			assertNotNull("Reference null after constructor returns", testStack);
		}
		catch (ClassCastException e){
			//do nothing, test passed :)
		}
		catch (Exception e) {
			fail("testPeekFilled failed: Exception thrown\n" + e.getClass() + "\n" + e.getMessage());
		}
	}
	
	@Test
	//Makes sure isEmpty method will return true for an empty stack AND will return false for a nonempty stack
	public void testIsEmpty(){
		
		//makes sure isEmpty method will return true for an empty stack
		MyStack<String> testStack = new MyStack<String>();
		try{	
			assertTrue("Error in the isEmpty method", testStack.isEmpty());
		}
		catch (Exception e){
			fail("Unexpected exception thrown incorrectly from isEmpty method");
		}
		
		//makes sure isEmpty method will return false for a nonempty stack
		try{
			testStack.push("Hello");
			assertFalse("Error in the isEmpty method", testStack.isEmpty());
		}
		catch (Exception e){
			fail("Unexpected exception thrown incorrectly from isEmpty method");
		}
	}
	
	@Test
	//Makes sure push added the thing correctly, and the head reference is updated
	public void testPushFilled(){	
		try {
			MyStack<Integer> testStack = new MyStack<Integer>();
			testStack.push(3);
			assertTrue("Error in push method; head reference incorrect",testStack.peek()==3); //stack holds generic objects. comparing objects -> .equals!!
		}
		catch (Exception e){
			fail("Exception thrown incorrectly in push method");
		}
	}
	
	@Test
	//Makes sure push adds things in correct order
	public void testPushOrder(){
		try{
			MyStack <Integer> testStack = new MyStack<Integer>();
			testStack.push(3);
			testStack.push(2); 
			testStack.push(1);
			
			assertTrue("Errorin pop method", testStack.peek() == 1);
		}
		catch (Exception e){
			fail("Exception thrown incorrectly in push method");
		}
	}
	
	//Makes sure peek throws empty stack exception when the stack is empty.
	public void testPeekEmpty(){
		try{
			MyStack<StringBuffer> testStack = new MyStack<StringBuffer>();
			testStack.peek();
		}
		catch (EmptyStackException e){
			 //do nothing, test passed :)
		}
		catch (Exception e){
			fail("Incorrect exception thrown from peek method");
		}
	}
	
	@Test
	//Makes sure peek returns correct item when the stack is not empty.
		
	public void testPeekFilled(){
		//makes sure peek returns item when the stack isn't empty.
		try{
			MyStack<String> testStack = new MyStack<String>();
			testStack.push("hi");
			assertEquals("Error in peek method", testStack.peek(), "hi");
		}
		catch (Exception e){
			
			fail("testPeekFilled failed: Exception thrown\n" + e.getClass() + "\n" + e.getMessage());
		}
	}
	
	@Test
	//Makes sure peek will return items in correct order after multiple operations
	public void testPeekMultiple(){
		//makes sure peek is keeping proper track
		try{
			MyStack<String> testStack = new MyStack<String>();
			testStack.push("I like");
			testStack.peek();
			testStack.push(" to eat");
			assertTrue("Error in peek method", testStack.peek()==" to eat");
			
			testStack.push("apples and");
			testStack.push("oranges");
			assertTrue("Error in peek method", testStack.peek()== "oranges");
			
			testStack.pop();
			assertTrue("Error in peek method", testStack.peek()=="apples and");
			
			testStack.push("bananas");
			assertTrue("Error in peek method", testStack.peek()=="bananas");
		}
		catch (Exception e){
			fail("testPeekFilled failed: Exception thrown\n" + e.getClass() + "\n" + e.getMessage());
		}
	}
	
	@Test
	//Makes sure pop throws empty stack exception when the stack is empty
	
	public void testPopEmpty(){
		//makes sure pop returns error when stack is empty
		try{
			MyStack<Double> testStack = new MyStack<Double>();
			testStack.pop();
		}
		catch (EmptyStackException e){
			 //do nothing, test passed :)
		}
		catch (Exception e){
			fail("testPeekFilled failed: Exception thrown\n" + e.getClass() + "\n" + e.getMessage());
		}
	}
	
	@Test
	
	public void testPopCorrectly(){
		//makes sure pop returns and removes top element
		try{
			MyStack<Integer> testStack = new MyStack<Integer>();
			testStack.push(1); testStack.push(2); testStack.push(3); testStack.push(4);
			assertTrue("Error in pop method", testStack.pop()==4); //that it's grabbing right thing
			assertTrue("Error in pop method", testStack.peek()==3); //that it actually removed it
		}
		catch (Exception e){
			fail("testPeekFilled failed: Exception thrown\n" + e.getClass() + "\n" + e.getMessage());
		}
	}
	
	@Test
	
	public void testPopOrder(){
		//makes sure pop is removing in proper order
		try{
			MyStack<Double> testStack = new MyStack<Double>();
			testStack.push(75.6); 
			testStack.push(85.4); 
			testStack.push(92.5); 
			
			testStack.push(52.7);
			assertTrue("Error in pop method", testStack.pop()==(52.7)); //that it's grabbing the right thing
			assertTrue("Error in pop method", testStack.peek()==(92.5)); //that it actually removed it
			//52.7 should be gone
			
			testStack.push(65.3);
			testStack.pop(); //65.3
			testStack.pop(); //92.5
			testStack.pop(); //85.4
			assertTrue("Error in pop method", testStack.peek()==75.6);	
		}
		catch (Exception e){
			fail("testPeekFilled failed: Exception thrown\n" + e.getClass() + "\n" + e.getMessage());
		}
	}
}
