package bambooSwords;

public class QuickSort {
	
//	{1,5,3,8,6,2,2,9,11,20,4,5}
	public void sort1(int[] input) {
		quickSort(input , 0 , input.length -1);
	}

	private void quickSort(int[] input, int left, int right) {
		if(left < right) {
			int pivot = (left + right) /2;
			int partitionIndex = partition(input , left , right , input[pivot]);
			quickSort(input, left, partitionIndex -1);
			quickSort(input, partitionIndex, right);
		}
	}

	private int partition(int[] input, int left, int right, int pivotValue) {
		while(left <= right) {
			while(input[left] < pivotValue) {
				left++;
			}
			
			while(input[right] > pivotValue) {
				right--;
			}
			if(left <= right) {
				swap(input,left , right);
				left++;
				right--;
			}
		}
		
		return left;
	}

	private void swap(int[] input, int left, int right) {
		int temp = input[left];
		input[left] = input[right];
		input[right] = temp;
	}

	public void sort2(int[] input) {
		
		sort2(input , 0, input.length -1);
		
	}

	private void sort2(int[] input, int left, int right) {
		if(left < right) {
			int pivot = right;
			int partitionIndex = partition2(input,left,right-1,input[pivot]);
			swap(input, partitionIndex, pivot);
			sort2(input,left,partitionIndex-1);
			sort2(input,partitionIndex+1,right);
		}
	}

	private int partition2(int[] input, int left, int right, int pivotValue) {
		while(left <= right) {
			while(input[left] < pivotValue) {
				left++;
			}
			
			while(input[right] > pivotValue) {
				right--;
			}
			if(left < right) {
				swap(input, left, right);
				left++;
				right--;
			}
			
		}
		return left;
	}

}
