package leetcode.easy;

public class DesignHashSet {
	public static void main(String[] args) {
		MyHashSet hashSet = new MyHashSet();
		hashSet.add(1);
		hashSet.add(2);
		System.out.println(hashSet.contains(1));    // returns true
		System.out.println(hashSet.contains(3));    // returns false (not found)
		hashSet.add(2);
		System.out.println(hashSet.contains(2));    // returns true
		hashSet.remove(2);
		System.out.println(hashSet.contains(2));    // returns false (already removed)

		hashSet = new MyHashSet();
		hashSet.add(58);
		System.out.println(hashSet.contains(0));    // returns false
	}
}

class MyHashSet {

	int[] values;
	int counter = 0;

	/** Initialize your data structure here. */
	public MyHashSet() {
		this.values = new int[10];
	}

	public void add(int key) {
		if(!contains(key)){
			if(counter >= this.values.length){
				int[] newValues = new int[this.values.length*2];
				for(int i=0; i< this.values.length; i++) {
					newValues[i] = this.values[i];
				}
				this.values = newValues;
			}
			this.values[counter] = key;
			counter++;
		}
	}

	public void remove(int key) {
		for(int i=0; i< counter; i++) {
			if(this.values[i] == key) {
				this.values[i] = this.values[this.values.length-1];
			}
		}
	}

	/** Returns true if this set contains the specified element */
	public boolean contains(int key) {
		for(int i=0; i< counter; i++){
			if(this.values[i] == key){
				return true;
			}
		}
		return false;
	}
}
