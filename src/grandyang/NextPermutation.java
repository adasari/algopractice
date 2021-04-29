package grandyang;

public class NextPermutation {
	/*

1) scan from right to left, find the first element that is less than its previous one.
4 5 6 3 2 1 
  |
  p
 
2) scan from right to left, find the first element that is greater than p.

4 5 6 3 2 1 
    |
    q

3) swap p and q

4 5 6 3 2 1 
swap
4 6 5 3 2 1 

4) reverse elements [p+1, nums.length]

4 6 1 2 3 5 
 
	 
	 */
	
	public static void main(String[] args) {
		
	}
	
	
	private int[] findNext(int[] nums) {
		int length = nums.length;
		
		int p = -1;
		int q = -1;
		for (int i = 0; i < length-1; i++) {
			if (nums[i] <= nums[i+1]) {
				p = i;
				break;
			}
		}
		
		if (p == -1) {
			reverse(nums, 0, length-1);
			// new String()
			return nums;
		}
		
		for (int j = p+1; j < length; j++) {
			if (nums[j] > nums[p]) {
				q = j;
				break;
			}
		}
		
		if (q != -1) {
			swap(nums, p, q);
		}
		
		reverse(nums, p+1, length-1);
		
		return nums;
	}

	private void reverse(int[] nums, int i, int length) {
		// TODO Auto-generated method stub
		
	}

	private void swap(int[] nums, int p, int q) {
		// TODO Auto-generated method stub
		
	}

}
