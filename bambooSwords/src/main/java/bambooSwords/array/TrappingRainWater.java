package bambooSwords.array;

import java.util.HashSet;
import java.util.PriorityQueue;

public class TrappingRainWater {
    public int trap(int[] height) {
        if (height == null || height.length <= 1) return 0;
        HashSet<Integer> hashSet = new HashSet<>();
        PriorityQueue<Integer> pq = new PriorityQueue();
        for (int i : height){
            hashSet.add(i);
        }
        if (hashSet.size() == 1) return 0;
        pq.addAll(hashSet);
        int result = 0;
        int s = pq.poll();
        int b = pq.peek();
        boolean first = true;
        while (!pq.isEmpty() || first){
            pq.poll();
            result = result + findHollow(s, b, height) * (b - s);
            s = b;
            if (!pq.isEmpty()) b = pq.peek();
            first = false;
        }
        return result;
    }

    public int findHollow(int s, int b, int[] height){
        int l = 0;
        int r = 0;
        int result = 0;
        int countS = 0;
        while (height[l] < b && l < height.length) l++;
        if (l >= height.length) return 0;
        for (r = l + 1; r < height.length; r++){
            if (height[r] == s){
                countS++;
                height[r] = b;
            } else if (height[r] >= b){
                result = result + countS;
                countS = 0;
            }
        }
        return result;
    }

    public int trapOn(int[] height) {
        if (height == null || height.length <= 1) return 0;
        int size = height.length;
        int[] leftMax = new int[size];
        int[] rightMax = new int[size];
        leftMax[0] = height[0];
        rightMax[size - 1] = height[size - 1];
        for (int i = 1; i < size; i++){
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }
        for (int i = size - 2; i >= 0; i--){
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }
        int result = 0;
        for (int i = 0; i < size; i++){
            result = Math.min(leftMax[i], rightMax[i]) - height[i] + result;
        }
        return result;
    }
}
