package misc;

import java.util.Arrays;

public class MaxNumber {
	public static long solution(long[] numbers) {
        // Type your solution here
      if (numbers.length == 0) return 0;
      
      Arrays.sort(numbers);
      return numbers[numbers.length-1];
    }

}
