package sep;

public class KMP {
	
	public static void main(String[] args) {
		int i = 0; int j = 0;
		
	}
	
	
	// https://www.youtube.com/watch?v=tWDUjkMv6Lc&lc=z12bxp2htrrgfzxdy225hrgbqm2sj3a5s04
	private int[] getLPS(char[] pattern) {
		int[] lps = new int[pattern.length];
		lps[0] = 0;
		int j =0;
		int i = 1;
		
		while (i < pattern.length) {
			if (pattern[i] == pattern[j]) {
				lps[i] = j+1;
				i++;
				j++;
			}else {
				if (j != 0) {
					j = lps[j-1];
				}else {
					lps[i] = 0;
					i++;
				}
			}
		}
		
		return lps;
	}

}
