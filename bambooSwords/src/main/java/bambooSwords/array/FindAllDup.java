package bambooSwords.array;

import java.util.*;

/*
Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

Find all the elements that appear twice in this array.

Could you do it without extra space and in O(n) runtime?

Example:
Input:
[4,3,2,7,8,2,3,1]

Output:
[2,3]
 */
public class FindAllDup {
    public List<Integer> findDuplicates(int[] nums) {
        Set<Integer> res = new HashSet<>();
        for (int i = 0; i < nums.length;){
            if (nums[i] == -1 || nums[i] == i + 1){
                i++;
                continue;
            }
            if (nums[nums[i] - 1] == nums[i]){
                res.add(nums[i]);
                nums[i] = -1;
                i++;
            } else {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        return new ArrayList<>(res);
    }
}
