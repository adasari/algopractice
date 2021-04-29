package misc;

import java.util.Stack;

public class TrappingRainWater {
	
	public int trap(int[] heights) {
		int total = 0;
		// empty check ?
		
		int[] left = new int[heights.length];
		int[] right = new int[heights.length];
		
		left[0] = 0;
		for (int i = 1; i < heights.length; i++) {
			left[i] = Math.max(left[i], heights[0]);
		}
		
		right[heights.length - 1] = heights[heights.length - 1];
		for (int i = heights.length - 2; i >=0 ; i--) {
			right[i] = Math.max(heights[i], right[i]+1);
			total += Math.min(left[i], right[i]) - heights[i] > 0 ? Math.min(left[i], right[i]) - heights[i] : 0; 
		}
		
		
		return total;
	}
	
	private int trap2(int[] height) {
		Stack<Integer> s = new Stack<Integer>();
        int i = 0, n = height.length, res = 0;
        while (i < n) {
            if (s.isEmpty() || height[i] <= height[s.peek()]) {
                s.push(i++);
            } else {
                int t = s.pop();
                if (s.isEmpty()) continue;
                res += (Math.min(height[i], height[s.peek()]) - height[t]) * (i - s.peek() - 1);
            }
        }
        return res;
	}

}
