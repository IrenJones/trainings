package leetcode.leetcode_by_topics.design;

import java.util.ArrayList;
import java.util.List;

public class DesignHashMap {
}

class MyHashMap {

	List<Integer> keys;
	List<Integer> values;

	/** Initialize your data structure here. */
	public MyHashMap() {
		this.keys = new ArrayList<>();
		this.values = new ArrayList<>();
	}

	/** value will always be non-negative. */
	public void put(int key, int value) {
		int index = search(key);

		if(index == -1) {
			keys.add(key);
			values.add(value);
		} else {
			values.set(index, value);
		}
	}

	/** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
	public int get(int key) {
		int index = search(key);

		return index >= 0 ? values.get(index) : -1;
	}

	/** Removes the mapping of the specified value key if this map contains a mapping for the key */
	public void remove(int key) {
		int index = search(key);

		if(index >= 0) {
			keys.remove(index);
			values.remove(index);
		}
	}

	public int search(int key) {
		for(int i=0; i< keys.size(); i++) {
			if(key == keys.get(i)) {
				return i;
			}
		}

		return -1;
	}
}
