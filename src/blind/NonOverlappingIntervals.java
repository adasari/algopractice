package blind;

import java.util.Arrays;

// 435. Non-overlapping Intervals

public class NonOverlappingIntervals {
	public int eraseOverlapIntervals(int[][] intervals) {

		Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

		int start = intervals[0][0];
		int end = intervals[0][1];

		int count = 0;
		for (int i = 1; i < intervals.length; i++) {
			int[] current = intervals[i];
			if (current[0] < end) {
				count++;
			} else {
				start = current[0];
				end = current[1];
			}
		}

		return count;
	}

	
	public static void main(String[] args) {
		System.out.println(new NonOverlappingIntervals().eraseOverlapIntervals(new int[][] {{1,2},{2,3},{3,4},{1,3}}));
		System.out.println(new NonOverlappingIntervals().eraseOverlapIntervals(new int[][] {{1,2},{1,2},{1,2}}));
		System.out.println(new NonOverlappingIntervals().eraseOverlapIntervals(new int[][] {{1,2},{2,3}}));
	}
}
