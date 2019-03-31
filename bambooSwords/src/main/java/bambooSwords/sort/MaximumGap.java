package bambooSwords.sort;

public class MaximumGap {
    public int maximumGap(int[] nums) {
        if (nums == null || nums.length <= 1) return 0;
        int globalMin = nums[0];
        int globalMax = nums[0];
        for (int i = 1; i < nums.length; i++){
            globalMin = Math.min(globalMin, nums[i]);
            globalMax = Math.max(globalMax, nums[i]);
        }
        if (globalMin == globalMax) return 0;
        int bucketsLength = (globalMax - globalMin) / nums.length + 1;
        int bucketsTotal = (globalMax - globalMin) / bucketsLength + 1;
        Bucket[] buckets = new Bucket[bucketsTotal];
        for (int i = 0; i < buckets.length; i++){
            buckets[i] = new Bucket();
        }
        for (int i = 0; i < nums.length; i++){
            int index = (nums[i] - globalMin) / bucketsLength;
            buckets[index].min = Math.min(buckets[index].min, nums[i]);
            buckets[index].max = Math.max(buckets[index].max, nums[i]);
        }
        int result = buckets[0].max - buckets[0].min;
        for (int i = 0, j = 1; j < buckets.length;j++, i++){
            while (j < buckets.length && buckets[j].min == Integer.MAX_VALUE){
                j++;
            }
            if (j < buckets.length){
                result = Math.max(buckets[j].min - buckets[i].max, result);
                i = j - 1;
            }
        }

        return result;

    }
}
 class Bucket {
    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;
    Bucket(int min, int max){
        this.min = min;
        this.max = max;
    }
    Bucket(){

    }

}