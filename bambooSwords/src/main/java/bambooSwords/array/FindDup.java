package bambooSwords.array;

/*
Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.

Example 1:

Input: [1,3,4,2,2]
Output: 2
Example 2:

Input: [3,1,3,4,2]
Output: 3
Note:

You must not modify the array (assume the array is read only).
You must use only constant, O(1) extra space.
Your runtime complexity should be less than O(n2).
There is only one duplicate number in the array, but it could be repeated more than once.
 */
public class FindDup {
    public int findDuplicate(int[] nums) {
        int l = 1;
        int r = nums.length;
        while (l < r){
            int mid = (l + r) / 2;
            int cl = 0;
            for (int i = 0; i < nums.length; i++){
                if (nums[i] <= mid){
                    cl++;
                }
            }
            if (cl > mid){
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public int findDuplicate2(int[] nums) {
        int slow = 0;
        int fast = 0;

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        int start = 0;

        do {
            start = nums[start];
            slow = nums[slow];
        } while (slow != start);

        return slow;
    }
}
