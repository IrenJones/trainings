package basic;

import java.util.Scanner;

public class Reading {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		scanner.nextLine();
		scanner.next();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		scanner.nextInt();
	}
}
