package educative.slidingwindow;

public class ReplacingOnes {

	private int findLengh(int[] arr, int k) {
		int windowStart = 0, maxOnesCount = 0, maxLength = 0;

		for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
			int num = arr[windowEnd];
			if (num == 1) {
				maxOnesCount++;
			}
			
			if (windowEnd - windowStart + 1 - maxOnesCount > k) {
				if (arr[windowStart] == 1) {
					maxOnesCount--;
				}

				windowStart++;
			}

			maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
		}

		return maxLength;
	}

	public static void main(String[] args) {
		System.out.println(new ReplacingOnes().findLengh(new int[] { 0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1 }, 2));
	}
}
