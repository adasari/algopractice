package lt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Meetings {
	
	public static void main(String[] args) {
//		Time time = new Meetings().new Time("Sun 1:00-1:10");
//		System.out.println(time.startTime);
//		System.out.println(time.endTime);
		String[] times = new String[] {
				"Sun 10:00-20:00",
				"Fri 05:00-20:00",
				"Fri 16:30-23:50",
				"Sat 10:00-24:00",
				"Sun 01:00-04:00",
				"Sat 02:00-06:00",
				"Tue 03:30-18:15",
				"Tue 19:00-20:00",
				"Wed 04:25-15:14",
				"Wed 15:14-22:40",
				"Thu 00:00-23:59",
				"Mon 05:00-13:00",
				"Mon 15:00-21:00"
				
		};
		
		
		String[] times1 = new String[] {
				"Mon 01:00-23:00",
				"Tue 01:00-23:00",
				"Wed 01:00-23:00",
				"Thu 01:00-23:00",
				"Fri 01:00-23:00",
				"Sat 01:00-23:00",
				"Sun 01:00-21:00"
				
				
		};
		Time previous = new Meetings().new Time("Mon 15:00-21:00"); // 180
		Time current = new Meetings().new Time("Tue 03:30-18:15"); // 180 + 30 = 210
		
		Time last = new Meetings().new Time("Sat 10:00-20:00");
		//System.out.println(last.lastGap());
		//System.out.println(previous.timeGap(current));
		new Meetings().solution(times1);
	}
	
	
	
	class Time {
		public int day;
		public int startTime;
		public int endTime;
		
		String time;
		
		public Time(String t) {
			this.time = t;
			String[] tSplit = t.split(" ");
			day = getDay(tSplit[0]);
			startTime = getMin(tSplit[1].split("-")[0]);
			endTime = getMin(tSplit[1].split("-")[1]);
		}
		
		private int getDay(String s) {
			switch(s) {
			case "Mon":
				return 0;
			case "Tue":
				return 1;
			case "Wed":
				return 2;
			case "Thu":
				return 3;
			case "Fri":
				return 4;
			case "Sat":
				return 5;
			case "Sun":
				return 6;
			}
			
			return 0;
		}
		
		public int getMin(String str) {
			String s[] = str.split(":");
			return Integer.valueOf(s[0]) * 60 +  Integer.valueOf(s[1]);
		}
		
		public int timeGap(Time other) {
			int numOfDays = other.day - this.day;
			// both times fall under same day case
			if (numOfDays == 0) {
				return other.startTime - this.endTime;
			}

			// if gap is more than a day -> add 24 hours for sleep
			int gap = (numOfDays == 1)? 0 : (numOfDays - 1) * 24 * 60;
			//return gap * 24 * 60 + 24 * 60 - this.endTime + other.startTime;
			return numOfDays * 24 * 60 - this.endTime + other.startTime;
			
		}
		
		public int remainingWeekTime() {
			int numOfDays = getDay("Sun") - this.day;
			// both times fall under same day case
//			if (numOfDays == 0) {
//				return 24 * 60 - this.endTime;
//			}

			// if gap is more than a day -> add 24 hours for sleep
			//int gap = (numOfDays == 1)? 0 : (numOfDays - 1) * 24 * 60;
			return numOfDays * 24 * 60  + 24 * 60 - this.endTime;
		}
	}
	
	
	private int solution(String[] times) {
		
		List<Time> intervals = new ArrayList<>();
		for (String s : times) {
			intervals.add(new Time(s));
		}
		
		Collections.sort(intervals, (a, b) -> Integer.compare(a.day, b.day) == 0 ? Integer.compare(a.startTime, b.startTime) :  Integer.compare(a.day, b.day));
		
		Time previous = intervals.get(0);
		int maxSleepTime = 0;
		
		for (int i = 1; i < intervals.size(); i++) {
			Time currentMeeting = intervals.get(i);
			int currentSleepTime = previous.timeGap(currentMeeting);
			maxSleepTime = Math.max(maxSleepTime, currentSleepTime);
			previous = currentMeeting;
		}
		
		// calculate last time
		maxSleepTime = Math.max(maxSleepTime,previous.remainingWeekTime());
		
		System.out.println(maxSleepTime);
		return maxSleepTime;
	}
	
	public int solution(String time) {
		if (time == null || time.isBlank()) {
			return 0;
		}

		String[] times = time.split("\n");
		return solution(times);
		
	}
}
