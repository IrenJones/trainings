package leetcode.leetcode_by_topics.concurrency;

import lombok.SneakyThrows;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DiningPhilosophers {

	private Lock chopsticks[] = new Lock[5];

	// limit number of philosophers who can get his left chopstick
	// so we can always have 1 man who can eat with one left chopstick
	private Semaphore semaphore = new Semaphore(4);

	public DiningPhilosophers() {
		for (int i = 0; i < 5; i++) {
			chopsticks[i] = new ReentrantLock();
		}
	}

	public void pickChopstick(int id, Runnable implementation) {
		chopsticks[id].lock();
		System.out.printf("Chopstick %d - pick\n", id);
		implementation.run();
	}

	public void putChopstick(int id, Runnable implementation) {
		implementation.run();
		chopsticks[id].unlock();
		System.out.printf("Chopstick %d - put\n", id);
	}

	// call the run() method of any runnable to execute its code
	public void wantsToEat(int philosopher,
						   Runnable pickLeftFork,
						   Runnable pickRightFork,
						   Runnable eat,
						   Runnable putLeftFork,
						   Runnable putRightFork) throws InterruptedException {

		int leftChopstick = philosopher;
		int rightChopstick = (philosopher + 1) % 5;
		System.out.printf("Chopsticks %d and %d for man %d \n", leftChopstick, rightChopstick, philosopher);

		// limit amount of threads
		semaphore.acquire();

		pickChopstick(leftChopstick, pickLeftFork);
		pickChopstick(rightChopstick, pickRightFork);

		eat.run();

		putChopstick(leftChopstick, putLeftFork);
		putChopstick(rightChopstick, putRightFork);

		System.out.printf("Main %d ready! \n", philosopher);
		semaphore.release();
	}


	public static void main(String[] args) {

		ExecutorService service = Executors.newFixedThreadPool(5);

		DiningPhilosophers philosophers = new DiningPhilosophers();
		for (int i = 0; i < 5; i++) {
			int p = i;
			service.submit(() -> {
				try {
					philosophers.wantsToEat(p,
							new PickChopstick(),
							new PickChopstick(),
							new Eat(),
							new PutChopstick(),
							new PutChopstick());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			});
		}

		service.shutdown();
	}
}

class PickChopstick implements Runnable {
	@SneakyThrows
	@Override
	public void run() {
		Thread.sleep(100);
	}
}

class PutChopstick implements Runnable {
	@SneakyThrows
	@Override
	public void run() {
		Thread.sleep(100);
	}
}

class Eat implements Runnable {
	@SneakyThrows
	@Override
	public void run() {
		Thread.sleep(5000);
	}
}
