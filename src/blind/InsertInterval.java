package blind;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InsertInterval {
	
	public static void main(String[] args) {
	//	new InsertInterval().insert(new int[][] {{1,3},{6,9}}, new int[] {2,5});
	//	System.out.println("********");
		new InsertInterval().insert(new int[][] {{1,2},{3,5},{6,7},{8,10},{12,16}}, new int[] {4,8});
	}

	public int[][] insert(int[][] intervals, int[] newInterval) {

		List<int[]> intervalList = new ArrayList<>(intervals.length + 1);
		for (int[] interval : intervals) {
			intervalList.add(interval);
		}

		intervalList.add(newInterval);

		Collections.sort(intervalList, (one, two) -> Integer.compare(one[0], two[0]));

		int n = intervalList.size();
		int start = intervalList.get(0)[0];
		int end = intervalList.get(0)[1];

		List<int[]> result = new ArrayList<>();

		for (int i = 1; i < n; i++) {
			int[] interval = intervalList.get(i);
			//System.out.printf("processing - %d,%d and start end are %d,%d \n", interval[0], interval[1], start, end);
			
			if (end >= interval[0]) {
				end = Math.max(end, interval[1]);
			} else {
				result.add(new int[] { start, end });
				System.out.println(start + " "+ end);
				
				start = interval[0];
				end = interval[1];
			}
		}
		result.add(new int[] { start, end });
		System.out.println(start + " "+ end);

		int[][] resultArray = new int[result.size()][2];
		
		return result.toArray(resultArray);

	}

}
