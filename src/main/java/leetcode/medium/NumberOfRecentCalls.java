package leetcode.medium;

import java.util.LinkedList;

public class NumberOfRecentCalls {

	public static void main(String[] args) {
		RecentCounter counter = new RecentCounter();
		counter.ping(1);
	}
}

class RecentCounter {

	private LinkedList<Integer> list;

	private static final int WINDOW_SIZE = 3000;

	public RecentCounter() {
		this.list = new LinkedList<>();
	}

	public int ping(int t) {
		this.list.add(t);

		while(this.list.getFirst() < t - WINDOW_SIZE) {
			this.list.removeFirst();
		}

		return this.list.size();
	}
}
