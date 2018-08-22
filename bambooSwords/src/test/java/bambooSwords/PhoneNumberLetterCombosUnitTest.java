package bambooSwords;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class PhoneNumberLetterCombosUnitTest {
    
    private PhoneNumberLetterCombos letterCombos;
    
    @Before
    public void setup() {
        letterCombos = new PhoneNumberLetterCombos();
    }
    
    @Test
    public void testLetterCombinations(){
        
        List<String> output = letterCombos.letterCombinations("234");
        System.out.println(output);
        
    }

}
