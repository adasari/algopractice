package grandyang;

public class MedianOfSortedArrays {
	
	private double findMedian(int[] a, int[] b) {
		if (a.length > b.length) {
			return findMedian(b, a);
		}
		
		int lengthA = a.length;
		int lengthB = b.length;
		
		int low = 0;
		int high = lengthA;
		
		int partitionA = (low + high)/2;
		
		while (low <= high) {
			int partitionB = (lengthA + lengthB + 1)/2 - partitionA;
			
			int maxLeftA = partitionA == 0 ? Integer.MIN_VALUE : a[partitionA - 1];
			int minRightA = partitionA == lengthA ? Integer.MAX_VALUE: a[partitionA - 1];
			
			int maxLeftB = partitionB == 0 ? Integer.MIN_VALUE : b[partitionB - 1];
			int minRightB = partitionB == lengthB ? Integer.MAX_VALUE: b[partitionB - 1];
			
			
			if (maxLeftA <= minRightB && maxLeftB <= minRightA) {
				if ( (lengthA + lengthB) % 2 == 0 ) {
					// even
					return ((double)Math.max(maxLeftA, maxLeftB) + Math.min(minRightA, minRightB))/2;
				}
				
				return (double)Math.max(maxLeftA, maxLeftB);
			} else if (maxLeftA > minRightB) {
				high = partitionA - 1;
			} else {
				low = partitionA + 1;
			}
			
		}
		
		return 0;
	}
	
	
	

}
