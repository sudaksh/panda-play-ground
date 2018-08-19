package bambooSwords;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class testMedianofTwoSortedArrays {

    @Test
    public void test(){
        MedianofTwoSortedArrays method = new MedianofTwoSortedArrays();
        int[] A;
        int[] B;
        double result;
//
//        A = new int[]{};
//        B = new int[]{1};
//        result = method.findMedianSortedArrays(A, B);
//        Assert.assertEquals(result, 1d, 0);

        A = new int[]{1,2};
        B = new int[]{1,2};
        result = method.findMedianSortedArrays(A, B);
       // Assert.assertEquals(result, 4d, 0);
        System.out.print(result);

    }
}
