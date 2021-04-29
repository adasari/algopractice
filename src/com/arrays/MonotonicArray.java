package com.arrays;

/*
 * 
 * An array is monotonic if it is either monotone increasing or monotone decreasing.

An array A is monotone increasing if for all i <= j, A[i] <= A[j].  An array A is monotone decreasing if for all i <= j, A[i] >= A[j].

Return true if and only if the given array A is monotonic.

 
 */

public class MonotonicArray {
	public static void main(String[] args) {
		
		//int[] a =  new int[]{1,2,2,3};
		// int[] a = new int[]{6,5,4,4};
		// int[] a = new int[]{1,2,4,5};
		// int[] a = new int[]{1,3,2};
		int[] a = new int[]{1,1,1};
		
		System.out.println(isMonotonic(a));
		
		
		
		
	}
	
	
public static boolean isMonotonic(int[] a) {
	boolean increasing = true;
	boolean decreasing = true;
	for (int i=1; i < a.length; i++) {
		increasing = increasing && (a[i-1] <= a[i]);
		decreasing = decreasing && (a[i-1] >= a[i]);
	}  
	
	return increasing || decreasing;
 }

}
