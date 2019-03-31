package bambooSwords.BfsDfsTree;

import java.util.*;

/*
You have a lock in front of you with 4 circular wheels. Each wheel has 10 slots: '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'. The wheels can rotate freely and wrap around: for example we can turn '9' to be '0', or '0' to be '9'. Each move consists of turning one wheel one slot.

The lock initially starts at '0000', a string representing the state of the 4 wheels.

You are given a list of deadends dead ends, meaning if the lock displays any of these codes, the wheels of the lock will stop turning and you will be unable to open it.

Given a target representing the value of the wheels that will unlock the lock, return the minimum total number of turns required to open the lock, or -1 if it is impossible.

Example 1:
Input: deadends = ["0201","0101","0102","1212","2002"], target = "0202"
Output: 6
Explanation:
A sequence of valid moves would be "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202".
Note that a sequence like "0000" -> "0001" -> "0002" -> "0102" -> "0202" would be invalid,
because the wheels of the lock become stuck after the display becomes the dead end "0102".
 */
public class OpenTheLock {
    public int openLock(String[] deadends, String target) {
        HashSet<String> set = new HashSet<>();
        HashSet<String> seen = new HashSet<>();
        set.addAll(Arrays.asList(deadends));
        if (set.contains(target) || set.contains("0000")) return -1;
        Queue<String> que = new LinkedList<>();
        que.offer("0000");
        seen.add("0000");
        int size = 1;
        int step = 0;

        while (!que.isEmpty()){
            String cur = que.poll();
            size--;
            if (cur.equals(target)) return step;
            for (int i = 0; i < 4; i++){
                String s1 = goUp(cur, i);
                if (seen.add(s1) && !set.contains(s1)){
                    que.offer(s1);
                }
                String s2 = goDown(cur, i);
                if (seen.add(s2) && !set.contains(s2)){
                    que.offer(s2);
                }
            }
            if (size == 0){
                size = que.size();
                step++;
            }
        }

        return -1;
    }
    public String goUp(String s, int index){
        char[] chars = s.toCharArray();
        if (chars[index] == '9'){
            chars[index] = '0';
            return new String(chars);
        }
        int c = Integer.valueOf(chars[index]) + 1;
        chars[index] = (char) c;
        return new String(chars);
    }

    public String goDown(String s, int index){
        char[] chars = s.toCharArray();
        if (chars[index] == '0'){
            chars[index] = '9';
            return new String(chars);
        }
        int c = Integer.valueOf(chars[index]) - 1;
        chars[index] = (char) c;
        return new String(chars);
    }
}
