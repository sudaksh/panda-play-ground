package bambooSwords.array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class FindDupTest {
    @Test
    public void test(){
        FindDup findDup = new FindDup();
        int[] nums = {1,3,4,2,2};
        System.out.print(findDup.findDuplicate2(nums));

    }

    @Test
    public void test2(){
        FindAllDup findAllDup = new FindAllDup();
        int[] nums = {4,3,2,7,8,2,3,1};
        List<Integer> res = findAllDup.findDuplicates(nums);
        for (int i : res){
            System.out.print(i + " ");

        }
    }
}
