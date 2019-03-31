package bambooSwords.array;

/*
Given nums = [0,1,2,2,3,0,4,2], val = 2,

Your function should return length = 5, with the first five elements of nums containing 0, 1, 3, 0, and 4.

Note that the order of those five elements can be arbitrary.

It doesn't matter what values are set beyond the returned length.
 */

import bambooSwords.generalClass.Util;

import static bambooSwords.generalClass.Util.swap;

public class RemoveElements {
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) return 0;
        int curPointer = 0;
        int prePointer = 0;
        while (curPointer < nums.length && nums[curPointer] != val){
            curPointer++;
        }
        prePointer = curPointer + 1;
        while (prePointer < nums.length){
            if (nums[prePointer] != val){
                swap(curPointer, prePointer, nums);
                curPointer++;
            }
            prePointer++;
        }
        return curPointer;
    }
}
