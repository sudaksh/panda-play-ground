package bambooSwords.array;

import org.junit.Test;

public class RemoveDupFromSortedArrayIIUnitTest {

    @Test
    public void test(){
        RemoveDupFromSortedArrayII removeDupFromSortedArrayII = new RemoveDupFromSortedArrayII();
        int[] nums = new int[]{0,0,1,1,1,1,2,3,3};

        System.out.println(removeDupFromSortedArrayII.removeDuplicates(nums));
        for (int n : nums){
            System.out.print(n + " ");
        }
    }
}
