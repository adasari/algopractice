package com.warm;

public class WarmTemperature {
	
	public static void main(String[] args) {
		int T[] = new int[] {73, 74, 75, 71, 69, 72, 76, 73};
		
	}
	
	
	 public static int[] dailyTemperatures(int[] T) {
		 int i = 0; 
		 int j = 1;
		 int[] result = new int[T.length];
		 boolean done = false;
		 int count = 0;
		 while(!done) {
			 
			 if (T[i] <= T[j]) {
				 result[i] = count + 1;
				 i++;
				 j++;
			 }else {
				 count++;
				 j++;
			 }
		 }
		 
	     return new int[] {};   
	   }

}
