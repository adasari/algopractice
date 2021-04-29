package educative.intervals;

import java.util.ArrayList;
import java.util.List;

public class IntervalIntersection {
	
	private int[][] merge(int[][] arr1, int[][] arr2) {
		int i = 0; int j = 0;
		List<int[]> merged = new ArrayList<>();
		while (i < arr1.length && j < arr2.length) {
			int[] a = arr1[i];
			int[] b = arr2[i];
			
			
			if ((a[1] <= b[1] && a[0] >= b[0]) || (a[0] <= b[0] && a[1] >= b[1])) {
				merged.add(new int[] {Math.max(a[0], b[0]), Math.min(a[1], b[1])});
			}
			
			if (a[1] < b[1]) {
				i++;
			}else {
				j++;
			}
		}
		
		
		return (int[][])merged.toArray();
	}

}
