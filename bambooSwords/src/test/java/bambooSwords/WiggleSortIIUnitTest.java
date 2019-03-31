package bambooSwords;

import bambooSwords.sort.WiggleSortII;
import org.junit.Test;

public class WiggleSortIIUnitTest {

    @Test
    public void test(){
        WiggleSortII waggleSort = new WiggleSortII();
        int[] nums = new int[]{1,3,2,2,3,1};
        waggleSort.wiggleSort(nums);
        for (int n : nums){
            System.out.print(n);
        }
    }
}
