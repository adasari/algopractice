package com.martrix;


// 1252. Cells with Odd Values in a Matrix
public class CellsWithOddMatric {
	
	 public int oddCells(int n, int m, int[][] indices) {
		 
		 	int[] row = new int[n];
		 	int[] col = new int[n];
		 	
		 	for (int[] index : indices) {
		 		row[index[0]]++;
		 		col[index[0]]++;
		 	}
		 	
		 	int count = 0;
		 
		 	for (int i =0; i < n; i++) {
		 		for (int j=0; j<m; j++) {
		 			if ((row[i]+ row[j]) % 2 == 1 ) {
		 				count++;
		 			}
		 		}
		 	}
		 	
	        return count;
	  }
	 
	 public static void main(String[] args){
	      int n = 2;
	      int m = 3;
	      
	      int[][] indices = new int[n][m];
	      
	 }

}
