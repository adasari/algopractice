package lt;

public class BusyStudent {
	
	public static void main(String[] args) {
		System.out.println(new BusyStudent().busyStudent(new int[] {1,2,3}, new int[] {3,2,7}, 4));
		System.out.println(new BusyStudent().busyStudent(new int[] {4}, new int[] {4}, 4));
		System.out.println(new BusyStudent().busyStudent(new int[] {9,8,7,6,5,4,3,2,1}, new int[] {10,10,10,10,10,10,10,10,10}, 5));
	}

	public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
		int count = 0;

		for (int i = 0; i < startTime.length; i++) {
			int st = startTime[i];
			int et = endTime[i];

			if (st <= queryTime && et >= queryTime) {
				count++;
			}
		}

		return count;
	}
}
