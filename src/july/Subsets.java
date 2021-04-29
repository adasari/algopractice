package july;

import java.util.ArrayList;
import java.util.List;

/*
Given a set of distinct integers, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:

Input: nums = [1,2,3]
Output:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]

*/
public class Subsets {
	
	public static void main(String[] args) {
		//printR(new Subsets().subsets(new int[] {1,2,3}));
		printR(new Subsets().subsetsIterative(new int[] {1,2,3}));
	}
	
	/*// one way
	 * public List<List<Integer>> subsets(int[] nums) { return
	 * gernerateSubsets(nums, 0); }
	 * 
	 * public List<List<Integer>> gernerateSubsets(int[] nums, int index) {
	 * List<List<Integer>> result = new ArrayList<>();
	 * 
	 * List<Integer> current = new ArrayList<>(); current.add(nums[index]);
	 * 
	 * result.add(current);
	 * 
	 * if (index == nums.length - 1) { // last element return result; }
	 * 
	 * // get the list of next index List<List<Integer>> subsets =
	 * gernerateSubsets(nums, index+1); // add all subsets to result for
	 * (List<Integer> s : subsets) { result.add(new ArrayList<>(s));
	 * s.add(nums[index]); result.add(s); }
	 * 
	 * return result; }
	 */
	
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		 gernerateSubsets(nums, 0, result);
		 return result;
	}

	
	public List<List<Integer>> subsetsIterative(int[] nums) {
		 List<List<Integer>> result = new ArrayList<>();
		 result.add(new ArrayList<>());
		 
		 for (int num : nums) {
			 int size = result.size();
			 for (int i = 0; i < size; i++) {
				 List<Integer> r = new ArrayList<>(result.get(i));
				 r.add(num);
				 result.add(r);
			 }
		 }
		 
		 return result;
	}
	
	public void gernerateSubsets(int[] nums, int index, List<List<Integer>> result) {
		List<Integer> current = new ArrayList<>();
		current.add(nums[index]);
		//result.add(current);
		
		if (index == nums.length - 1) {
			// last element
			result.add(current);
			return;
		}
		
		// get the list of next index
		gernerateSubsets(nums, index+1, result);
		
		int size = result.size();
		
		// add current element to the result
		result.add(current);
		
		// add current element to each list of the result
		for (int i = 0; i < size; i++) {
			List<Integer> r = new ArrayList<>(result.get(i));
			r.add(nums[index]);
			result.add(r);
		}
		
	}
	
	
	
	private static void printR(List<List<Integer>> a) {
		for (List<Integer> i : a) {
			print(i);
		}
	}
	
	private static void print(List<Integer> a) {
		for (Integer i : a) {
			System.out.printf("%d ", i);
		}
		System.out.println();
	}
}
