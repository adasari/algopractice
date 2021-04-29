package grandyang;

import java.util.ArrayList;
import java.util.List;

public class FlipMatchVoyage {
	
	int index = 0;
	List<Integer> result;
	int[] voyage;
	
	private List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
		this.result = new ArrayList<>();
		this.voyage = voyage;
		
		dfs(root);
		
		if (!result.isEmpty() && result.get(0) == -1 ) {
			result.clear();
			result.add(-1);
		}
		
		return this.result;
	}
	
	private void dfs(TreeNode node) {
		if (node != null) {
			if (node.val != voyage[index++]) {
				result.clear();
				result.add(-1);
				return;
			}
			
			if (index  < voyage.length && node.left != null && node.left.val != voyage[index]) {
				dfs(node.right);
				dfs(node.left);
			}else {
				dfs(node.left);
				dfs(node.right);
			}
		}
	}

}
