package bambooSwords.array;

import org.junit.Test;

public class FirstMissingPositiveUnitTest {

    @Test
    public void test(){
        FirstMissingPositive firstMissingPositive = new FirstMissingPositive();
        int[] nums = {0,5,-1,1,1,2};
        System.out.println(firstMissingPositive.firstMissingPositive(nums));

    }
}
