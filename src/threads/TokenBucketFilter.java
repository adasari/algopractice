package threads;

/*
This is an actual interview question asked at Uber and Oracle.
Imagine you have a bucket that gets filled with tokens at the rate of 1 token per second. The bucket can hold a maximum of N tokens. Implement a thread-safe class that lets threads get a token when one is available. If no token is available, then the token-requesting threads should block.
The class should expose an API called getToken that various threads can call to get a token

*/
public class TokenBucketFilter {
	
	private int maxTokens;
	
	private long lastRequestedTime;
	
	private int possibleTokens = 0;
	
	public TokenBucketFilter(int maxTokens) {
		this.maxTokens = maxTokens;
		this.lastRequestedTime = System.currentTimeMillis();
		
	}
	
	public synchronized void getToken() throws Exception {
		long currentTime = System.currentTimeMillis();
		
		// 1 token generated for 1 sec.
		possibleTokens += (currentTime - lastRequestedTime)/1000;
		if (possibleTokens > maxTokens) {
			possibleTokens = maxTokens;
		}
		
		if (possibleTokens == 0) {
			Thread.sleep(1000);
		}else {
			possibleTokens--;
		}
		
		lastRequestedTime = currentTime;
		
		System.out.printf("Granting a toke to %s at %d", Thread.currentThread().getName(), currentTime);
	}

}
