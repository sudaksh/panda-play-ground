package bambooSwords;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class SearchSortedRotatedArrayUnitTest {
	
	private SearchSortedRotatedArray searchSortedRotatedArray;
	
	@Before
	public void setup() {
		searchSortedRotatedArray = new SearchSortedRotatedArray();
	}
	
	@Test
	public void testSearch1() {
		assertEquals(5, searchSortedRotatedArray.search(new int[] {5,6,7,8,1,2,3,4}, 2) );
	}
	
	@Test
	public void testSearch2() {
		assertEquals(3, searchSortedRotatedArray.search(new int[] {5,6,7,8,1,2,3,4}, 8) );
	}
	
	@Test
	public void testSearch3() {
		assertEquals(7, searchSortedRotatedArray.search(new int[] {5,6,7,8,1,2,3,4}, 4) );
	}
	
	@Test
	public void testSearch4() {
		assertEquals(1, searchSortedRotatedArray.search(new int[] {5,6,7,8,1,2,3,4}, 6) );
	}
	
	
	@Test
	public void testSearch5() {
		assertEquals(0, searchSortedRotatedArray.search(new int[] {1}, 1) );
	}
	
	
	@Test
	public void testSearch6() {
		assertEquals(-1, searchSortedRotatedArray.search(new int[] {1}, 0) );
	}

}
