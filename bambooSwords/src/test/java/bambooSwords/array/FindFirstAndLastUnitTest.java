package bambooSwords.array;

import org.junit.Test;

public class FindFirstAndLastUnitTest {

    @Test
    public void test(){
        FindFirstAndLast findFirstAndLast = new FindFirstAndLast();
        int[] nums = {1,4};
        int target = 4;
        int[] result = findFirstAndLast.searchRange(nums, target);
        for (int i : result){
            System.out.print(i + " ");
        }
    }
}
