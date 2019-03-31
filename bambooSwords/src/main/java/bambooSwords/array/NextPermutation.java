package bambooSwords.array;

import bambooSwords.generalClass.Util;

/*
Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place and use only constant extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.

1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1
 */
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) return;
        int i = nums.length - 1;
        while (i >= 1 && nums[i] <= nums[i - 1]){
            i--;
        }
        if (i != 0){
            for (int j = nums.length - 1; j > i - 1; j--){
                if (nums[j] > nums[i - 1]){
                    Util.swap(i - 1, j, nums);
                    break;
                }
            }
        }
        Util.reverse(i, nums);
    }

}
