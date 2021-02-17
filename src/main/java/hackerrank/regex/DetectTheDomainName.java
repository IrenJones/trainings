package hackerrank.regex;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DetectTheDomainName {

	public static void main(String[] args) {
		List<String> strings = new ArrayList<>();
		Scanner in = new Scanner(System.in);
		int n = Integer.parseInt(in.nextLine().trim());
		int row = 0;
		while (row < n) {
			strings.add(in.nextLine());
			row++;
		}

		DetectTheDomainName solution = new DetectTheDomainName();
		System.out.println(solution.getDomains(strings));
	}

	public String getDomains(List<String> lines){
		StringBuilder sb = new StringBuilder();

		Pattern pattern = Pattern.compile("http[s]?:\\/\\/((ww[w2]?|web)\\.)?(([a-zA-Z0-9\\-]+\\.)+[a-zA-Z0-9-]+)");

		Set<String> set = new TreeSet<>();

		for(String line: lines) {
			Matcher matcher = pattern.matcher(line);
			while (matcher.find()) {
				set.add(matcher.group(3));
			}
		}

		for(String s: set) {
			sb.append(s + ";");
		}

		sb.deleteCharAt(sb.length() - 1);

		return sb.toString();
	}
}
