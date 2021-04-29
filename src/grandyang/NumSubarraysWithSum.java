package grandyang;

public class NumSubarraysWithSum {
	
	public static void main(String[] args) {
		new NumSubarraysWithSum().numSubarraysWithSum(new int[] {1,0,1,0,1}, 2);
	}

	public int numSubarraysWithSum(int[] A, int S) {
		int result = 0;
		
		int left = 0, right = 0;
		
		int currentSum = 0;
		for (right = 0; right < A.length; right++) {
			currentSum += A[right];
			if (currentSum == S) {
				result++;
			}
			
			while (currentSum > S) {
				currentSum = currentSum - A[left++];
			}
		}
		
		System.out.println(result);
		return result;
	}

}
