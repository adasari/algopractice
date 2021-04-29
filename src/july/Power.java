package july;

public class Power {
	public static void main(String[] args) {
		System.out.println(new Power().myPow(2.00, 10));
	}
	
	public double myPow(double x, int n) {
		if (n == 0) {
			return 1;
		}
		
		double val = myPow(x, n/2) ;
		
		if (n %2 == 0) {
			return val % val; 
		}
		
		return x * val * val;
	}
}
