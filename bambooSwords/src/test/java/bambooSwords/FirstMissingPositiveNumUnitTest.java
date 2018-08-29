package bambooSwords;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*

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
    
    
}
