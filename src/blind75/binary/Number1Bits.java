package blind75.binary;

public class Number1Bits {
	
	public static void main(String[] args) {
		new Number1Bits().hammingWeight(7);
	}
	// you need to treat n as an unsigned value
    public int hammingWeight(int n) {
    	int result = 0;
    	while ( n > 0) {
    		n = n & (n-1);
    		result++;
    	}
    	
    	System.out.println(result);
    	
    	return result;
    }

}
