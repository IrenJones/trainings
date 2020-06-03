package regex_hackerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
	One of the differences is how UK has kept the usage of letters our
	in some of its words and US has done away with the letter
	u and uses just or.
 */
public class UKandUS {
	public static void main(String[] args) {
		String line;
		Scanner scanner = new Scanner(System.in);
		// another variant to fix is to use Integer.parseInt(scanner.nextLine().trim())
		// for one single int in a row
		int n = scanner.nextInt();
		List<String> strings = new ArrayList<>(n);
		while (!scanner.hasNextInt()) {
			if ((line = scanner.nextLine()).isEmpty()){
				line = scanner.nextLine();
			}
			strings.add(line);
			for (int i = 1; i < n; i++) {
				strings.add(scanner.nextLine());
			}
		}
		int t = scanner.nextInt();
		List<String> words = new ArrayList<>(t);
		if ((line = scanner.nextLine()).isEmpty()){
			line = scanner.nextLine();
		}
		words.add(line);
		for (int i = 1; i < t; i++) {
			words.add(scanner.nextLine());
		}
		countVersions(strings, words);
	}

	private static void countVersions(List<String> strings, List<String> words) {
		int result = 0;
		for (String word : words) {
			for (String s : strings) {
				String usVersion = word.replaceAll("our", "or");
				Pattern p = Pattern.compile("\\b(" + word + "|" + usVersion + ")\\b");
				Matcher m = p.matcher(s);
				while (m.find()) {
					result += 1;
				}
			}
			System.out.println(result);
			result = 0;
		}
	}
}
