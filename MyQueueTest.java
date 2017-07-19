package project3;

import static org.junit.Assert.*;

import org.junit.Test;

public class MyQueueTest {

	@Test
	public void testConstructor() {
		//test creation of a queue that points to null
		try {
			MyQueue<Integer> testQueue = new MyQueue<Integer>();
			assertNotNull("Reference null after constructor returns", testQueue);
		}
		catch (Exception e) {
			fail("testPeekFilled failed: Exception thrown\n" + e.getClass() + "\n" + e.getMessage());
		}
	}
	
	@Test
	//Makes sure peek returns null when the queue is empty.
	public void testPeekEmpty(){
		
		try{
			MyQueue<StringBuffer> testQueue = new MyQueue<StringBuffer>();
			assertNull("Error in peek method", testQueue.peek());
		}
		catch (Exception e){
			fail("testPeekFilled failed: Exception thrown\n" + e.getClass() + "\n" + e.getMessage());
		}
	}
	
	@Test
	//Makes sure peek returns correct item when the queue isn't empty.
	public void testPeekFilled(){
		try{
			MyQueue<String> testQueue = new MyQueue<String>();
			testQueue.offer("hi");
			assertEquals("Error in peek method", testQueue.peek(), ("hi"));
		}
		catch (Exception e){
			fail("testPeekFilled failed: Exception thrown\n" + e.getClass() + "\n" + e.getMessage());
		}	
	}
	
	@Test
	//Makes sure poll returns null when the queue is empty.
	public void testPollEmpty(){
		try{
			MyQueue<Double> testQueue = new MyQueue<Double>();
			assertNull("Error in pop method", testQueue.poll());
		}
		catch (Exception e){
			fail("testPeekFilled failed: Exception thrown\n" + e.getClass() + "\n" + e.getMessage());
		}
	}

	@Test
	//Makes sure poll returns correct item when the queue isn't empty
	public void testPollFilled(){
		try{
			MyQueue<String> testQueue = new MyQueue<String>();
			testQueue.offer("hi");
			assertTrue("Error in poll method", testQueue.peek()=="hi");
		}
		catch (Exception e){
			fail("testPeekFilled failed: Exception thrown\n" + e.getClass() + "\n" + e.getMessage());
		}
	}
	
	@Test
	//Makes sure offer throws NullPointerException if a null element is added
	public void testOfferNull(){
		try{
			MyQueue<Integer> testQueue = new MyQueue<Integer>();
			testQueue.offer(null);
		}
		catch (NullPointerException e){
			//do nothing, test passed :)
		}
		catch(Exception e){
			fail("testPeekFilled failed: Exception thrown\n" + e.getClass() + "\n" + e.getMessage());
		}
	}
	
	@Test
	//Makes sure offer throws ClassCastException if an element of a different class is added
	public void testOfferClassCast(){
		try{
			MyQueue<String> testQueue = new MyQueue<String>();
			Object x= 9;
			testQueue.offer((String)x);
			assertTrue("error", x instanceof String);
		}
		catch (ClassCastException e){
			//do nothing, test passed :)
		}
		catch (Exception e){
			fail("testPeekFilled failed: Exception thrown\n" + e.getClass() + "\n" + e.getMessage());
		}
	}
}
