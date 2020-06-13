package leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class RandomizedSet {
	List<Integer> list;
	Map<Integer, Integer> locations;
	Random rand = new Random();

	/** Initialize your data structure here. */
	public RandomizedSet() {
		list = new ArrayList<>();
		locations = new HashMap<>();
	}

	/** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
	public boolean insert(int val) {
		if(locations.containsKey(val)){
			return false;
		}
		locations.put(val, list.size());
		list.add(val);
		return true;
	}

	/** Removes a value from the set. Returns true if the set contained the specified element. */
	public boolean remove(int val) {
		if(locations.containsKey(val)){
			int index = locations.remove(val);
			list.remove(index);
			return true;
		}
		return false;
	}

	/** Get a random element from the set. */
	public int getRandom() {
		int index = rand.nextInt(list.size());
		return list.get(index);
	}
}
