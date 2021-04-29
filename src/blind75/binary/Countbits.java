package blind75.binary;

// 338. Counting Bits
public class Countbits {
	public int[] countBits(int num) {
		int[] bits = new int[num+1];
		bits[0] = 0;
		
		for (int i = 1; i <= num; i++ ) {
			if ( i%2 == 0) {
				bits[i] = bits[i%2];
			}else {
				bits[i] = bits[i%2]+1;
			}
		}
		
		return bits;
	}

}
