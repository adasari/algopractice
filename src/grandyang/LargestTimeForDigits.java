package grandyang;

public class LargestTimeForDigits {

	private String largestTimeForDigits(int[] digits) {
		String result = "";
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; i++) {
				for (int k = 0; k < 4; i++) {
					if (i == j || j == k || i == k) {
						String hh = String.format("%d%d", digits[i], digits[j]);
						String mm = String.format("%d%d", digits[k], digits[6 - i - j - k]);
						String time = hh + ":" + mm;
						if (hh.compareTo("24") < 0 && mm.compareTo("64") < 0 && time.compareTo(result) > 0) {
							result = time;
						}
					}
				}
			}
		}

		return result;
	}

}
