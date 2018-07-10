package bambooSwords;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RegularExpressionMatcherUnitTest {
    
    private RegularExpressionMatcher regexMatcher;
    
    @Before
    public void setup(){
        regexMatcher = new RegularExpressionMatcher();
    }
    
    @Test
    public void testIsMatch1(){
       Assert.assertFalse(regexMatcher.isMatch("aa", "a"));
    }
    
    @Test
    public void testIsMatch2(){
       Assert.assertTrue(regexMatcher.isMatch("aa", "a*"));
    }
    
    @Test
    public void testIsMatch4(){
       Assert.assertTrue(regexMatcher.isMatch("aab", "c*a*b"));
    }
    
    @Test
    public void testIsMatch5(){
       Assert.assertFalse(regexMatcher.isMatch("mississippi", "mis*is*p*"));
    }
    
    @Test
    public void testIsMatch6(){
       Assert.assertTrue(regexMatcher.isMatch("bbbbbcd", ".*d"));
    }
    
    @Test
    public void testIsMatch7(){
       Assert.assertTrue(regexMatcher.isMatch("bbbbbcd", "bb.*"));
    }

}
