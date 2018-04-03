package bambooSwords;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class AlgoBank {

    public int getLongestSubstringLengthBrute(String input) {


        PriorityQueue<Integer> subStringLengths = new PriorityQueue<Integer>((x,y) -> y-x);

        for(int i=0 ; i < input.length() ; i++){
            Set<Character> temp = new HashSet<Character>();
            int subStringLength = 0;
            for(int j= i; j < input.length() ; j++){
                char charAt = input.charAt(j);
                if(temp.contains(charAt)){
                    break;
                }
                temp.add(charAt);
                subStringLength++;
            }
            subStringLengths.add(subStringLength);

            if(i== 0 && subStringLength == input.length()){
                break;
            }

        }

        Integer maxLength = subStringLengths.poll();
        return maxLength == null ? 0 : maxLength;
    }

    public int getLongestSubstringLengthSliding1(String input) {

        int maxLength = 0;
        int i = 0;
        int j = 0;
        
        while(j < input.length()){
            Map<Character,Integer> temp = new HashMap<>();
            int subStringLength = 0;
            
            for(j= i; j < input.length() ; j++){
                char charAt = input.charAt(j);
                if(temp.containsKey(charAt)){
                    i = temp.get(charAt) + 1;
                    break;
                }
                temp.put(charAt,j);
                subStringLength++;
            }
            
            maxLength = Math.max(maxLength, subStringLength);
        }
        
        return maxLength;
    }
    
    
    public int getLongestSubstringLengthSliding2(String input) {
        if(input == null || input.length() == 0){
            return 0;
        }
        Map<Character,Integer> slidingWindowMap = new HashMap<>();
        Integer maxLength = 1;
        for(int i = 0 , j=0 ; j < input.length() ; j++){
            char charAt = input.charAt(j);
            if(slidingWindowMap.containsKey(charAt) && slidingWindowMap.get(charAt) >= i){
                maxLength = Math.max(maxLength, j - i);
                i = slidingWindowMap.get(charAt) + 1;
            } else if (j == input.length() -1){
                maxLength = Math.max(maxLength, j + 1 - i);
            }
            slidingWindowMap.put(charAt, j);
        }
        
        return maxLength;
        
    }
    
    
    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        
        int i =0 ,j =0 ,k =0;
        int[] combined = new int[nums1.length + nums2.length];
        
        while(i < nums1.length && j < nums2.length){
            if(nums1[i] < nums2[j]){
                combined[k] = nums1[i];
                i++;
            } else {
                combined[k] = nums2[j];
                j++;
            }
            k++;
        }
        
        if(i == nums1.length){
            while(k<combined.length){
                combined[k] = nums2[j];
                j++;
                k++;
            }
        } else if (j == nums2.length){
            while(k<combined.length){
                combined[k] = nums1[i];
                i++;
                k++;
            }
        }
        if(combined.length % 2 == 0){
            // even count
            return (combined[combined.length/2] + combined[(combined.length/2) -1]) /2.0 ;
        } else {
            return combined[combined.length/2];
        }
    }
    
    
//    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
//
//        int i =0 ,j =0 ,k =0 , kmax;
//        int median1 , median2;
//        kmax = (nums1.length + nums2.length) / 2;
//
//        while(i < nums1.length && j < nums2.length){
//            if(nums1[i] < nums2[j]){
//                if(k == kmax){
//                    return nums1[i];
//                    
//                }
//                
//                i++;
//            } else {
//                
//                if(k == kmax){
//                    return nums2[j] ;
//                }
//                j++;
//            }
//            k++;
//        }
//        
//        if(i == nums1.length){
//            while(k<=kmax){
////                combined[k] = nums2[j];
//                j++;
//                k++;
//                if(k == kmax){
//                    return nums2[j] ;
//                }
//            }
//        } else if (j == nums2.length){
//            while(k<=kmax){
////                combined[k] = nums1[i];
//                i++;
//                k++;
//                if(k == kmax){
//                    return nums2[i] ;
//                }
//            }
//        }
//
//
//    }


    
    

}
