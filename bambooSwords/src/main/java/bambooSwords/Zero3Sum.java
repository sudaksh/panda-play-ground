package bambooSwords;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Zero3Sum {
    
//    [-1, 0, 1, 2, -1, -4]
    
//    [
//     [-1, 0, 1],
//     [-1, -1, 2]
//    ]
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0 ; i < nums.length ; i++){
            int zeroDiff = -(nums[i]);
            Set<Integer> cache = new HashSet<>();
            for(int j = i+1 ; j < nums.length ; j++){
                if(cache.contains(zeroDiff - nums[j])){
                    // found one solution
                    List<Integer> solution = new ArrayList<>();
                    solution.add(nums[i]);
                    solution.add(nums[j]);
                    solution.add(zeroDiff - nums[j]);
                    result.add(solution);
                }
                cache.add(nums[j]);
            }
        }
        
        
        return result;
        
    }

}
