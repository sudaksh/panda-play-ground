package bambooSwords.sort;

import bambooSwords.array.TrappingRainWater;
import org.junit.Test;

public class TrappingRainWaterUnitTest {

    @Test
    public void test(){
        TrappingRainWater rainWater = new TrappingRainWater();
        int[] height = new int[]{2,1,0,2};
        System.out.print(rainWater.trap(height));
    }
}
