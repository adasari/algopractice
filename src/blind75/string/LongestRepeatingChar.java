package blind75.string;

public class LongestRepeatingChar {
	
	public int characterReplacement(String s, int k) {
        if(s == null || s.length() == 0){
            return 0;
        }
        int max = 0;
        int[] counts = new int[26];
        char[] str = s.toCharArray();
        int i = 0, start = 0;
        while(i < str.length){
            counts[str[i] - 'A']++;
            if(diffHelper(counts) > k){  //optimization
                while(diffHelper(counts) > k){
                    counts[str[start] - 'A']--;
                    start++;
                }
                max = Math.max(max, i - start + 1);   //finish optimization, update max
            }
            max = Math.max(max, i - start + 1);   //update max anyway
            i++;
        }
        return max;
    }
    public int diffHelper(int[] ch){
        int max = 0;
        int sum = 0;
        for(int val:ch){
            sum += val;
            max = Math.max(max, val);
        }
        return sum - max;
    }

}
