package leetcode.leetcode_by_topics.concurrency.synchronizers_demo;

import java.util.concurrent.Exchanger;

public class ExchangerDemo {

	private static final Exchanger<String> exchanger = new Exchanger<>();

	public static class Truck implements Runnable {
		private int number;

		private String[] parcels;

		public Truck(int number, String[] parcels) {
			this.number = number;
			this.parcels = parcels;
		}

		@Override
		public void run() {
			try {
				System.out.printf("Number N%d with parsers %s and %s \n", number, parcels[0], parcels[1]);
				Thread.sleep(1000 + (long) Math.random() * 5000);
				System.out.printf("Number №%d in place of exchange\n", number);
				parcels[1] = exchanger.exchange(parcels[1]); // wait when the second thread call exchange() method
				System.out.printf("Number №%d get new parsel.\n", number);
				Thread.sleep(1000 + (long) Math.random() * 5000);
				System.out.printf("Number №%d now gor parsels: %s и %s.\n", number, parcels[0], parcels[1]);
			} catch (InterruptedException e) {
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		String[] p1 = new String[]{"p1", "p2"};
		String[] p2 = new String[]{"p3", "p4"};
		new Thread(new Truck(1, p1)).start();
		Thread.sleep(100);
		new Thread(new Truck(2, p2)).start();
	}
}
