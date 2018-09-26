package bambooSwords;

import org.junit.Before;
import org.junit.Test;

public class QuickSortUnitTest {
	
	private QuickSort quickSort;
	
	@Before
	public void setup() {
		quickSort = new QuickSort();
	}
	
	@Test
	public void testSort1() {
		int[] input = {1,5,3,8,6,2,2,9,11,20,4,5};
		
		print(input);
		
		quickSort.sort1(input);
		print(input);

	}
	
	
	
	@Test
	public void testSort2() {
		int[] input = {1,5,3,8,6,2,2,9,11,20,4,5};
		
		print(input);
		
		quickSort.sort2(input);
		print(input);

	}

	private void print(int[] input) {
		for(int i : input) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

}
