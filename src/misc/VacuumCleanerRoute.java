package misc;

public class VacuumCleanerRoute {

	public static void main(String[] args) {
		System.out.println(new VacuumCleanerRoute().route("LR"));
		System.out.println(new VacuumCleanerRoute().route("URURD"));
		System.out.println(new VacuumCleanerRoute().route("RUULLDRD"));
	}

	private boolean route(String s) {
		int[] start = new int[] { 0, 0 };
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			switch (c) {
			case 'L':
				start[0] = start[0] - 1;
				break;
			case 'R':
				start[0] = start[0] + 1;
				break;
			case 'U':
				start[1] = start[1] + 1;
				break;
			case 'D':
				start[1] = start[1] - 1;
				break;
			default:
				System.out.println("invalid character");
				return false;
			}
		}
		
		if (start[0] == 0 && start[1] == 0) return true;
		
		return false;
	}
}
