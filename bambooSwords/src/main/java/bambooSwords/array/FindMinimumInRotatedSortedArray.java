package bambooSwords.array;

import java.util.Arrays;

/*
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).

Find the minimum element.

You may assume no duplicate exists in the array.

Example 1:

Input: [3,4,5,1,2]
Output: 1
Example 2:

Input: [4,5,6,7,0,1,2]
Output: 0
 */
public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        if (nums.length == 1) return nums[0];
        int l = 0;
        int r = nums.length - 1;
        if (nums[l] < nums[r]) return nums[l];
        int mid;
        while (l + 1 < r){
            mid = (l + r) / 2;
            if (mid > 0 && mid < nums.length - 1){
                if (nums[mid] < nums[mid - 1] && nums[mid] < nums[mid + 1]){
                    return nums[mid];
                } else {
                    if (nums[l] > nums[mid]){
                        r = mid;
                    } else {
                        l = mid;
                    }
                }
            } else {
                break;
            }
        }
        Arrays.sort(nums);
        return Math.min(nums[l] , nums[r]);
    }
}
