package bambooSwords;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class Zero3SumUnitTest {
    
    private Zero3Sum zero3Sum;
    
    @Before
    public void setup() {
        zero3Sum =  new Zero3Sum();
    }
    
    @Test
    public void testThreeSum(){
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> output = zero3Sum.threeSum(nums);
        System.out.println(output);
    }

}
