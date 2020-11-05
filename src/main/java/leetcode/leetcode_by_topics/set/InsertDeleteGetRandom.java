package leetcode.leetcode_by_topics.set;

import scala.Int;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InsertDeleteGetRandom {

}

class RandomizedSet {

	Map<Integer, Integer> map;
	List<Integer> list;

	/** Initialize your data structure here. */
	public RandomizedSet() {
		map = new HashMap<>();
		list = new ArrayList<>();
	}

	/** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
	public boolean insert(int val) {
		if(map.containsKey(val)) {
			return false;
		}
		list.add(val);
		// pair - <value, index in list>
		map.put(val, list.size() - 1);
		return true;
	}

	/** Removes a value from the set. Returns true if the set contained the specified element. */
	public boolean remove(int val) {
		if(!map.containsKey(val)) {
			return false;
		}

		Integer index = map.get(val);
		Collections.swap(list, index, list.size() - 1);

		Integer value = list.get(index);
		map.put(value, index);

		map.remove(val);
		list.remove(list.size() - 1);

		return true;
	}

	/** Get a random element from the set. */
	public int getRandom() {
		int index = (int)(Math.random() * list.size());
		return list.get(index);
	}
}
