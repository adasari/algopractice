package sort;

public class QuickSort {
	public static void main(String[] args) {
		int[] nums = new int[] {1,5,3, 7,6, 9,8,4,2};
		quickSort(nums, 0, nums.length-1);
		print(nums, 0, nums.length);
	}
	
	
	
	private static void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	
	private static int partition(int[] nums, int low, int high) {
		int pivotIndex = (low + high)/2;
		// move the pivot element to last
		swap(nums, pivotIndex, high);
		
		int i = low;
		for (int j = low; j < high; j++) {
			if (nums[j] <= nums[high]) {
				swap(nums, i, j);
				i++;
			}
		}
		
		swap(nums, i, high);
		
		return i;
	}
	
	private static void quickSort(int[] nums, int low, int high) {
		if (low >= high) {
			return;
		}
		
		int pivot = partition(nums, low, high);
		quickSort(nums, low, pivot-1);
		quickSort(nums, pivot+1, high);
	}
	
	private static void print(int[] a, int start, int end) {
		for (int i = start; i < end; ++i) {
            System.out.print(a[i] + " ");
        }
		System.out.println();
	}
	
}
