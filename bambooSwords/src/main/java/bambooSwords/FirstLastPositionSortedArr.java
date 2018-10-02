package bambooSwords;

public class FirstLastPositionSortedArr {

	public int[] searchRange(int[] nums, int target) {

		int firstIndexFound = searchBinary(nums , 0, nums.length-1,target);
		if(firstIndexFound == -1) {
			return new int[] {-1,-1};
		} else {
			int startingIndex = firstIndexFound;
			while(startingIndex >0 && nums[startingIndex-1] == target) {
				startingIndex--;
			}
			int endingIndex = firstIndexFound;
			while(endingIndex < nums.length-1 && nums[endingIndex+1] == target) {
				endingIndex++;
			}
			return new int [] {startingIndex,endingIndex};
		}

	}

	private int searchBinary(int[] nums, int left, int right, int target) {
		if(left > right) {
			return -1;
		}
		int middle = (left + right)/2;
		if(nums[middle] == target) {
			return middle;
		} else if(nums[middle] > target) {
			return searchBinary(nums, left, middle - 1, target);
		} else {
			return searchBinary(nums, middle + 1, right, target);
		}
	}

}
