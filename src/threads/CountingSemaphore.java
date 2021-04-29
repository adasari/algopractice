package threads;

public class CountingSemaphore {
	
	private int usedPermits;
	private int maxCount;
	
	public CountingSemaphore(int maxCount) {
		this.maxCount = maxCount;
	}
	
	public synchronized void acquire() throws Exception {
		while (usedPermits == maxCount) {
			wait();
		}
		
		usedPermits++;
		notifyAll();
	}
	
	public synchronized void release() throws Exception {
		while (usedPermits == 0) {
			wait();
		}
		
		usedPermits--;
		notifyAll();
	}

}
