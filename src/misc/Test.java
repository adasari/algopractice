package misc;

public abstract class Test {
	public static void main(String[] args) {
		double d = 10.0/-0;
		if (d == Double.POSITIVE_INFINITY) {
			System.out.println("inside");
		}
	}
	
	private static void call_array(int i, int arr[]) {
		arr[i] = 6;
		i = 5;
	}
}
	