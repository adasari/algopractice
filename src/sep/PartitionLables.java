package sep;

import java.util.ArrayList;
import java.util.List;

// 763 - Partition Labels

public class PartitionLables {

	public static void main(String[] args) {
		new PartitionLables().partitionLabels("ababcbacadefegdehijhklij");
	}

	public List<Integer> partitionLabels(String s) {
		int[] endIndex = new int[26];
		for (int i = 0; i < s.length(); i++) {
			endIndex[s.charAt(i) - 'a'] = i;
		}

		List<Integer> result = new ArrayList<>();
		
		int start = 0; int end = 0;
		for (int i = 0; i < s.length(); i++) {
			int lastIndex = endIndex[s.charAt(i) - 'a'];
			end = Math.max(end, lastIndex);
			// last index of the char == current index, it means that char is not available later in the string
			if (end == i) {
				System.out.println(end - start + 1);
				result.add(end - start + 1);
				start = end + 1;
			}
		}
		
		return result;
	}
}
