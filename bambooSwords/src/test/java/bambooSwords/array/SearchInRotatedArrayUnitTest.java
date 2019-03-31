package bambooSwords.array;

import org.junit.Test;

public class SearchInRotatedArrayUnitTest {
    @Test
    public void test(){
        SearchInRotatedArray searchInRotatedArray = new SearchInRotatedArray();
        int[] nums = new int[]{3,1};
        int target  = 1;
        int result = searchInRotatedArray.search(nums, target);
        System.out.print(result);

    }
}
