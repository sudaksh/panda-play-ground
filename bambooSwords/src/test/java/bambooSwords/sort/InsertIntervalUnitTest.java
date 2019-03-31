package bambooSwords.sort;

import bambooSwords.generalClass.Interval;
import bambooSwords.generalClass.ListNode;
import bambooSwords.sort.InsertInterval;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class InsertIntervalUnitTest {

    @Test
    public void test(){
        List<Interval> list = new ArrayList<>();
//        Interval i0 = new Interval(1, 2);
        Interval i1 = new Interval(3, 5);
//        Interval i2 = new Interval(6,7);
        Interval i3 = new Interval(12,15);
//        list.add(i0);
        list.add(i1);
//        list.add(i2);
        list.add(i3);

        Interval new1 = new Interval(6, 6);
        InsertInterval insertInterval = new InsertInterval();
        insertInterval.insert(list, new1);
        for (Interval i : list){
            System.out.print(i.start + " " + i.end);
            System.out.println();
        }
    }

    @Test
    public void testObject(){
        ListNode n = new ListNode(2);
        change(n);
        n = null;
        System.out.print(n.val);
    }
    public void change(ListNode j){
        j = null;

        int x = 10;
        int y = 30;
        return;
    }
}
