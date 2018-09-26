package bambooSwords;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FirstMissingPositiveNumUnitTest {
	
	private FirstMissingPositiveNum missingPositiveNum;

	
    @Before
    public void setup() {
    	missingPositiveNum = new FirstMissingPositiveNum();
    }
    
    @Test
    public void testFindFirstMissingPositive1() {
    	assertEquals(4, missingPositiveNum.firstMissingPositive(new int[] {1,2,3}));
    }
    
    
    @Test
    public void testFindFirstMissingPositive2() {
    	assertEquals(10, missingPositiveNum.firstMissingPositive(new int[] {7,5,6,2,8,-1,-4,-5,1,2,-2,-7,3,4,9,11,13,15}));
    }
    
    
}
