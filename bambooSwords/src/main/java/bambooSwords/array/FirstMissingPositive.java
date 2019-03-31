package bambooSwords.array;

import static bambooSwords.generalClass.Util.swap;

public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) return 1;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] <= nums.length && nums[i] >= 1 && nums[i] != i + 1){
                if (nums[i] != nums[nums[i] - 1]){
                    swap(i, nums[i] - 1, nums);
                    i = i - 1;
                } else {
                    nums[i] = -1;
                }
            }
        }

        for (int i = 0; i < nums.length; i++){
            if (i + 1 != nums[i]){
                return i + 1;
            }
        }
        return nums.length + 1;
    }
}
