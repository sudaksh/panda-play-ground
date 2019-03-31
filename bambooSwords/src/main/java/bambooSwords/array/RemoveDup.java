package bambooSwords.array;

import bambooSwords.generalClass.Util;

import static bambooSwords.generalClass.Util.swap;

/*
Given nums = [0,0,1,1,1,2,2,3,3,4],

Your function should return length = 5, with the first five elements of nums being modified to 0, 1, 2, 3, and 4 respectively.

It doesn't matter what values are set beyond the returned length.
 */
public class RemoveDup {
    public int removeDuplicates(int[] nums) {
        if (nums == null) return 0;
        if (nums.length <= 1) return nums.length;
        int curPointer = 0;
        int prePointer = 1;
        while (prePointer < nums.length){
            if (nums[curPointer] != nums[prePointer]){
                swap(++curPointer, prePointer, nums);
            }
            prePointer++;
        }
        return curPointer + 1;
    }
}
