package bambooSwords;

import java.util.Arrays;
import java.util.HashMap;

public class LongestSubstringWithoutRepeating {

    /*
    Sliding window (first step test and final step test needed)

    O(n)

    Note:
    eg: tmmzuxt
    when deal with the second m, remember don't count the first t because it is not a showed one anymore in the new string
     */
    public int lengthOfLongestSubstring(String s){
        if (s == null || s.length() == 0) return 0; // first test!
        if (s.length() == 1) return 1;
        int result = 0;
        int first = 0;

        HashMap<Character, Integer> position = new HashMap<>();
        for (int i = 0; i < s.length(); i++){
            Character c = s.charAt(i);
            if (position.containsKey(c)){
                if (position.get(c) >= first){ // only calculate length when meet the first character from the string, don't count the one before it
                    result = Math.max(result, i - first);
                    first = position.get(c) + 1;
                }
            }
            position.put(c, i);
        }
        if (first != s.length()) result = Math.max(result, s.length() - first); // final step test!
        return result;
    }

    /*
    Faster method by using array to record positions

    Note: Characters, 256!
     */

    public int lengthOfLongestSubstring2(String s){
        if (s == null || s.length() == 0) return 0; // first test!
        if (s.length() == 1) return 1;
        int result = 0;
        int first = 0;

        int[] map = new int[256];
        Arrays.fill(map, -1); // good to use
        for (int i = 0; i < s.length(); i++){
            Character c = s.charAt(i);
            if (map[c] >= first) { // map[character]
                result = Math.max(result, i -first);
                first = map[c] + 1;
            }
            map[c] = i;
        }

        if (first != s.length()) result = Math.max(result, s.length() - first);
        return result;
    }
}
