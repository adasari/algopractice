package sort;

public class MergeSort {
	
	public static void main(String[] args) {
		int[] a = {10, 3, 2, 5, 8, 4, 3, 1, 2, 9, 7, 8};
		mergeSort(a, 0, a.length);
		
		for (int i = 0; i < a.length; ++i) {
            System.out.print(a[i] + " ");
        }
	}
	
	private static void print(int[] a, int start, int end) {
		for (int i = start; i < end; ++i) {
            System.out.print(a[i] + " ");
        }
		System.out.println();
	}
	
	
	private static void mergeSort(int[] input, int start, int end) {
	//	print(input, start, end);
		if ( (end - start) < 2 ) {
			return;
		}
		
		int mid = (start + end )/2;
		mergeSort(input, start, mid);
		mergeSort(input, mid, end);
		merge(input, start, mid, end);
	}
	
	
	private static void merge(int[] input, int start, int mid, int end) {
		// not required everytime.
		int[] temp = new int[input.length];
		for (int i = start; i < end; i++) {
			temp[i] = input[i];
		}
		
		int i = start;
		int j = mid;
		int k = start;
		while (i < mid && j < end) {
			if (temp[i] <= temp[j]) {
				input[k++] = temp[i];
				i++;
			}else {
				input[k++] = temp[j];
				j++;
			}
		}
		
		while (i<mid) {
			input[k++] = temp[i++];
		}
		
		while (j<end) {
			input[k++] = temp[j++];
		}
	}
	
	
//	private static void mergeSort(int[] a, int l, int h) {
//		// split the arrya into two
//		if (l < h) {
//			int m = (l+h)/2;
//			mergeSort(a, l, m);
//			mergeSort(a, m+1, h-1);
//			merge(a, l, h, m);
//		}
//	}
//
//	
//	private static void merge(int[] a, int l, int h, int m) {
//		int[] leftTemp = new int[m-l+1];
//		int[] rightTemp = new int[h-m];
//		
//		// fill left temp
//		for (int  i= l, j= 0; i <=m; i++, j++ ) {
//			leftTemp[j] = a[i]; 
//		}
//		
//		// fill right temp
//		for (int  i= m, j= 0; i <=h; i++, j++ ) {
//			rightTemp[j] = a[i]; 
//		}
//		
//		int k = l;
//		while (l < h) {
//			
//		}
//		
//	}
}
