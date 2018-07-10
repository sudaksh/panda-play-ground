package bambooSwords;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class LongestCommonPrefixUnitTest {
    
    private LongestCommonPrefix commonPrefix;
    
    @Before
    public void setup() {
        commonPrefix = new LongestCommonPrefix();
    }
    
    @Test
    public void testLongestCommonPrefix1(){
        String[] input = {"flower","flow","flight"};
        assertEquals("fl", commonPrefix.longestCommonPrefix(input));
    }
    
    
    @Test
    public void testLongestCommonPrefix2(){
        String[] input = {"c" , "c"};
        assertEquals("c", commonPrefix.longestCommonPrefix(input));
    }

}
