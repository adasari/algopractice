package misc;

public class FindSmallLargeDiff {
	
	
	private int findSmallLargeDifference(int size, int[] nums) {
		if (size <= 2) return 0;
		
		int min = nums[0];
		int max = nums[0];
		int secondMax = nums[0];
		
		for (int i = 0; i < size; i++) {
			if (nums[i] < min) {
				min = nums[i];
			} else if (nums[i] > max){
				secondMax = max;
				max = nums[i];
			}else if (nums[i] > secondMax) {
				secondMax = nums[i];
			}
		}
		
		System.out.printf("%d %d %d\n", min, max, secondMax);
		return (max - min) - (max - secondMax);
		
	}
	
	
	
	public static void main(String[] args) {
		 System.out.println(new FindSmallLargeDiff().findSmallLargeDifference(5, new int[]{10, 11, 7, 12, 14}));
	}

}
