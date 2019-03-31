package bambooSwords.BfsDfsTree;

import java.util.HashMap;

/*
There are N network nodes, labelled 1 to N.

Given times, a list of travel times as directed edges times[i] = (u, v, w), where u is the source node, v is the target node, and w is the time it takes for a signal to travel from source to target.

Now, we send a signal from a certain node K. How long will it take for all nodes to receive the signal? If it is impossible, return -1.

Note:
N will be in the range [1, 100].
K will be in the range [1, N].
The length of times will be in the range [1, 6000].
All edges times[i] = (u, v, w) will have 1 <= u, v <= N and 1 <= w <= 100.
 */
public class NetworkDelayTime {
    public int networkDelayTime(int[][] times, int N, int K) {
        if (times == null || times[0].length == 0) return 0;
        HashMap<Integer, Integer> link = new HashMap<>();
        HashMap<Integer, int[]> value = new HashMap<>();
        for (int[] i : times){
            link.put(i[0], i[1]);
            value.put(i[0], i);
        }
        int res = 0;
        int total = N;
        int cur = 1;
        while (total >= 0){
            if (!link.containsKey(cur)){
                return -1;
            } else {
                res = res + value.get(cur)[2];
                total--;
                cur = link.get(cur);
            }
        }
        return res;
    }
}
