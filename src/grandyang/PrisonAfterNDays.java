package grandyang;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PrisonAfterNDays {
	
	public static void main(String[] args) {
		new PrisonAfterNDays().prisonAfterNDays(new int[] {0,1,0,1,1,0,0,1}, 7);
	}

	private int[] prisonAfterNDays(int[] p, int N) {
		Map<String, Integer> cells = new HashMap<>();
		for (int i = 0;  i < N; i++) {
			String str = Arrays.toString(p);
			if (cells.containsKey(str)) {
				int looplength = cells.get(str);
				int remaining = (N - i) % looplength;
				
				return prisonAfterNDays(p, remaining);
			}else {
				cells.put(str, i);
				
				int prev = p[0];
				for (int j = 1; j < p.length - 1; j++) {
					int curr = p[j];
					
					if (prev == p[j+1]) {
						p[j] = 1;
					} else {
						p[j] = 0;
					}
					
					prev = curr;
				}
				
				p[0] = 0;
				p[p.length - 1] = 0;
				
				
			}
		}
		
		print(p);
		return p;
	}
	
	private void print(int[] p) {
		for (int i  = 0; i < p.length; i++) {
			System.out.print(String.format("%s ", p[i]));
		}
	}
}
