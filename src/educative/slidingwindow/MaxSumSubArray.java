package educative.slidingwindow;

public class MaxSumSubArray {
	public static void main(String[] args) {
		System.out.println(new MaxSumSubArray().findMaxSumSubArray(3, new int[] {2,1,5,1,3,2}));
		System.out.println(new MaxSumSubArray().findMaxSumSubArray(2, new int[] {2,3, 4,1,5}));
	}
	
	private int findMaxSumSubArray(int k, int[] arr) {
		int maxSum = 0;
		int sum = 0;
		int i = 0;
		int j = 0;
		
		while (j < k) {
			sum += arr[j++]; 
		}
		
		maxSum = sum;
		while ( j < arr.length) {
			sum += arr[j++];
			sum -= arr[i++];
			maxSum = Math.max(maxSum, sum);
			
		}
		
		return maxSum;
		
	}

}
