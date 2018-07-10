package bambooSwords;

public class LongestCommonPrefix {
    
    
    
    // {"flower","flow","flight"}
    public String longestCommonPrefix(String[] strs) {

        if(strs == null || strs.length == 0)
            return "";
        
        if(strs.length == 1)
            return strs[0];
        
        int shortestStrLength = -1;
        for(String str : strs){
            if(shortestStrLength == -1 || str.length() < shortestStrLength)
            shortestStrLength = str.length(); 
        }
        boolean foundMisMatch = false;
        int i;
        for(i = 0 ; i < shortestStrLength ; i++) {
            char charAt = strs[0].charAt(i);
            for(int j = 1 ; j < strs.length ; j++){
                if(strs[j].charAt(i) != charAt){
                    foundMisMatch = true;
                    break;
                }
            }
            if(foundMisMatch)
                break;
        }
        
        return strs[0].substring(0, i);
        
    }

}
