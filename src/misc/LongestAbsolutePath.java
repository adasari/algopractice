package misc;

import java.util.HashMap;
import java.util.Map;

public class LongestAbsolutePath {
	
	public static void main(String[] args) {
		
		String s = "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext";
		String[] subPaths = s.split("\n");
		Map<Integer, Integer> paths = new HashMap<>();
		paths.put(-1, 0);
		
		for (String sp : subPaths) {
			int currentDepth = sp.split("\t").length;
			int parentDepth = currentDepth - 1;
			int currentLength = sp.length() - currentDepth + paths.get(parentDepth);
			
		}
	}
}
