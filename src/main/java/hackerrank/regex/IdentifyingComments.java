package hackerrank.regex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IdentifyingComments {

	public static void main(String[] args) throws IOException {
		List<String> strings = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s;
		while ((s = br.readLine()) != null) {
			sb.append(s.trim()).append("\n");
			strings.add(s);
		}

		IdentifyingComments solution = new IdentifyingComments();
		solution.findCommentsBetter(sb);
		//solution.findComments(strings).forEach(System.out::println);
	}

	private List<String> findComments(List<String> lines) {
		List<String> result = new ArrayList<>();
		Pattern patternSingle = Pattern.compile("\\/\\/\\s*(.*)");
		Pattern patternStart = Pattern.compile("\\/\\*\\s*(.*)");
		Pattern patternEnd = Pattern.compile("(.*)\\s*\\*\\/");
		boolean opened = false;
		Matcher single, start, end;
		for (String line : lines) {
			single = patternSingle.matcher(line);
			start = patternStart.matcher(line);
			end = patternEnd.matcher(line);

			if (opened) {
				if (end.find()) {
					opened = false;
					result.add(end.group(0).trim());
				} else {
					result.add(line.trim());
				}
			} else {
				if (start.find()) {
					if (end.find()) {
						Matcher matcher = Pattern.compile("\\/\\*\\s*(.*)\\s*\\*\\/").matcher(line);
						if (matcher.find()) {
							result.add(matcher.group().trim());
						}
					} else {
						opened = true;
						result.add(start.group(0).trim());
					}
				}

				if (single.find() && !opened) {
					result.add(single.group(0).trim());
				}
			}
		}
		return result;
	}

	private void findCommentsBetter(StringBuilder sb) {
		Pattern p = Pattern.compile("(\\/\\/.*|\\/\\*[\\*]?[^(\\*\\/)]+[^\\/]+.)");
		Matcher m = p.matcher(sb.toString());
		while (m.find()) {
			System.out.println(m.group(1));
		}
	}
}
