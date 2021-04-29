package blind;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
	public static void main(String[] args) {
		new ThreeSum().threeSum(new int[] {-1, 0, 1, 2, -1, -4});
	}
	public List<List<Integer>> threeSum(int[] nums) {

		Arrays.sort(nums);
		
		List<List<Integer>> result = new ArrayList<>();
		for (int  i= 0; i < nums.length-2; i++) {
			// if current and previous element is same, ignore current element as previous element is computed.
			if (i > 0 && nums[i] == nums[i-1]) {
				continue;
			}
			
			int low = i+1;
			int high = nums.length - 1;
			int target = -1 * nums[i];
			
			while (low < high) {
				if (nums[low] + nums[high] == target) {
					System.out.printf("%d, %d, %d\n", nums[i], nums[low], nums[high]);
					result.add(Arrays.asList(nums[i], nums[low], nums[high]));
					
					// avoid duplicates
					while (low < high && nums[low] == nums[low+1]) {
						low++;
					}
					
					while (low < high && nums[high] == nums[high-1]) {
						high--;
					}
					
					low++;
					high--;
					
				}else if (nums[low]+ nums[high] >= target){
					high--;
				} else {
					low++;
				}
			}
		}
		
		return result;
	}

}
