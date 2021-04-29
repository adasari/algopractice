package threads;

import java.util.concurrent.TimeUnit;

public class CountdownLatch {
	
	private volatile int count;
	
	public CountdownLatch(int count) {
		//this.count = new AtomicInteger(count);
		this.count = count;
	}
	
	public void countdown() {
		synchronized(this) {
			//count.decrementAndGet();
			count--;
			notifyAll();
		}
		
	}

	public void await() throws InterruptedException {
		//while (count.get() > 0) {
		while (count > 0) {
			synchronized(this) {
				this.wait();
			}
		}
	}

	public static void main(String[] args) throws Exception {
		long m = System.currentTimeMillis();
		CountdownLatch latch = new CountdownLatch(4);
		for (int i = 0; i < 4; i++) {
			Task t = new Task(latch);
			new Thread(t).start();
		}
		
		latch.await();
		
		System.out.println("main is completed - " + ((System.currentTimeMillis() - m)/1000));
	}
	
	public static class Task implements Runnable {
		private CountdownLatch latch;
		
		public Task(CountdownLatch c) {
			this.latch = c;
		}
		
		@Override
		public void run() {
			try {
				TimeUnit.SECONDS.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			};
			
			latch.countdown();			
		}
		
	}

}


