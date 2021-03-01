package leetcode.leetcode_by_topics.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class MaximumFrequencyStack {

}

class FreqStack {

	private Map<Integer, Integer> freq;
	private Map<Integer, Stack<Integer>> group;
	private int maxFrequency = 0;

	public FreqStack() {
		this.freq = new HashMap<>();
		this.group = new HashMap<>();
	}

	public void push(int x) {
		int value = this.freq.getOrDefault(x, 0) + 1;
		this.freq.put(x, value);
		if(value > this.maxFrequency) {
			this.maxFrequency = value;
		}

		if(this.group.containsKey(value)) {
			this.group.get(value).push(x);
		} else {
			Stack<Integer> stack = new Stack<>();
			stack.push(x);
			this.group.put(value, stack);
		}
	}

	public int pop() {
		Stack<Integer> values = this.group.get(this.maxFrequency);
		int x = values.pop();
		if(this.freq.get(x) == 1) {
			this.freq.remove(x);
		} else {
			this.freq.put(x, freq.get(x) - 1);
		}
		if(values.size() == 0) {
			this.maxFrequency--;
		}
		return x;
	}
}
