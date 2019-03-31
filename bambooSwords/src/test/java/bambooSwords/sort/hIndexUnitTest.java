package bambooSwords.sort;

import bambooSwords.sort.HIndex;
import org.junit.Test;

public class hIndexUnitTest {

    @Test
    public void test(){
        int[] nums = new int[]{1,2,3,4};
        HIndex hIndex = new HIndex();
        System.out.print(hIndex.hIndex(nums));

    }
}
