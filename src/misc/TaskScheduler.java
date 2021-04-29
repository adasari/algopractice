package misc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TaskScheduler {

	public static void main(String[] args) {
		char[] tasks = new char[] { 'A', 'A', 'A', 'A', 'B', 'B', 'B', 'E', 'E', 'F', 'F', 'G', 'G' };
		int n = 2;
		System.out.println(new TaskScheduler().leastInterval(tasks, n));
	}
	
	/*
	 * 1. order then tasks by frequency by using priority queue
	 * 2. process idle + 1 cycles with tasks 
	 * 3. if a task frequency is > 0 add to priority queue.
	 * 4. number of cycles iterated in #2 is either number of tasks processed (captured in temp) or full cycle (n+1)
	 */

	public int leastInterval(char[] tasks, int n) {
		Map<Character, Integer> map = new HashMap<>();
		for (char t : tasks) {
			map.put(t, map.getOrDefault(t, 0) + 1);
		}

		// #1
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>((a, b) -> (b - a));
		int cycles = 0;

		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			queue.add(entry.getValue());
		}
		while (!queue.isEmpty()) {
			List<Integer> temp = new ArrayList<>();
			// #2
			for (int i = 0; i < n + 1; i++) {
				if (!queue.isEmpty()) {
					temp.add(queue.remove());
				}
				
			}

			// #3
			for (int t : temp) {
				if (--t > 0) {
					queue.add(t);
				}
			}

			// #4
			cycles += queue.isEmpty() ? temp.size() : n + 1;
		}

		return cycles;
	}

}
