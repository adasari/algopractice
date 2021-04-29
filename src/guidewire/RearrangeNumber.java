package guidewire;

public class RearrangeNumber {

	public static void main(String[] args) {
		String str = String.valueOf("130");

		char[] result = new char[str.length()];
		int n = 0, i = 0;
		//int mid = str.length() % 2 == 0 ? str.length()/2 : str.length()/2 + 1;
		while (i < str.length()/2) {
			result[n++] = str.charAt(i);
			result[n++] = str.charAt(str.length() -1 - i);
			i++;
		}
		
		if (str.length() % 2 != 0) {
			result[n] = str.charAt(i);
		}
		
		System.out.println(result);
	}
}
