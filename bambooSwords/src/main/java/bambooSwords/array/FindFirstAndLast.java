package bambooSwords.array;

/*
Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
 */
public class FindFirstAndLast {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        if (nums == null || nums.length < 1) return result;
        int l = 0;
        int r = nums.length - 1;
        int mid = 0;
        while (l <= r){
            mid = (l + r) / 2;
            if (nums[mid] < target){
                l = mid + 1;
            } else if (nums[mid] > target){
                r = mid - 1;
            } else {
                break;
            }
        }
        if (nums[mid] != target) return result;
        int l2 = mid;
        int r2 = mid;
        int midl = mid;
        int midr = mid;

        while (l <= r2){
            midl = (l + r2) / 2;
            if (nums[midl] < target){
                l = midl + 1;
            } else {
                r2 = midl - 1;
            }
        }
        if (nums[l] == target) result[0] = l;

        while (l2 <= r){
            midr = (l2 + r) / 2;
            if (nums[midr] > target){
                r = midr - 1;
            } else {
                l2 = midr + 1;
            }
        }
        if (nums[r] == target) result[1] = r;

        return result;
    }
}
