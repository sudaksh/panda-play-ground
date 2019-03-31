package bambooSwords.sort;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class HIndex {
    public int hIndex(int[] citations) {
        List<Integer> list = IntStream.of(citations).boxed().collect(Collectors.toList());
        Collections.sort(list, Collections.reverseOrder());
//        int i = 0;
//        while (i < list.size() && list.get(i) >= i + 1){
//            i++;
//        }
        int l = 0;
        int r = list.size() - 1;
        while (l < r){
            int mid = (l + r) / 2;
            if (list.get(mid) >= mid + 1){
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
}
