package bambooSwords;

import java.util.Arrays;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s == null){
            return t == null;
        }
        if (s.length() != t.length()) return false;
        char[] sChars = s.toCharArray();
        Arrays.sort(sChars);
        char[] tChars = t.toCharArray();
        Arrays.sort(tChars);
        for (int i = 0; i < sChars.length; i++){
            if (sChars[i] != tChars[i]) return false;
        }
        return true;
    }
}
