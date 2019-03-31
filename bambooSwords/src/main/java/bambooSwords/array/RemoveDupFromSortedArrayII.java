package bambooSwords.array;

/*
Given nums = [1,1,1,2,2,3],

Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3 respectively.

It doesn't matter what you leave beyond the returned length.
 */
public class RemoveDupFromSortedArrayII {
    public int removeDuplicates(int[] nums) {
        if (nums == null) return 0;
        if (nums.length <= 1) return nums.length;
        int PCheck = 1;
        int PInsert = 0;
        int count = 1;
        int currentNum = nums[0];
        while (PCheck < nums.length){
            while (PCheck < nums.length && currentNum == nums[PCheck]){
                count++;
                if (count <= 2){
                    nums[++PInsert] = currentNum;
                }
                PCheck++;
            }
            if (PCheck >= nums.length) return PInsert + 1;
            nums[++PInsert] = nums[PCheck++];
            currentNum = nums[PInsert];
            count = 1;
        }
        return PInsert + 1;
    }

    public int removeDuplicates2(int[] nums){
        if (nums == null) return 0;
        if (nums.length <= 1) return nums.length;
        int count = 1;
        int slow = 0;
        for (int i = 1; i < nums.length; i++){
            if (nums[i] == nums[slow]){
                if (count < 2){
                    nums[++slow] = nums[i];
                    count++;
                }
            } else {
                nums[++slow] = nums[i];
                count = 1;
            }
        }
        return slow + 1;
    }
}
