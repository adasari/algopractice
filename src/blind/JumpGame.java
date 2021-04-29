package blind;

public class JumpGame {

	public static void main(String[] args) {
		System.out.println(new JumpGame().canJump(new int[] { 2, 3, 1, 1, 4 }));
		System.out.println(new JumpGame().canJump(new int[] { 3, 2, 1, 0, 4 }));
	}

	public boolean canJump(int[] nums) {
		int reached = 0;
		int n = nums.length;

		for (int i = 0; i < n; i++) {
			if (reached < i) {
				return false;
			}

			reached = Math.max(reached, i + nums[i]);
			if (reached >= n) {
				break;
			}
		}

		return true;

	}

}
