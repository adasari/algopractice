package misc;

import java.util.Arrays;
import java.util.Comparator;

/*
56. Merge Intervals
Given a collection of intervals, merge all overlapping intervals.

Example 1:

Input: [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
Example 2:

Input: [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.

*/
public class MergeIntervals {

	public int[][] merge(int[][] intervals) {
		if (intervals.length <= 1) {
			return intervals;
		}
		
		Arrays.sort(intervals, (arr1, arr2) -> Integer.compare(arr1[0], arr2[0]));
		
		int count = 0;
		int start = intervals[0][0];
		int end = intervals[0][1];
		
		int[][] mergedIntervals = new int[intervals.length][2];
		for (int i = 1; i < intervals.length; i++) {
			int[] current = intervals[i];
			if (end <= current[0]) {
				end = current[1];
			} else {
				mergedIntervals[count][0] = start;
				mergedIntervals[count][1] = end;
				
				start = current[0];
				end = current[1];
				count++;
			}
		}
		
		mergedIntervals[count][0] = start;
		mergedIntervals[count][0] = end;
		
		return mergedIntervals;
	}
	
}
