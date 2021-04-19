package leetcode.leetcode_by_topics.design;

import java.util.Iterator;

class PeekingIterator <T> implements Iterator<T> {

	private final Iterator<T> iter;
	T next;

	public PeekingIterator(Iterator<T> iterator) {
		this.next= iterator.hasNext() ? iterator.next() : null;
		this.iter = iterator;
	}

	// Returns the next element in the iteration without advancing the iterator.
	public T peek() {
		return this.next;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public T next() {
		T value = this.next;
		this.next = iter.hasNext() ? iter.next() : null;

		return value;
	}

	@Override
	public boolean hasNext() {
		return this.next != null;
	}
}
