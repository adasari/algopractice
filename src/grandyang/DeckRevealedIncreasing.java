package grandyang;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
 * 950. Reveal Cards In Increasing Order
 * In a deck of cards, every card has a unique integer.  You can order the deck in any order you want.

Initially, all the cards start face down (unrevealed) in one deck.

Now, you do the following steps repeatedly, until all cards are revealed:

Take the top card of the deck, reveal it, and take it out of the deck.
If there are still cards in the deck, put the next top card of the deck at the bottom of the deck.
If there are still unrevealed cards, go back to step 1.  Otherwise, stop.
Return an ordering of the deck that would reveal the cards in increasing order.

The first entry in the answer is considered to be the top of the deck.
 */
public class DeckRevealedIncreasing {
	
	public static void main(String[] args) {
		new DeckRevealedIncreasing().deckRevealedIncreasing(new int[] {17,13,11,2,3,5,7});
	}
	
	/*

		1. Sort the deck: [2,3,5,7,11,13,17], this is the increasing order we want to generate
		2. Initialize the queue: [0,1,2,3,4,5,6], this is the index of the result array
		3. The first card we pick is res[0], observe the deck, it should be deck[0]==2, so assign res[0]=2
		4. Then we put res[1] to the bottom, so we re-insert 1 to the queue
		5. The second card we pick is res[2], which should be deck[1]==3, so assign res[2]=3
		6. Then we re-insert 3 to the queue
		7. Each time we assign 1 value to the res, so we repeat this n times.
	 */
	
	public int[] deckRevealedIncreasing(int[] deck) {
		
		Arrays.sort(deck);
		Queue<Integer> q = new LinkedList<Integer>();
		
		int  n = deck.length;
		int[] result = new int[n];	
		for (int i = 0 ; i < n ; i++) {
			q.add(i);
		}
		
		for (int i = 0; i < n; i++) {
			result[q.poll()] = deck[i];
			q.add(q.poll());
		}
		
		print(result);
		return result;
	}
	
	private void print(int[] a) {
		for (Integer i : a) {
			System.out.printf("%d ", i);
		}
	}

}
