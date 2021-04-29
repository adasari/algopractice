package educative.binarysearch;

public class SmallestCielingNumber {

	private int search(int[] arr, int key) {
		int l = 0;
		int h = arr.length - 1;

		while (l <= h) {
			int mid = (l + h) / 2;
			if (arr[mid] == key) {
				return key;
			}

			// ascending
			if (key > arr[mid]) {
				l = mid + 1;
			} else {
				h = mid - 1;
			}

		}

		return arr[l];

	}
	
	public static void main(String[] args) {
		System.out.println(new SmallestCielingNumber().search(new int[] {4, 6, 10}, 10));
		System.out.println(new SmallestCielingNumber().search(new int[] {1, 2, 3,  5, 6, 7}, 4));
	}

}
