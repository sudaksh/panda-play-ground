package bambooSwords;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class FirstLastPositionSortedArrUnitTest {
	
	private FirstLastPositionSortedArr firstLastPositionSortedArr;
	
	
	@Before
	public void setup() {
		firstLastPositionSortedArr = new FirstLastPositionSortedArr();
	}
	
	@Test
	public void testSolution1() {
		int[] searchRange = firstLastPositionSortedArr.searchRange(new int[] {5,7,7,8,8,10}, 8);
		
		assertEquals(3, searchRange[0]);
		assertEquals(4, searchRange[1]);

		
	}

}
