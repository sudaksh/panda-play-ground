package bambooSwords;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneNumberLetterCombos {
    
    private Map<Character, List<Character>> numPad;
    
    public PhoneNumberLetterCombos() {
        numPad = new HashMap<>();
        numPad.put('1', new ArrayList<>());
        numPad.put('2', Arrays.asList('a','b','c'));
        numPad.put('3', Arrays.asList('d','e','f'));
        numPad.put('4', Arrays.asList('g','h','i'));
        numPad.put('5', Arrays.asList('j','k','l'));
        numPad.put('6', Arrays.asList('m','n','o'));
        numPad.put('7', Arrays.asList('p','q','r','s'));
        numPad.put('8', Arrays.asList('t','u','v'));
        numPad.put('9', Arrays.asList('w','x','y','z'));


    }
    
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if(digits == null || digits.length() == 0)
            return result;
        List<Character> temp = new ArrayList<>();
        populateStrings(digits , temp , result);
        return result;
    }

    private void populateStrings(String digits, List<Character> temp, List<String> result) {
        if(digits.length() == 0){
            char[] chars = new char[temp.size()];
            for(int i = 0 ; i < temp.size(); i++){
                chars[i] = temp.get(i);
            }
            result.add(String.valueOf(chars));
            return;
        }
        Character firstChar = digits.charAt(0);
        List<Character> chars = numPad.get(firstChar);
        for(Character ch : chars){
            temp.add(ch);
            populateStrings(digits.substring(1), temp, result);
            temp.remove(temp.size()-1);
        }
    }


}
