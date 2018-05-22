package bambooSwords;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LongestPalindromicSubstringUnitTest {

    
    private LongestPalindromicSubstring palindromicSubstring;
    
    @Before
    public void setup(){
        palindromicSubstring = new LongestPalindromicSubstring();
    }
    
    @Test
    public void testLongestPalindrome(){
        String output = palindromicSubstring.longestPalindrome("babad");
        Assert.assertTrue(output.equals("bab") || output.equals("aba"));
    }
    
    @Test
    public void testLongestPalindrome2(){
        String output2 = palindromicSubstring.longestPalindrome("cbbd");
        Assert.assertTrue(output2.equals("bb"));
    }
    
    @Test
    public void testLongestPalindrome3(){
        String output3 = palindromicSubstring.longestPalindrome("bb");
        Assert.assertTrue(output3.equals("bb"));
    }
    
    @Test
    public void testLongestPalindrome4(){
        String output4 = palindromicSubstring.longestPalindrome("ccc");
        Assert.assertTrue(output4.equals("ccc"));
    }
    
    @Test
    public void testLongestPalindrome5(){
        String output4 = palindromicSubstring.longestPalindrome("azwdzwmwcqzgcobeeiphemqbjtxzwkhiqpbrprocbppbxrnsxnwgikiaqutwpftbiinlnpyqstkiqzbggcsdzzjbrkfmhgtnbujzszxsycmvipjtktpebaafycngqasbbhxaeawwmkjcziybxowkaibqnndcjbsoehtamhspnidjylyisiaewmypfyiqtwlmejkpzlieolfdjnxntonnzfgcqlcfpoxcwqctalwrgwhvqvtrpwemxhirpgizjffqgntsmvzldpjfijdncexbwtxnmbnoykxshkqbounzrewkpqjxocvaufnhunsmsazgibxedtopnccriwcfzeomsrrangufkjfzipkmwfbmkarnyyrgdsooosgqlkzvorrrsaveuoxjeajvbdpgxlcrtqomliphnlehgrzgwujogxteyulphhuhwyoyvcxqatfkboahfqhjgujcaapoyqtsdqfwnijlkknuralezqmcryvkankszmzpgqutojoyzsnyfwsyeqqzrlhzbc");
        Assert.assertTrue(output4.equals("sooos"));
    }
    
    
}
