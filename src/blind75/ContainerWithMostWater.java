package blind75;

// 11. Container With Most Water
public class ContainerWithMostWater {

	public static void main(String[] args) {
		new ContainerWithMostWater().maxArea(new int[] {1,8,6,2,5,4,8,3,7});
	}
	
	public int maxArea(int[] height) {
		int area = Integer.MIN_VALUE;
		int i = 0;
		int j = height.length - 1;
		
		while (i < j) {
			int min = Math.min(height[i], height[j]);
			area = Math.max(area, min * (j-i));
			if (height[i] < height[j]) {
				i++;
			}else {
				j--;
			}
		}
		
		System.out.println(area);
		return area;
	}
}
