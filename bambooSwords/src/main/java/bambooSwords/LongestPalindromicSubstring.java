package bambooSwords;

import java.util.ArrayList;
import java.util.List;

public class LongestPalindromicSubstring {
    
    private class Pair{
        int start , end;
        public Pair(int s , int e){
            start = s;
            end  = e;
        }
    }
    
    
    public String longestPalindrome(String string) {
        if(string == null)
            return null;
        if(string.length() == 1)
            return string;
        if(string.length() == 2)
            return string.charAt(0) == string.charAt(1) ? string : null;
        
        int[][] palindromeResults = new int[string.length()][string.length()];
        List<Pair> results = new ArrayList<>();
        
        int size = string.length();
        
        for (int palMarker = 1; palMarker < size  ; palMarker++){
            
            for(int j = palMarker ; j < size  ; j++){
                boolean isPal = isPalindrome(string, j - palMarker , j , palindromeResults);
                if(isPal){
                    results.add(new Pair(j-palMarker , j));
                    break;
                }
            }
        }
        
        if(results.size() > 0){
            Pair longestPair = results.get(results.size() - 1);
            return string.substring(longestPair.start, longestPair.end + 1);
            
        } else {
            return string.substring(0, 1);
        }
    }
    
    
    
    private boolean isPalindrome(String string , int i , int j, int[][] palindromeResults){
        if(palindromeResults[i][j] == 1 ){
            return true;
        } else if ( palindromeResults[i][j] == -1){
            return false;
        }
        boolean isPalindrome;
        if(i == j){
            isPalindrome = true;
        } else if(j == i+1){
            isPalindrome = string.charAt(i) == string.charAt(j);
        } else if(isPalindrome(string, i+1, j-1 , palindromeResults) && string.charAt(i) == string.charAt(j)){
            isPalindrome = true;
        } else {
            isPalindrome = false;
        }
        palindromeResults[i][j] = isPalindrome ? 1 : -1;
        return isPalindrome;
    }

}
