package bambooSwords;

public class LongestPalindrome {
    public String longestPalindrome(String s) {
        if (s == null || s.length() <= 1) return s;
        int[] result = new int[]{0,0};
        for (int i = 1; i < s.length(); i++){
            int[] tempA = findLongestPalindromeByKnowingCenter(i - 1, i + 1, s);
            int[] tempB = findLongestPalindromeByKnowingCenter(i - 1, i, s);
            int[] temp =  tempA[1] - tempA[0] >= tempB[1] - tempB[0] ? tempA : tempB;
            result = temp[1] - temp[0] >= result[1] - result[0] ? temp : result;
        }
        return s.substring(result[0], result[1] + 1);
    }

    public int[] findLongestPalindromeByKnowingCenter(int l, int r, String s){
        while (l >= 0 && r < s.length()){
            if (s.charAt(l) == s.charAt(r)){
                l--;
                r++;
            } else {
                return new int[]{l + 1, r - 1};
            }
        }
        return new int[]{l + 1, r - 1};

    }
}
