package dataStructureBasic;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class MyComparator implements Comparator<String> {
	@Override
	public int compare(String s1, String s2) {
		return -s1.compareTo(s2);
	}
}

public class PriorityQueueDemo {
	public static void main(String[] args) {
//		Queue<String> pq = new PriorityQueue<>(); // natural ordering
		Queue<String> pq = new PriorityQueue<>(new MyComparator());
		pq.add("Hello");
		pq.add("HackerRank");
		String s1 = pq.poll();
		String s2 = pq.peek();
		System.out.println(s1);
		System.out.println(s2);
		pq.remove();
		
//		The remove() and poll() methods differ only in their behavior when the queue is empty: 
//		the remove() method throws an exception, while the poll() method returns null.
	
//		add() will throw an IllegalStateException if no space is currently available 
//		in the Queue, otherwise add method will return true. offer() method will 
//		return false if the element cannot be inserted due to capacity restrictions
	}
}
