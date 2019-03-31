package bambooSwords.array;

/*
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

Your algorithm's runtime complexity must be in the order of O(log n).

Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
 */
public class SearchInRotatedArray {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int l = 0;
        int r = nums.length - 1;
        int mid;
        while (l < r){ // if not putting equal here, you will miss {1}, l==r, but if put equals here, be careful of infinite loop
            mid = (l + r) / 2;
            if (nums[mid] == target){
                return mid;
            }
            if (nums[l] == target){
                return l;
            }
            if (nums[r] == target){
                return r;
            }
            if (nums[l] < nums[mid]){ // left part is increasing, pivot is on right part
                if (target >= nums[l] && target < nums[mid]){
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else { // pivot is on left part, right part is increasing
                if (target > nums[mid] && target <= nums[r]){
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        if (l < nums.length && nums[l] == target) return l;
        if (r >= 0 && nums[r] == target) return r;
        return -1;
    }

    /*
    Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).

You are given a target value to search. If found in the array return true, otherwise return false.

Example 1:

Input: nums = [2,5,6,0,0,1,2], target = 0
Output: true
Example 2:

Input: nums = [2,5,6,0,0,1,2], target = 3
Output: false
     */

// just add one more situation, if (nums[l] < nums[mid]), l++

}
