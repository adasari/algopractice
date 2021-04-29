package threads;

import java.util.concurrent.Executors;

// in case of read -> no writer in progress
// in case of write -> no other reader or writer in progress
public class ReadWriteLock {
	
	boolean isWriteLocked = false;
	int readers = 0;

	public synchronized void acquireReadLock() throws Exception {
		
		while (isWriteLocked) {
			wait();
		}
		
		readers++;
	}

	public synchronized void acquireWriteLock() throws Exception {
		while(isWriteLocked || readers != 0) {
			wait();
		}
	}

	public synchronized void releaseReadLock() throws Exception {
		readers--;
		notifyAll();
	}

	public synchronized void releaseWriteLock() throws Exception {
		isWriteLocked = false;
		notifyAll();
	}
	
	
	
	public static void main(String[] args) {
		Executors.newFixedThreadPool(nThreads)
	}

}
