package blind75;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFinder {
	
	PriorityQueue<Integer> minHeap = null;
	PriorityQueue<Integer> maxHeap = null;
	
	/** initialize your data structure here. */
    public MedianFinder() {
        minHeap = new PriorityQueue<Integer>();
        maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        minHeap.offer(num);
        maxHeap.offer(minHeap.poll());
        
        if (minHeap.size() < maxHeap.size()) {
        	minHeap.offer(maxHeap.poll());
        }
    }
    
    public double findMedian() {
        if (minHeap.size() > maxHeap.size()) {
        	return minHeap.peek();
        }
        
        return (minHeap.peek() + maxHeap.peek())/2.0;
    } 

}
