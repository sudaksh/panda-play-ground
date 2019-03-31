package bambooSwords.sort;

import bambooSwords.generalClass.Interval;

import java.util.*;

/*
Input: [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 */
public class MergeInterval {
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() <= 1){
            return intervals;
        }
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if (o1.start > o2.start) return 1;
                if (o1.start < o2.start) return -1;
                if (o1.end > o2.end) return 1;
                if (o1.end < o2.end) return -1;
                return 0;
            }
        });
        List<Interval> result = new ArrayList<>();
        Interval cur = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++){
            Interval next = intervals.get(i);
            if (cur.end >= intervals.get(i).start){
                Interval add = new Interval(Math.min(cur.start, next.start), Math.max(cur.end, next.end));
                // result.add(add);
                cur = add;
            } else {
                result.add(cur);
                cur = next;
            }
        }
        if (intervals.get(intervals.size() - 1).start >= cur.start &&
                intervals.get(intervals.size() - 1).start <= cur.end){
            result.add(cur);
        } else {
            result.add(intervals.get(intervals.size() - 1));
        }
        return result;
    }
}
