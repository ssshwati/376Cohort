package com.wileyEdge.ThreadExample;

class NumberPrinter implements Runnable {
	private final int limit;
	private final boolean isEven;

	public NumberPrinter(int limit, boolean isEven) {
		this.limit = limit;
		this.isEven = isEven;
	}

	@Override
	public void run() {
		String threadType = isEven ? "Even Thread" : "Odd Thread";
		for (int i = isEven ? 2 : 1; i <= limit; i += 2) {
			if (isEven && i % 2 == 0) {
				System.out.println(threadType + ": " + i);
			} else if (!isEven && i % 2 != 0) {
				System.out.println(threadType + ": " + i);
			}
		}
	}
}

public class NumberThread {
	public static void main(String[] args) {
		int limit = 20;
		// Create two threads to print even and odd numbers
		Thread evenThread = new Thread(new NumberPrinter(limit, true));
		Thread oddThread = new Thread(new NumberPrinter(limit, false));

		// Start the threads
		evenThread.start();
		oddThread.start();
	}
}
