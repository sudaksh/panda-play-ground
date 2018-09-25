package bambooSwords;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LargestNumber {
    public String largestNumber(int[] nums) {
        PriorityQueue priorityQueue=new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                if (a == 0) return 1;
                if (b == 0) return -1;
                String aString = a.toString();
                String bString = b.toString();
                String aPre = aString + bString;
                String bPre = bString + aString;
                for (int i = 0; i < aPre.length(); i++){
                    if (Integer.valueOf(aPre.charAt(i)) > Integer.valueOf(bPre.charAt(i))){
                        return -1;
                    }
                    if (Integer.valueOf(aPre.charAt(i)) < Integer.valueOf(bPre.charAt(i))){
                        return 1;
                    }
                }
                return 0;

            }
        });
        for (int n : nums){
            priorityQueue.add(n);
        }
        StringBuilder sb = new StringBuilder();
        while(!priorityQueue.isEmpty()){
            sb.append(priorityQueue.poll());
        }
        if (sb.charAt(0) == '0' && sb.charAt(sb.length() - 1) == '0') return "0";
        return sb.toString();
    }
}
