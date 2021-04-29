package dp;

// There are n houses and each contain some value in it.
// a theif going to steal the max value of the these houses
// but can't steal in two adjacent houses
// what is the max stolen value

// Eg: {6,7,1,30,8, 2,4}
// output : 41
// thief will stole # 7,30,2

// Eg: {20,5, 1, 13, 6, 11, 40}
// output: 73
// stole # 20,13,40

public class HouseTheif {

	
	public int maxStolenValue(int[] vals, int index) {
		if (index >= vals.length) {
			return 0;
		}
		// when current is included, next should be included because adjacent houses not possible.
		int include  = vals[index] + maxStolenValue(vals, index+2);
		int exclude = maxStolenValue(vals, index+1);
		return Math.max(include, exclude);
	}
}
