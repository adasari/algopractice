package misc;

import java.util.Arrays;

public class VideoStitching {
	/*

1024. Video Stitching

You are given a series of video clips from a sporting event that lasted T seconds.  These video clips can be overlapping with each other and have varied lengths.

Each video clip clips[i] is an interval: it starts at time clips[i][0] and ends at time clips[i][1].  We can cut these clips into segments freely: for example, a clip [0, 7] can be cut into segments [0, 1] + [1, 3] + [3, 7].

Return the minimum number of clips needed so that we can cut the clips into segments that cover the entire sporting event ([0, T]).  If the task is impossible, return -1.

 

Example 1:

Input: clips = [[0,2],[4,6],[8,10],[1,9],[1,5],[5,9]], T = 10
Output: 3
Explanation: 
We take the clips [0,2], [8,10], [1,9]; a total of 3 clips.
Then, we can reconstruct the sporting event as follows:
We cut [1,9] into segments [1,2] + [2,8] + [8,9].
Now we have segments [0,2] + [2,8] + [8,10] which cover the sporting event [0, 10].
Example 2:

Input: clips = [[0,1],[1,2]], T = 5
Output: -1
Explanation: 
We can't cover [0,5] with only [0,1] and [1,2].

*/
	
	

	// o(nlongn)
	public int videoStitchingDP(int[][] clips, int T) {
		int[] dp = new int[101]; // or int[T+1]
		Arrays.fill(dp, Integer.MAX_VALUE);
		Arrays.sort(clips, (a, b) -> Integer.compare(a[0], b[0]));
		
		dp[0] = 0;
		for (int[] clip : clips) {
			int s = clip[0];
			int e = clip[1];
			
			if (s >= T) break;
			
			for (int i = s; i<=e; i++) {
				dp[i] = Math.min(dp[i], dp[s] + 1);
				
				if (i == T) return dp[T];
			}
		}
		
		
		return dp[T] == Integer.MAX_VALUE ? -1 : dp[T];
	}

	
	// greedy
	public int videoStitching(int[][] clips, int T) {
		Arrays.sort(clips, (a, b) -> Integer.compare(a[0], b[0]));
		int min = 0;
		int max = 0;
		
		int result = 0;
		
		for (int i = 0; i < clips.length; i++) {
			int s = clips[i][0];
			int end = clips[i][1];
			
			if (s <= max && end > max) {
				result++;
				max = end;
				min = s;
			}

			
			if (max >=T ) break;
		}
		
		// negative scenario where there are no more clips to reach T.
		if (max < T) return -1;
		
		return result;
		
	}
	
	public static void main(String[] args) {
		//System.out.println(new VideoStitching().videoStitching(new int[][]{{0,2},{4,6},{8,10},{1,9},{1,5},{5,9}}, 10));
		System.out.println(new VideoStitching().videoStitchingDP(new int[][]{{0,2},{4,6},{8,10},{1,9},{1,5},{5,9}}, 10));
	}
}
