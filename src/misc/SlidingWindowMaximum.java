package misc;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMaximum {

	// incomplete
	public int[] maxSlidingWindow(int[] nums, int k) {
		if (nums == null || nums.length == 1 || k == 1 || nums.length < k) return nums;
		int[] result = new int[nums.length];
		int j = 0;
		
		Deque<Integer> dq = new ArrayDeque<Integer>();
		for (int  i = 0; i < nums.length; i++) {
			// dq is in descending order (invariant)     
			while (dq.size() > 0 && nums[i] >= nums[dq.getLast()]) {
				dq.pollLast();
			}
			
			// push the index of current element to the deque
			dq.push(i);
			
			// Remove elements out of window
			if (dq.getFirst() == i-k) {
				dq.pollFirst();
			}
			
			if (i >= k-1) {
				result[j++] = nums[dq.getFirst()];
			}
		}
		
		
		return result;
	}

}
