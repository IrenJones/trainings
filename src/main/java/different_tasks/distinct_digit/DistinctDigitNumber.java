package different_tasks.distinct_digit;

import different_tasks.max_replacement.MaxReplacementSecondVersion;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class DistinctDigitNumber {

	static class FilesForChecking {
		List<List<Integer>> input;
		List<Integer> output;

		public FilesForChecking() {
		}

		public List<List<Integer>> getInput() {
			return input;
		}

		public void setInput(List<List<Integer>> input) {
			this.input = input;
		}

		public List<Integer> getOutput() {
			return output;
		}

		public void setOutput(List<Integer> output) {
			this.output = output;
		}
	}

	public static void main(String[] args) throws FileNotFoundException {

		FilesForChecking files1 = readData("src/main/java/different_tasks/distinct_digit/input001.txt",
				"src/main/java/different_tasks/distinct_digit/output001.txt");
		List<Integer> result1 = getDistinctDigitNumbers(files1.input);
		boolean result = true;
		for (int i = 0; i < result1.size(); i++) {
			if (result1.get(i) != files1.output.get(i)) {
				result = false;
				break;
			}
		}
		System.out.println(result);
	}

	public static FilesForChecking readData(String inputName, String outputName) throws FileNotFoundException {
		FilesForChecking files = new FilesForChecking();
		List<List<Integer>> input = new ArrayList<>();
		List<Integer> output = new ArrayList<>();

		File file = new File(inputName);
		Scanner scanner = new Scanner(file);
		int n = Integer.parseInt(scanner.nextLine().trim());
		int m = Integer.parseInt(scanner.nextLine().trim());
		for (int i = 0; i < n; i++) {
			List<Integer> s = Stream.of(
					scanner.nextLine()
							.replaceAll("\\s+$", "")
							.split(" "))
					.map(Integer::parseInt)
					.collect(toList());
			input.add(s);
		}

		file = new File(outputName);
		scanner = new Scanner(file);
		for (int i = 0; i < n; i++) {
			output.add(Integer.parseInt(scanner.nextLine().trim()));
		}
		files.setInput(input);
		files.setOutput(output);
		return files;
	}

	public static List<Integer> getDistinctDigitNumbers(List<List<Integer>> list) {
		List<Integer> result = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			List<Integer> row = list.get(i);
			if (row.get(0) == row.get(1)) {
				result.add(1);
			} else {
				int count = 0;
				for (int value = row.get(0); value <= row.get(1); value++) {
					if (!containsDuplicateDigits(value)) {
						count++;
					}
				}
				result.add(count);
			}
		}
		return result;
	}

	private static boolean containsDuplicateDigits(int value) {
		boolean result = false;
		Map<Integer, Integer> map = new HashMap<>();
		int v;
		while (value > 0) {
			v = value % 10;
			map.put(v, map.getOrDefault(v, 0) + 1);
			value = value / 10;
		}

		return map.entrySet()
				.stream()
				.anyMatch(e -> e.getValue() > 1);
	}
}
