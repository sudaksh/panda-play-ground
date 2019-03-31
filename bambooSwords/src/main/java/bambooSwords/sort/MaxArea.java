package bambooSwords.sort;

import java.util.PriorityQueue;

/*
Input: [1,8,6,2,5,4,8,3,7]
Output: 49
 */
public class MaxArea {
    public int maxArea(int[] height) {
        PriorityQueue<Integer> pq = new PriorityQueue();
        int max= height[0];
        for (int n : height){
            pq.add(n);
            max = Math.max(n, max);
        }
        int result = pq.poll() * (height.length - 1);
        while (!pq.isEmpty()){
            int currentHeight = pq.poll();
            int l = 0;
            int r = height.length - 1;
            while (height[l] < currentHeight && l <= r) l++;
            while (height[r] < currentHeight && l <= r) r--;
            result = Math.max(result, currentHeight * (r - l));
        }
        return result;
    }

    public int maxArea2(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int result = Integer.MIN_VALUE;
        while (left < right){
            result = Math.max((right - left) * Math.min(height[left], height[right]), result);
            if (height[left] < height[right]){
                left++;
            } else {
                right--;
            }
        }
        return result;
    }
}
