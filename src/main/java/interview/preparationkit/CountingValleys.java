package interview.preparationkit;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CountingValleys {

	// Complete the countingValleys function below.
	static int countingValleys(int n, String s) {
		List<Integer> list = s.codePoints()
				.map(c -> c == 'U' ? 1 : -1)
				.boxed()
				.collect(Collectors.toList());

		int result = 0;
		int currentHeight = 0;
		boolean isValley = false;
		for(int step: list){
			if(isValley && (currentHeight + step == 0)){
				result++;
				currentHeight = 0;
			} else if(currentHeight == 0 && step == 1){
				isValley = false;
				currentHeight+=step;
			} else if(currentHeight == 0 && step == -1){
				isValley = true;
				currentHeight+=step;
			} else{
				currentHeight+=step;
			}
		}
		return result;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		String s = scanner.nextLine();

		int result = countingValleys(n, s);

		System.out.println(result);

		scanner.close();
	}
}
