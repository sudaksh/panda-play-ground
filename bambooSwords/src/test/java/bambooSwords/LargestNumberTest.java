package bambooSwords;

import org.junit.Test;

import java.util.PriorityQueue;

public class LargestNumberTest {

    @Test
    public void testLargestNumber(){
        int nums[] = new int[]{121,12};
        LargestNumber largestNumber = new LargestNumber();
        System.out.print(largestNumber.largestNumber(nums));

        System.out.println("=====testing pq======");
        PriorityQueue pq = new PriorityQueue();
        pq.add(1);
        pq.add(2);
        pq.add(3);
        while (!pq.isEmpty()){
            System.out.println(pq.poll());
        }
    }


}
