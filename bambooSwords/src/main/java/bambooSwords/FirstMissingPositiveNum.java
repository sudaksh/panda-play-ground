package bambooSwords;

import java.util.HashSet;
import java.util.Set;

public class FirstMissingPositiveNum {
	
	// [3,4,-1,1]
	// 2
	
	// [2,1,0]
	// 3
	
	// [1,2,3,5,8,6,9,7,10,15,13,14,12,11]
	// 4
	
    public int firstMissingPositive(int[] nums) {

    	Set<Integer> numSet = new HashSet<>();
    	for(int i : nums) {
    		if(i > 0) {
    			numSet.add(i);
    		}
    	}
    	int result = 1;
    	
    	while(numSet.contains(result)) {
    		result++;
    	}
    	return result;
    }
    
    
    
	// [1,2,3,5,8,6,9,7,10,15,13,14,12,11]
	// [3,4,-1,1]


    public int firstMissingPositive2(int[] nums) {
    	
    	
    	
    	
    	
    	
    	return 1;
    }

}
