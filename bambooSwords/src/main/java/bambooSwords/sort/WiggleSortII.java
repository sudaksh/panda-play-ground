package bambooSwords.sort;

import java.util.Arrays;

public class WiggleSortII {
    public void wiggleSort(int[] nums) {
        if (nums == null || nums.length <= 1) return ;
        Arrays.sort(nums);
        int[] result = new int[nums.length];
        int l = (nums.length + 1) / 2 - 1;
        int r = nums.length - 1;
        int i = 0;
        while (i < nums.length){
            result[i] = nums[l];
            if (i + 1 < nums.length) result[i + 1] = nums[r];
            i = i + 2;
            l--;
            r--;
        }
        for (int j = 0; j < nums.length; j++){
            nums[j] = result[j];
        }
    }
}
