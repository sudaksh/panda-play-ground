package bambooSwords.sort;
import bambooSwords.sort.Sort;
import org.junit.Test;

public class TestSorting {
    @Test
    public void test(){
        int[] nums = new int[]{5,6,1,3,2,1};
        Sort sort = new Sort();
        sort.bubbleSort(nums);
        System.out.println("Bubble sorting...");
        for (int i : nums){
            System.out.print(i);
        }
        System.out.println();
        System.out.println("Bubble sorting Ending...");
        System.out.println();

        int[] nums2 = new int[]{5,6,1,3,2,1};
        sort.selectSort(nums2);
        System.out.println("Select sorting...");
        for (int i : nums2){
            System.out.print(i);
        }
        System.out.println();
        System.out.println("Select sorting Ending...");
        System.out.println();

        int[] nums3 = new int[]{5,6,1,3,2,1};
        sort.insertSort(nums3);
        System.out.println("Insert sorting...");
        for (int i : nums3){
            System.out.print(i);
        }
        System.out.println();
        System.out.println("Insert sorting Ending...");
        System.out.println();

        int[] nums4 = new int[]{5,6,1,3,2,1,1,5,5,6};
        sort.quickSort(nums4);
        System.out.println("Quick sorting...");
        for (int i : nums4){
            System.out.print(i);
        }
        System.out.println();
        System.out.println("Quick sorting Ending...");
        System.out.println();

        int[] nums5 = new int[]{5,6,1,3,2,1,1,5,5,6,10,2,8,9,5};
        sort.heapSort(nums5);
        System.out.println("Heap sorting...");
        for (int i : nums5){
            System.out.print(i);
        }
        System.out.println();
        System.out.println("Heap sorting Ending...");
        System.out.println();

        int[] nums6 = new int[]{5,6,1,3,2,1,1,5,5,6,10,2,8,9,5};
        sort.mergeSort(nums6);
        System.out.println("Merge sorting...");
        for (int i : nums6){
            System.out.print(i);
        }
        System.out.println();
        System.out.println("Merge sorting Ending...");
        System.out.println();
    }

}
