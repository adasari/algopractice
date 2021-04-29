package threads;

import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumer extends Thread {

}

class Producer<T> implements Runnable {

	private Queue<T> queue;

	public Producer(Queue<T> queue) {
		this.queue = queue;
	}

	@Override
	public synchronized void run() {
		while (queue.isEmpty()) {

		}

	}
}

class BlockingQueue<T> {

	private int size;
	private Object[] items;
	private int capacity;
	private int head;
	private int tail;
	
	private Lock lock = null;

	public BlockingQueue(int capacity) {
		this.items = new Object[capacity];
		this.capacity = capacity;
		this.lock = new ReentrantLock();
	}
	
	public void enqueue(T item) {
		lock.lock();
		while (capacity == size) {
			// release mutex to give other threads
			lock.unlock();
			
			// re-acquire lock before checking the condition.
			lock.lock();
		}
		
		if (tail == capacity) {
			tail = 0;
		}
		
		size++;
		items[tail++] = item;
		
		lock.unlock();
	}
	
	public T dequeue() {
		T item = null;
		
		lock.lock();
		while (size == 0) {
			lock.unlock();
			
			lock.lock();
		}
		
		if (head == capacity) {
			head = 0;
		}
		
		item = (T)items[head];
		items[head] = null;
		
		head++;
		size--;
		
		lock.unlock();
		return item;
	}

	/*
	// with synchronized keyword.
	
	public synchronized void enqueue(T item) {
		while (capacity == size) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if (tail == capacity) {
			tail = 0;
		}
		
		size++;
		items[tail++] = item;
		
		notifyAll();
	}
	
	public  synchronized T dequeue() {
		T item = null;
		
		while (size == 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if (head == capacity) {
			head = 0;
		}
		
		item = (T)items[head];
		items[head] = null;
		
		head++;
		size--;
		
		notifyAll();
		
		return item;
	}
	
	*/
}