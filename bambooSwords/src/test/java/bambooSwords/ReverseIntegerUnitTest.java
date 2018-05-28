package bambooSwords;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ReverseIntegerUnitTest {
    
    private ReverseInteger reverseInteger;
    
    @Before
    public void setup(){
        reverseInteger = new ReverseInteger();
    }
    
//    @Test
    public void testReverse1(){
        Assert.assertEquals(-321, reverseInteger.reverse(-123));
    }
    
    @Test
    public void testReverse2(){
        Assert.assertEquals(0, reverseInteger.reverse(1534236469));
    }

}
