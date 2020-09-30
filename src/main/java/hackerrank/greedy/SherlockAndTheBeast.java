package hackerrank.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

public class SherlockAndTheBeast {

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		int count = Integer.parseInt(bufferedReader.readLine().trim());
		IntStream.range(0, count).forEach( v -> {
			try {
				int value = Integer.parseInt(bufferedReader.readLine().trim());
				decentNumber(value);
				decentNumberMoreCoolSolution(value);
			} catch (IOException e){
				throw new RuntimeException(e);
			}
		});

		bufferedReader.close();
	}

	// Complete the decentNumber function below.
	public static void decentNumber(int n) {
		if (n < 3){
			System.out.println(-1);
		} else {

			// 3x + 5y = n
			int xCount = 0;
			int xBest = 0;
			int yBest = 0;
			while (true) {
				if (xCount * 3 > n) {
					break;
				}
				if ((n - 3 * xCount) % 5 == 0) {
					int y = (n - 3 * xCount) / 5;
					if (xCount > xBest) {
						yBest = y;
						xBest = xCount;
					} else if (xBest == 0 && yBest == 0){
						xBest = xCount;
						yBest = y;
					}
				}
				xCount++;
			}
			if (xBest == 0 && yBest == 0) {
				System.out.println(-1);
			} else {
				StringBuilder s = new StringBuilder();
				while (xBest > 0) {
					s.append(555);
					xBest--;
				}
				while (yBest > 0) {
					s.append(33333);
					yBest--;
				}
				System.out.println(s.toString());
			}
		}
	}

	public static void decentNumberMoreCoolSolution(int n) {
		int fives = 0;
		int threes = 0;

		while(n > 0) {
			if(n % 3 == 0) {
				while(n > 0) {
					fives++;
					n -= 3;
				}
			} else if(n % 5 == 0) {
				threes++;
				n -= 5;
			} else {
				fives++;
				n -= 3;
			}
		}
		if (n < 0){
			System.out.println(-1);
		} else{
			StringBuilder s = new StringBuilder();
			while (fives > 0) {
				s.append(555);
				fives--;
			}
			while (threes > 0) {
				s.append(33333);
				threes--;
			}
			System.out.println(s.toString());
		}
	}
}
