package bambooSwords.array;

/*
Input: [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
one pass, constant space
 */

import bambooSwords.generalClass.Util;

public class SortColors {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length <= 1) return;
        int z = 0;
        int o = 0;
        int t = 0;
        for (int k = 0; k < nums.length; k++){
            if (nums[k] == 0){
                nums[t++] = 2;
                nums[o++] = 1;
                nums[z++] = 0;
            } else if (nums[k] == 1){
                nums[t++] = 2;
                nums[o++] = 1;
            } else {
                nums[t++] = 2;
            }
        }
    }
}
