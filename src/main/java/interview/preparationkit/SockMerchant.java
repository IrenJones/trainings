package interview.preparationkit;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SockMerchant {

	// Complete the sockMerchant function below.
	static int sockMerchant(int n, int[] ar) {
		int res = 0;
		List<Integer> list = Arrays.stream(ar)
				.boxed()
				.collect(Collectors.toCollection(ArrayList::new));
		Collections.sort(list);

		// Another way - Arrays.sort(ar);
		for(int i=1; i<n;i++){
			if(list.get(i) == list.get(i-1)){
				res++;
				i++;
			}
		}
		return res;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int[] ar = new int[n];

		String[] arItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			int arItem = Integer.parseInt(arItems[i]);
			ar[i] = arItem;
		}

		int result = sockMerchant(n, ar);

		System.out.println(result);

		scanner.close();
	}
}
