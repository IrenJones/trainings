package different_tasks.max_replacement;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class MaxReplacementSecondVersion {

	static class FilesForChecking{
		List<String> input;
		List<Integer> inputRepl;
		List<Integer> output;

		public FilesForChecking(){}

		public List<String> getInput() {
			return input;
		}

		public void setInput(List<String> input) {
			this.input = input;
		}

		public List<Integer> getInputRepl() {
			return inputRepl;
		}

		public void setInputRepl(List<Integer> inputRepl) {
			this.inputRepl = inputRepl;
		}

		public List<Integer> getOutput() {
			return output;
		}

		public void setOutput(List<Integer> output) {
			this.output = output;
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		balancedOrNot(Arrays.asList("<><", "<>", "<>><>", "<<<><>",
				"<>><<<><><<<<>><><><<<<><><><<>><><<>>>>><<<><<<>><>>><>><><><<><>><><><<<<><>>><<<<<<<<><<<><<>>><><>>>><><<><<>>>><>>><><<<>><<>>>>><<><>>>><<<<<<><<<><>><<<>>><<<<<<<><<><>><>><><><><>>><<><><><><<<>>><<><>><<><>><><><<<>>><<>>>>>><><<<<>>><<<<<>><<><>><>><<><>>><<><<<<<<<<><<>>>><>><<><<><><>><<<>><<><><<><><<><><>><><<<<<<<><>>><<>>><><><<<<><<<><<><<><<>>><<><<<><><>><>>>><><><<<>>><<>>><<<><>>><<<><<>>>>><><<<><<><><>><>>><><<><>>><><<<<><><><>>>><<>><>>>>>><><>><<>>><<<<<<><><<><<>><><><><><<>>><>>>>><<><<<><>><<><<<>><<<<>>>>>><><<<<<<><<><<>><><>>>><>><>><<><>>><<><<<>><<>>>>>><>>><<<>><<<<<>><>><<>><<<<><><>><><><><><>><>>><<>>><<>>>>><><<<<><>><<<><<><>><<<>>>><><<><<><<><<>>><>>>><<<><><<><><><><><>>><>>>><><<><<<<<<>><><<<<<<<<>><>>><<><><<<>><><<<><<><<>>>><<><<<<><><>><<<><<><<<<<<<<<<<<<>>>><><>>>><<<><<>>>><>><><><<<<><>><<<<>>>><>>><<><><><><<><<>>>>><><<<<><<<>>>>><<>>>>><<><<><>><><<><><<>><<><<<<>>>>><<<><<<<<>>>><>><<><<>><<><>>><<>>><><><>><<<><<><><<><<><<><<<><<<<<>>><<>>><>>><<><<<>",
				"<>>><>><><<<<>><><<<><>>><>><<<<><<<><><<><<<<<<><<><",
				"<<><>>>><><<<>><<><>>>>><<<><><<<>>>>>",
				"<<<>>>><><>>>>>"),
				Arrays.asList(1, 1, 1, 2, 436, 5, 11, 10))
				.forEach(System.out::println);

		FilesForChecking files1 = readData("src/main/java/different_tasks/max_replacement/input004.txt",
				"src/main/java/different_tasks/max_replacement/output004.txt");
		List<Integer> result1 = balancedOrNot(files1.input, files1.inputRepl);
		for(int i=0; i< result1.size(); i++){
			if(result1.get(i) != files1.output.get(i)){
				System.out.println(files1.input.get(i) + "  " + result1.get(i) + " instead of " + files1.output.get(i));
				System.out.println("Max repl: " + files1.inputRepl.get(i));
			}
		}

		FilesForChecking files2 = readData("src/main/java/different_tasks/max_replacement/input008.txt",
				"src/main/java/different_tasks/max_replacement/output008.txt");
		List<Integer> result2 = balancedOrNot(files2.input, files2.inputRepl);
		for(int i=0; i< result2.size(); i++){
			if(result2.get(i) != files2.output.get(i)){
				System.out.println(files2.input.get(i) + "  " + result2.get(i) + " instead of " + files2.output.get(i));
				System.out.println("Max repl: " + files2.inputRepl.get(i));
			}
		}

		FilesForChecking files3 = readData("src/main/java/different_tasks/max_replacement/input001.txt",
				"src/main/java/different_tasks/max_replacement/output001.txt");
		List<Integer> result3 = balancedOrNot(files3.input, files3.inputRepl);
		for(int i=0; i< result3.size(); i++){
			if(result3.get(i) != files3.output.get(i)){
				System.out.println(files3.input.get(i) + "  " + result3.get(i) + " instead of " + files3.output.get(i));
				System.out.println("Max repl: " + files3.inputRepl.get(i));
			}
		}
	}

	public static FilesForChecking readData(String inputName, String outputName) throws FileNotFoundException {
		FilesForChecking files = new FilesForChecking();
		List<String> input = new ArrayList<>();
		List<Integer> inputRepl = new ArrayList<>();
		List<Integer> output = new ArrayList<>();

		File file = new File(inputName);
		Scanner scanner = new Scanner(file);
		int n = Integer.parseInt(scanner.nextLine().trim());
		for(int i=0; i< n; i++){
			input.add(scanner.nextLine().trim());
		}
		scanner.nextLine();
		for(int i=0; i< n; i++){
			inputRepl.add(Integer.parseInt(scanner.nextLine().trim()));
		}
		file = new File(outputName);
		scanner = new Scanner(file);
		for(int i=0; i< n; i++){
			output.add(Integer.parseInt(scanner.nextLine().trim()));
		}
		files.setInput(input);
		files.setInputRepl(inputRepl);
		files.setOutput(output);
		return files;
	}
	/*
	 * Complete the 'balancedOrNot' function below.
	 *
	 * The function is expected to return an INTEGER_ARRAY.
	 * The function accepts following parameters:
	 *  1. STRING_ARRAY expressions
	 *  2. INTEGER_ARRAY maxReplacements
	 */

	public static List<Integer> balancedOrNot(List<String> expressions,
											  List<Integer> maxReplacements) {
		List<Integer> result = new ArrayList<>();

		Queue<Integer> indexesOpen = new LinkedList<>();
		Queue<Integer> indexesClosed= new LinkedList<>();

		for(int i = 0; i < expressions.size(); i++){
			String s = expressions.get(i);
			if (s.length() > 0){
				if(s.charAt(s.length() - 1) == '<'){
					result.add(0);
				} else {
					for (int j = 0; j < s.length(); j++) {
						if (s.charAt(j) == '<') {
							indexesOpen.add(j);
						} else {
							indexesClosed.add(j);
						}
					}
					if (indexesOpen.size() > indexesClosed.size()) {
						result.add(0);
					} else if (indexesClosed.size() - indexesOpen.size() > maxReplacements.get(i)) {
						result.add(0);
					} else {
						processStacks(indexesOpen, indexesClosed, result, maxReplacements.get(i));
					}
					indexesOpen.clear();
					indexesClosed.clear();
				}
			} else {
				result.add(0);
			}
		}
		return result;
	}

	private static void processStacks(Queue<Integer> indexesOpen,
									  Queue<Integer> indexesClosed,
									  List<Integer> result,
									  int maxReplacement) {

		boolean isCycle = false;
		int start = 0;
		int finish = 0;
		List<Integer> list = new LinkedList<>(indexesClosed);
		if (!indexesClosed.isEmpty()) {
			start = indexesClosed.peek();
			finish = list.get(list.size() - 1);
		}
		while (!indexesClosed.isEmpty() && !indexesOpen.isEmpty()) {
			int removedOpened = indexesOpen.peek();
			int removedClosed = indexesClosed.remove();
			if (removedOpened < removedClosed) {
				// everything is ok, continue
				indexesOpen.remove();
				if (finish == removedClosed) {
					list.remove(list.size() - 1);
					if (list.size() > 0) {
						finish = list.get(list.size() - 1);
					}
				} else if (start == removedClosed) {
					list.remove(0);
					if (list.size() > 0) {
						start = list.get(0);
					}
				} else {
					for (int f = 0; f < list.size(); f++) {
						if (list.get(f) == removedClosed) {
							list.remove(f);
							break;
						}
					}
				}
			} else {
				if (removedOpened > finish) {
					isCycle = true;
					break;
				}
				indexesClosed.add(removedClosed);
			}
		}
		if (isCycle) {
			result.add(0);
		} else if (indexesClosed.isEmpty() && indexesOpen.isEmpty()) {
			result.add(1);
		} else if (indexesClosed.size() <= maxReplacement) {
			result.add(1);
		} else {
			result.add(0);
		}
	}
}
