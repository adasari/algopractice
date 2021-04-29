package lt;

import java.util.ArrayList;
import java.util.List;

public class Leetcode1313 {

	public static void main(String[] args) {
		printArr(new Leetcode1313().decompressRLElist(new int[] {1,2,3,4}));
	}

	public int[] decompressRLElist(int[] nums) {
		if (nums.length % 2 != 0 ) {
            return null;
        }
        
        List<Integer> result = new ArrayList<Integer>();
        
        for (int i = 0; i < nums.length; i = i+2) {
            int freq = nums[i];
            int val = nums[i+1];
            
            while (freq > 0) {
                result.add(val);
                freq--;
            }
        }
        
        //print(result);
        
       // return null;
        return  result.stream().mapToInt(i->i).toArray();
	}
	
	
	private void print(List<Integer> list) {
		for (Integer i : list) {
			System.out.printf("%d ", i);
		}
	}
	
	private static void printArr(int[] list) {
		for (Integer i : list) {
			System.out.printf("%d ", i);
		}
	}
}
