package bambooSwords;

public class KthLargestNumber {
	
	
	public int findLargest(int[] input, int k) {
		
		findElement(input , 0 , input.length -1 , input.length - k) ;
		return input[input.length - k];
	}

	private void findElement(int[] input, int left, int right, int desiredIndex) {
		if(left < right) {
			int pivot = right;
			int partitionIndex = partition(input , left , right -1, input[pivot]);
			swap(input, partitionIndex, pivot);
			if(desiredIndex == partitionIndex) {
				return;
			} else if (desiredIndex < partitionIndex){
				findElement(input, left, partitionIndex -1, desiredIndex);				
			} else {
				findElement(input, partitionIndex+1, right, desiredIndex);
			}
		}
	}

	private int partition(int[] input, int left, int right, int pivotValue) {
		while(left <= right) {
			while(input[left] < pivotValue) {
				left++;
			}
			
			while(input[right] >= pivotValue) {
				right--;
			}
			
			if(left< right) {
				swap(input , left , right);
			}
		}
		return left;
	}

	private void swap(int[] input, int left, int right) {
		int temp = input[left];
		input[left] = input[right];
		input[right] = temp;
	}

}
