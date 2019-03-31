package bambooSwords.sort;

import bambooSwords.generalClass.Interval;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if (intervals == null || intervals.size() == 0){
            if (newInterval == null){
                return null;
            } else {
                ArrayList<Interval> arrayList = new ArrayList<>();
                arrayList.add(newInterval);
                return arrayList;
            }
        }
        if (newInterval == null){
            return intervals;
        }
        int i = 0;
        for (i = 0; i < intervals.size(); i++){
            if (insert(i, intervals, newInterval)){
                return intervals;
            }
        }
        i = 0;
        for (i = 0; i < intervals.size(); i++){
            if (merge(newInterval, intervals.get(i), intervals, i, true)){
                break;
            }
        }
        for (;i < intervals.size() - 1; i++){
            if (!merge(intervals.get(i), intervals.get(i + 1), intervals, i, false)){
                break;
            } else {
                i = i -1;
            }
        }
        return intervals;
    }

    public boolean merge(Interval i, Interval j, List<Interval> intervals, int index, boolean newInterval){
        Interval addInterval = null;
        if (j.start <= i.start){
            if (j.end >= i.start && j.end <= i.end){
                addInterval = new Interval(j.start, i.end);
            }
            if (j.end > i.end){
                addInterval = j;
            }
        }
        if (j.start >= i.start && j.start <= i.end){
            if (j.end >= i.start && j.end <= i.end){
                addInterval = i;
            }
            if (j.end >= i.end){
                addInterval = new Interval(i.start, j.end);
            }
        }
        if (addInterval != null){
            intervals.get(index).start = addInterval.start;
            intervals.get(index).end = addInterval.end;
            if (!newInterval){
                intervals.remove(index + 1);
            }
            return true;
        } else {
            return false;
        }
    }

    public boolean insert(int i, List<Interval> intervals, Interval newInterval){
        if (i == 0 && newInterval.end < intervals.get(0).start){
            intervals.add(0, newInterval);
            return true;
        } else if (i != 0 && intervals.get(i - 1).end < newInterval.start && newInterval.end < intervals.get(i).start){
            intervals.add(i, newInterval);
            return true;
        } else if (i == intervals.size() - 1 && newInterval.start > intervals.get(i).end){
            intervals.add(i + 1, newInterval);
            return true;
        }
        return false;
    }
}
