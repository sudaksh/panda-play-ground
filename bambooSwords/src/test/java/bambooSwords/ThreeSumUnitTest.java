package bambooSwords;

import bambooSwords.array.ThreeSum;
import org.junit.Test;

public class ThreeSumUnitTest {

    @Test
    public void test(){
        ThreeSum threeSum = new ThreeSum();
        int[] nums = new int[]{-1,2,1,-4};
        int result = threeSum.threeSumClosest(nums, 1);
        System.out.print(result);
    }
}
