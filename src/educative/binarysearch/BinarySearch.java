package educative.binarysearch;

public class BinarySearch {
	
	private int search(int[] arr, int key) {
		int l = 0;
		int h = arr.length - 1;
		
		while (l <= h) {
			int mid = (l + h)/2;
			if (arr[mid] == key) {
				return mid;
			}
			
			if (arr[l] < arr[h]) {
				// ascending
				if (key > arr[mid]) {
					l = mid + 1;
				} else {
					h = mid - 1;
				}
			} else {
				// descending
				if (arr[mid] < key) {
					l = mid - 1;
				} else {
					h = mid + 1;
				}
			}
			
		}
		
		return -1;
		
	}
	
	public static void main(String[] args) {
		System.out.println(new BinarySearch().search(new int[] {4, 6, 10}, 10));
		System.out.println(new BinarySearch().search(new int[] {1, 2, 3, 4, 5, 6, 7}, 5));
	}
	
	

}
