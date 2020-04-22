package interview.preparationkit;

import java.util.Scanner;

public class RepeatedString {
	// Complete the repeatedString function below.
	static long repeatedString(String s, long n) {
		int len = s.length();
		if(len == 1){
			return n;
		}
		if(n < len){
			return 0;
		}
		long number = n / len;
		long l = n - len * number;

		long count = s.codePoints()
				.filter(c -> c == 'a')
				.count();

		long countAdd = s.substring(0, (int)l).codePoints()
				.filter(c -> c == 'a')
				.count();
		return number*count + countAdd;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args){

		String s = scanner.nextLine();

		long n = scanner.nextLong();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		long result = repeatedString(s, n);

		System.out.println(result);

		scanner.close();
	}
}

