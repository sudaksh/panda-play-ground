package bambooSwords.sort;

import bambooSwords.sort.MaxArea;
import org.junit.Test;

public class MaxAreaUnitTest {

    @Test
    public void test(){
        int[] height = new int[]{1,8,6,2,5,4,8,3,7};
        MaxArea maxArea = new MaxArea();
        int res = maxArea.maxArea2(height);
        System.out.print("Max area is " + res);
    }
}
