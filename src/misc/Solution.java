package misc;

public class Solution {
	
	public static void main(String[] args) {
		Solution.solution(new long[] {1,4,100,5});
	}
	
	public static String solution(long[] arr) {
		if (arr.length <= 1)
			return "";

		long leftSum = sum(arr, 2);
		long rightSum = sum(arr, 3);

		System.out.println("left : "+ leftSum);
		System.out.println("right : "+ rightSum);
		
		return leftSum == rightSum ? "" : ((leftSum > rightSum) ? "Left" : "Right");

	}

	private static long sum(long[] arr, int idx) {
		if (idx-1 < arr.length) {
			if (arr[idx-1] == -1)
				return 0L;
			return arr[idx-1] + sum(arr, idx * 2) + sum(arr, idx * 2 + 1);
		}

		return 0L;
	}

}
