package stack;

public class MaxStack {

	private int[] elements;
	private int pos;

	private int[] max;

	public MaxStack(int size) {
		elements = new int[size];
		max = new int[size];
		pos = -1;
	}

	public void push(int val) {
		if (pos == elements.length - 1) {
			throw new RuntimeException("full");
		}

		int newMax = pos != -1 ? Math.max(max[pos], val) : val;
		elements[++pos] = val;
		max[pos] = newMax;

	}

	public int pop() {
		if (pos == -1)
			throw new RuntimeException("empty");
		int val = elements[pos];
		elements[pos] = -1;
		max[pos] = -1;
		pos--;

		return val;
	}

	public int max() {
		return max[pos];
	}

	public static void main(String[] args) {
		MaxStack ms = new MaxStack(10);
		ms.push(1);
		System.out.println("Max - " + ms.max()); // 1
		ms.push(2);
		System.out.println("Max - " + ms.max()); // 2
		ms.push(1);
		System.out.println("Max - " + ms.max()); // 2
		ms.pop();
		System.out.println("Max - " + ms.max()); // 2

		ms.pop();
		System.out.println("Max - " + ms.max()); // 1

	}
}
