package com.arrays;

public class MoveZerosToEnd {
	
	public static void main(String[] args) {
		int[] a = {1, 2, 0, 4, 3, 0, 5, 0};
		
		int count  = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] != 0) {
				a[count++] = a[i];
			}
			
		}
		
		while (count < a.length) {
			a[count++] = 0;
		}
		
		print(a);
	}
	
	public static void print(int[] nums) {
		for (int n : nums) {
			System.out.printf("%d ", n);
		}

		System.out.println();
	}

}
