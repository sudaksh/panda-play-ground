package bambooSwords.sort;

import bambooSwords.generalClass.Interval;
import bambooSwords.sort.MergeInterval;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class MergeIntervalUnitTest {

    @Test
    public void test(){
        List<Interval> list = new ArrayList<>();
        Interval i0 = new Interval(1, 4);
        Interval i1 = new Interval(4, 5);
//        Interval i2 = new Interval(8,10);
//        Interval i3 = new Interval(15,18);
        list.add(i0);
        list.add(i1);
//        list.add(i2);
//        list.add(i3);

        MergeInterval mergeInterval = new MergeInterval();
        List<Interval> result = mergeInterval.merge(list);
        for (Interval i : result){
            System.out.print(i.start + " " + i.end);
            System.out.println();
        }
    }
}
