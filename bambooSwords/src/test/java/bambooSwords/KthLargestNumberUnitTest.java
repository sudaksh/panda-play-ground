package bambooSwords;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class KthLargestNumberUnitTest {
	
	private KthLargestNumber kthLargestNumber;
	
	@Before
	public void setup() {
		kthLargestNumber = new KthLargestNumber();
	}
	
	@Test
	public void testFindLargest1() {
		int[] input = {1,5,3,8,6,2,2,9,11,20,4,5};
//		1 2 2 3 4 5 5 6 8 9 11 20 

		assertEquals(11, kthLargestNumber.findLargest(input, 2));
	}
	
	@Test
	public void testFindLargest2() {
		int[] input = {1,5,3,8,6,2,2,9,11,20,4,5};
//		1 2 2 3 4 5 5 6 8 9 11 20 

		assertEquals(6, kthLargestNumber.findLargest(input, 5));
	}
	
	@Test
	public void testFindLargest3() {
		int[] input = {1,5,3,8,6,2,2,9,11,20,4,5};
//		1 2 2 3 4 5 5 6 8 9 11 20 

		assertEquals(20, kthLargestNumber.findLargest(input, 1));
	}
	
	
	@Test
	public void testFindLargest4() {
		int[] input = {1,5,3,8,6,2,2,9,11,20,4,5};
//		1 2 2 3 4 5 5 6 8 9 11 20 

		assertEquals(2, kthLargestNumber.findLargest(input, 10));
	}
	
	@Test
	public void testFindLargest5() {
		int[] input = {1,5,3,8,6,2,2,9,11,20,4,5};
//		1 2 2 3 4 5 5 6 8 9 11 20 

		assertEquals(2, kthLargestNumber.findLargest(input, 11));
	}
	
	@Test
	public void testFindLargest6() {
		int[] input = {1,5,3,8,6,2,2,9,11,20,4,5};
//		1 2 2 3 4 5 5 6 8 9 11 20 

		assertEquals(1, kthLargestNumber.findLargest(input, 12));
	}

}
