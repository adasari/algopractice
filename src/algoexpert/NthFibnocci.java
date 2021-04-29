package algoexpert;

public class NthFibnocci {
	
	public static void main(String[] args) {
		System.out.println(new NthFibnocci().nthFib(6));
	}
	
	public int nthFib(int n) {
		if (n == 0 || n == 1) {
			return n;
		}
		
		int[] result  = new int[n];
		result[0] = 0;
		result[1] = 1;
		for (int i = 2; i < n ; i++) {
			result[i] = result[i-1]+ result[i-2];
		}
		
		return result[n-1];
	}
	
	public int nthFib2(int n) {
		if (n == 0 || n == 1) {
			return n;
		}
		
		int[] last = new int[]{0, 1};
		
		int result = 0;
		for (int i = 2; i < n ; i++) {
			result = last[0] + last[1];
			last[0] = last[1];
			last[1] = result;
		}
		
		return result;
	}
}
