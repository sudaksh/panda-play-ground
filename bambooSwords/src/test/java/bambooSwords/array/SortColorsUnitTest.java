package bambooSwords.array;

import org.junit.Test;

public class SortColorsUnitTest {
    @Test
    public void test(){
        int[] nums = new int[]{0,2,1,0,2,1,1,0};
        SortColors sortColors = new SortColors();
        sortColors.sortColors(nums);
        for (int n : nums){
            System.out.print(n);
        }
    }
}
