package blind;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

	public static void main(String[] args) {
		new CombinationSum().combinationSum(new int[] {2,3,6,7}, 7);
		System.out.println("***********");
		new CombinationSum().combinationSum(new int[] {2,3,5}, 8);
	}

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		Arrays.sort(candidates);
		
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> combination = new ArrayList<>();
		
		combinationSum(candidates, 0, target, result, combination);
		return result;
	}

	
	public void combinationSum(int[] candidates, int index, int target, List<List<Integer>> result, List<Integer> combination) {
		if (target == 0) {
			result.add(new ArrayList<>(combination));
			print(combination);
			return;
		}
		
		for (int i = index; i < candidates.length; i++) {
			if (candidates[i] > target) {
				break;
			}
			
			combination.add(candidates[i]);
			combinationSum(candidates, i, target - candidates[i], result, combination);
			combination.remove(combination.size() - 1);
		}
		
	}
	
	private void print(List<Integer> list) {
		for (Integer i : list) {
			System.out.printf("%d ", i);
		}
		
		System.out.println();
	}
}
