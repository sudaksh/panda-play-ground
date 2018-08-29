package bambooSwords;

import org.junit.Test;

public class testLongestPalindrome {

    @Test
    public void test(){
        LongestPalindrome method = new LongestPalindrome();
        String s1= "abcd";
        String result = method.longestPalindrome(s1);
        System.out.println(result);

    }
}
