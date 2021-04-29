package educative.binarysearch;

public class NextLetter {

	private char search(char[] arr, char key) {
		int l = 0;
		int h = arr.length - 1;
		int n = arr.length;
		if (key < arr[0] && key > arr[n-1]) {
			return arr[0];
		}
		
		while (l <= h) {
			int mid = (l + h) / 2;
			if (key > arr[mid]) {
				l = mid + 1;
			} else {
				h = mid - 1;
			}

		}

		return arr[l%n];

	}
	
	public static void main(String[] args) {
		System.out.println(new NextLetter().search(new char[] {'a', 'c', 'f', 'h'}, 'f'));
		System.out.println(new NextLetter().search(new char[] {'a', 'c', 'f', 'h'}, 'b'));
	}
}
