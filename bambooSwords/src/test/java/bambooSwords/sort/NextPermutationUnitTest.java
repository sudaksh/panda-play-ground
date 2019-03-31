package bambooSwords.sort;

import bambooSwords.array.NextPermutation;
import org.junit.Test;

public class NextPermutationUnitTest {

    @Test
    public void test(){
        NextPermutation nextPermutation = new NextPermutation();
        int[] nums = new int[]{5,1,1};
        nextPermutation.nextPermutation(nums);
        for (int i : nums){
            System.out.print(i);
        }
    }
}
