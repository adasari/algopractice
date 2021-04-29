package algo.graph;

public class SingleCycle {
	
	private boolean hasSingleCycle(int[] a) {
		if (a == null || a.length == 0) return true;
		int n = a.length;
		
		int visistedCount = 0;
		int currentIndex = 0;
		
		while (visistedCount < n) {
			// check if reached 0 index again without visiting all elements
			if (visistedCount > 1 && visistedCount < n && currentIndex == 0) {
				return false;
			}
			
			visistedCount += 1;
			currentIndex = getNextIndex(a, currentIndex);
		}
		
		return currentIndex == 0;
	}

	private int getNextIndex(int[] a, int currentIndex) {
		int jumps = a[currentIndex];
		int newIndex = (currentIndex + jumps) % a.length;
		return newIndex > 0 ? newIndex : newIndex + a.length ;
	}

}
