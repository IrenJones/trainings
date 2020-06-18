package hackerrank.algo;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class BirthdayChocolate {
	// Complete the birthday function below.
	static int birthday(List<Integer> s, int d, int m) {
		int result = 0;

		for(int i=0; i<= s.size() - m; i++){
			if (s.subList(i, i+m)
					.stream()
					.mapToInt(v -> v)
					.sum() == d){
				result++;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int n = Integer.parseInt(scanner.nextLine().trim());

		List<Integer> s = Stream.of(
				scanner.nextLine()
						.replaceAll("\\s+$", "")
						.split(" "))
				.map(Integer::parseInt)
				.collect(toList());

		String[] dm = scanner.nextLine().replaceAll("\\s+$", "").split(" ");

		int d = Integer.parseInt(dm[0]);
		int m = Integer.parseInt(dm[1]);
		int result = birthday(s, d, m);

		System.out.println(result);
	}
}
