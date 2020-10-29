package leetcode.leetcode_by_topics.concurrency;

public class PrintInOrder {
}

class Foo {

	private boolean oneCheck = false;
	private boolean twoCheck = false;

	public Foo() { }

	public synchronized void first(Runnable printFirst) throws InterruptedException {

		// printFirst.run() outputs "first". Do not change or remove this line.
		printFirst.run();

		oneCheck = true;
		notifyAll();
	}

	public synchronized void second(Runnable printSecond) throws InterruptedException {

		while(oneCheck == false) {
			wait();
		}

		// printSecond.run() outputs "second". Do not change or remove this line.
		printSecond.run();

		twoCheck = true;
		notifyAll();
	}

	public synchronized void third(Runnable printThird) throws InterruptedException {

		while(twoCheck == false) {
			wait();
		}

		// printThird.run() outputs "third". Do not change or remove this line.
		printThird.run();
	}
}
