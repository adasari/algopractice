package blind75;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequent {
	
	public static void main(String[] args) {
		
	}
	
	public Integer[] topKFrequent(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		for (Integer num : nums) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}
		
		PriorityQueue<Map.Entry<Integer, Integer>> queue = 
				new PriorityQueue<Map.Entry<Integer,Integer>>((a, b) -> Integer.compare(a.getValue(), b.getValue()));
		
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			queue.offer(entry);
			if (queue.size() > k) {
				queue.poll();
			}
		}
		
		//get all elements from the heap
	    List<Integer> result = new ArrayList<>();
	    while (queue.size() > 0) {
	        result.add(queue.poll().getKey());
	    }
	 
	    //reverse the order
	    Collections.reverse(result);
	 
	    return (Integer[])result.toArray();
	}

}
