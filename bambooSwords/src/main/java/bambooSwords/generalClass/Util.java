package bambooSwords.generalClass;

public class Util {
    public static void swap(int indexA, int indexB, int[] nums){
        int temp = nums[indexA];
        nums[indexA] = nums[indexB];
        nums[indexB] = temp;
    }

    public static void reverse(int l, int[] nums){
        int r = nums.length - 1;
        while (l <= r){
            swap(l, r, nums);
            l++;
            r--;
        }
    }
}
