package bambooSwords;

public class SearchSortedRotatedArray {

	public int search(int[] nums, int target) {
		if(nums == null || nums.length == 0)
			return -1;

		int pivot = findPivot(nums);

		int result = searchBinary(nums,0,pivot,target);
		if(result == -1) {
			result = searchBinary(nums, pivot+1, nums.length -1 ,target);
		}


		return result;

	}

	private int searchBinary(int[] nums, int left, int right, int target) {

		if(left > right) {
			return -1;
		}

		int middle = (left + right)/2;
		if(nums[middle] == target) {
			return middle;
		} else if(nums[middle] < target) {
			return searchBinary(nums, middle+1, right, target);
		} else {
			return searchBinary(nums, left, middle -1, target);
		}
	}

	private int findPivot(int[] nums) {
		if(nums.length == 1)
			return 0;

		return findPivot(nums, 0 , nums.length - 1);

	}

	private int findPivot(int[] nums, int left, int right) {
		int middle = (left + right) / 2;

		if(nums[middle+1] < nums[middle])
			return middle;


		int leftValue = nums[left];
		int rightValue = nums[right];


		if(nums[middle] < leftValue) {
			return findPivot(nums, left, middle);
		} else if (nums[middle] > rightValue) {
			return findPivot(nums, middle, right);
		}

		return 0;
	}


}
