package bambooSwords.sort;

public class Sort {

    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /*
    O(n*n)
    Each loop find the smallest one and lift it up the the most front position
     */
    public void bubbleSort(int[] nums) {
        if (nums == null || nums.length <= 1) return;
        for (int j = 0; j < nums.length; j++) {
            for (int i = nums.length - 1; i > j; i--) {
                if (nums[i - 1] > nums[i]) {
                    swap(nums, i - 1, i);
                }
            }
        }
    }

    /*
    O(n*n)
    Each loop select the smallest one and put it on the most front position, this method is an optimized version of bubble
    cause it decreases the times of swapping.
     */

    public void selectSort(int[] nums){
        if (nums == null || nums.length <= 1) return;
        for (int i = 0; i < nums.length; i++){
            int min = Integer.MAX_VALUE;
            int p = -1;
            for (int j = i + 1; j < nums.length; j++){
                if (min  > nums[j]){
                    min = nums[j];
                    p = j;
                }
            }
            if (nums[i] > min){
                swap(nums, i, p);
            }
        }
    }

    /*
    Playing porker! Assuming all cards we reviewed is in sequence
    O(n*n)
     */
    public void insertSort(int[] nums){
        if (nums == null || nums.length <= 1) return;
        for (int i = 0; i < nums.length; i++){
            for (int j = i; j >= 1 && nums[j] < nums[j - 1]; j--){ // nums[j] < nums[j - 1] is important as a break point
                int temp = nums[j];
                nums[j] = nums[j - 1];
                nums[j - 1] = temp;
            }

        }
    }

    /*
    select a pivot and put smaller ones to left, larger ones to the right, make sure each sub is in sequence
    O(nlgn), not stable
     */
    public void quickSort(int[] nums){
        if (nums == null || nums.length <= 1) return;
        sortSub(nums, 0, nums.length - 1);

    }

    public void sortSub(int[] nums, int l, int r){
        if (l >= r) return;
        int pivot = nums[l];
        int head = l;
        int tail = r;
        while (l < r){
            while (l < r && l <= tail && nums[l] < pivot){
                l++;
            }
            while (l < r && r >= head && nums[r] > pivot){
                r--;
            }
            if (l < r){
                swap(nums, l, r);
                l++;
                r--;
            } else if (l == r){
                l++;
            }
        }
        sortSub(nums, head, r);
        sortSub(nums, l, tail);
    }

    /*
    Remember:

    current node : index
    left child : index * 2 + 1
    right child : index * 2 + 2
    parent node : (index - 1) / 2

    first, need to know how to make a max heap. select the last parent node, and make sure each parent node is larger than children.
    after one round, the max one is the top node
     */

    public void heapSort(int[] nums){
        if (nums == null || nums.length <= 1) return;
        for (int i = nums.length - 1; i >= 0; i--){
            maxHeapify(nums, i);
            swap(nums, 0, i);
        }
    }

    public void maxHeapify(int[] nums, int length){
        if (length == 0) return;
        for (int i = (length - 1) / 2; i >= 0; i--){
            int leftIndex = 2 * i + 1;
            int rightIndex = 2 * i + 2;
            int max = nums[leftIndex];
            int index = leftIndex;

            if (rightIndex <= length && nums[rightIndex] > nums[leftIndex]){
                max = nums[rightIndex];
                index = rightIndex;
            }
            if (nums[i] < max){
                swap(nums, i, index);
            }
        }
    }

    /*
    mergeSort to find which two parts should be merged and merge is used to merge those two parts
     */
    public void mergeSort(int nums[]){
        if (nums == null || nums.length <= 1) return;
        mergeSort(nums, 0, nums.length - 1);
    }

    public void mergeSort(int[] nums, int start, int end){
        if (start >= end) return;
        int middle = (start + end) / 2;
        mergeSort(nums, start, middle);
        mergeSort(nums, middle + 1, end);
        merge(start, end, middle, nums);
    }

    public void merge(int start, int end, int mid, int[] nums){
        int[] temp = new int[end - start + 1];
        int i = 0;
        int l = start;
        int r = mid + 1;
        while (l <= mid && r <= end){
            if (nums[l] < nums[r]){
                temp[i++] = nums[l];
                l++;
            } else {
                temp[i++] = nums[r];
                r++;
            }
        }
        while (l <= mid){
            temp[i++] = nums[l++];
        }
        while (r <= end){
            temp[i++] = nums[r++];
        }
        i = 0;
        for (int j = start; j <= end; j++){
            nums[j] = temp[i++];
        }

    }

    /*
    Bucket sort is mainly useful when input is uniformly distributed over a range.
    First, generate buckets and allocate elements into buckets.
    And use quick sort to sort elements in each bucket.
     */
    public void bucketSort(int[] nums){
        if (nums == null || nums.length <= 1) return;
    }
}
