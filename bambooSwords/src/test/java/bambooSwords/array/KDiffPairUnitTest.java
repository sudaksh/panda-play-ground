package bambooSwords.array;

import org.junit.Test;

public class KDiffPairUnitTest {

    @Test
    public void test(){
        KDiffPair kDiffPair = new KDiffPair();
        int[] nums = {1,3,1,5,4};
        int i = kDiffPair.findPairs(nums, 0);
    }
}
