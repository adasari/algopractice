package educative.slidingwindow;

public class SmallestSubarraySum {
	public static void main(String[] args) {
		new SmallestSubarraySum().findMinSubArray(7, new int[] {2, 1, 5, 2, 3, 2});
		new SmallestSubarraySum().findMinSubArray(7, new int[] {2, 1, 5, 2, 8});
		new SmallestSubarraySum().findMinSubArray(8, new int[] {3, 4, 1, 1, 6});
	}
	
	private int findMinSubArray(int S, int[] arr) {
		int windowStart = 0, windowEnd = 0;
		int sum = 0;
		int minLength = arr.length;

		for (windowEnd = 0; windowEnd < arr.length; windowEnd++) {
			sum += arr[windowEnd];

			while (sum >= S) {
				minLength = Math.min(minLength, windowEnd - windowStart + 1);
				sum -= arr[windowStart];
				windowStart++;
			}
		}
		
		System.out.println(minLength);
		return minLength;
	}
}
