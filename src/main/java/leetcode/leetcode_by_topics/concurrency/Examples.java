package leetcode.leetcode_by_topics.concurrency;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;

public class Examples {
	private static int counter = 0;

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		Thread t1 = new Thread(new PrintData());
		t1.start();

		Thread t2 = new Thread(new PrintDataAlso());
		t2.start();


//		ExecutorService service = Executors.newSingleThreadExecutor();
//		service.execute(new PrintData());
//		service.shutdown();

		ExecutorService service = null;
		try {
			service = Executors.newSingleThreadExecutor();
			Future<?> result = service.submit(() -> {
				for (int i = 0; i < 500; i++) counter++;
			});
			result.get(10, TimeUnit.SECONDS);
			System.out.println("Reached!");
		} catch (TimeoutException e) {
			System.out.println("Not reached in time");
		} finally {
			if (service != null) {
				service.shutdown();
			}
		}

		service = null;
		try {
			service = Executors.newSingleThreadExecutor();
			Future<Integer> result = service.submit(() -> 31 + 11);
			System.out.println(result.get());
		} finally {
			if (service != null) {
				service.shutdown();
			}
		}

		service = null;
		try {
			service = Executors.newSingleThreadExecutor();
			service.submit(() -> System.out.println(42));
		} finally {
			if (service != null) {
				service.shutdown();
			}
		}

		service = null;
		try {
			service = Executors.newFixedThreadPool(20);
			Examples object = new Examples();
			for(int i=0; i<10; i++)
				service.submit(() -> object.incrementAndReportSync());
		} finally {
			if(service != null) {
				service.shutdown();
			}
		}
	}

	private AtomicInteger sheepCount = new AtomicInteger(0);
	private void incrementAndReport() {
		System.out.print(sheepCount.incrementAndGet()+" ");
	}

	private int sheepCountSync = 0;
	private void incrementAndReportSync() {
		synchronized(this) {
			System.out.print((++sheepCountSync)+" ");
		}
	}
}

class PrintData implements Runnable {
	@Override
	public void run() {
		System.out.println("Hellooooooo");
	}
}


class PrintDataAlso extends Thread {

	@Override
	public void run() {
		System.out.println("Hellooooooo");
	}
}
