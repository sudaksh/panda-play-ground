package bambooSwords.array;

import java.util.*;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 3) return result;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++){
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int target = -nums[i];
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right){
                if (nums[left] + nums[right] == target){
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                    while (left > 0 && left < right && nums[left] == nums[left - 1]) left++;
                    while (right < nums.length - 1 && left < right && nums[right] == nums[right + 1]) right--;
                } else if (nums[left] + nums[right] < target){
                    left++;
                } else {
                    right--;
                }

            }

        }
        return result;
    }

    public int threeSumClosest(int[] nums, int target) {
        int diff = Integer.MAX_VALUE;
        int result = nums[0];
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++){
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right){
                if (nums[left] + nums[right] + nums[i] == target){
                    return target;
                } else if (nums[left] + nums[right] + nums[i] < target){
                    if (diff > Math.abs(target - nums[left] - nums[right] - nums[i])){
                        diff = Math.abs(target - nums[left] - nums[right] - nums[i]);
                        result = nums[left] + nums[right] + nums[i];
                    }
                    left++;
                } else {
                    if (diff > Math.abs(target - nums[left] - nums[right] - nums[i])){
                        diff = Math.abs(target - nums[left] - nums[right] - nums[i]);
                        result = nums[left] + nums[right] + nums[i];
                    }
                    right--;
                }
            }
            while (left < right && nums[left] == nums[left + 1]) left++;
            while (left < right && nums[right] == nums[right - 1]) right--;
        }
        return result;
    }
}
