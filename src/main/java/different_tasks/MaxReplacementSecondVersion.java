package different_tasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

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

	public static void main(String[] args) {
		balancedOrNot(Arrays.asList("<>", "<>><>", "<<<><>",
				"<>><<<><><<<<>><><><<<<><><><<>><><<>>>>><<<><<<>><>>><>><><><<><>><><><<<<><>>><<<<<<<<><<<><<>>><><>>>><><<><<>>>><>>><><<<>><<>>>>><<><>>>><<<<<<><<<><>><<<>>><<<<<<<><<><>><>><><><><>>><<><><><><<<>>><<><>><<><>><><><<<>>><<>>>>>><><<<<>>><<<<<>><<><>><>><<><>>><<><<<<<<<<><<>>>><>><<><<><><>><<<>><<><><<><><<><><>><><<<<<<<><>>><<>>><><><<<<><<<><<><<><<>>><<><<<><><>><>>>><><><<<>>><<>>><<<><>>><<<><<>>>>><><<<><<><><>><>>><><<><>>><><<<<><><><>>>><<>><>>>>>><><>><<>>><<<<<<><><<><<>><><><><><<>>><>>>>><<><<<><>><<><<<>><<<<>>>>>><><<<<<<><<><<>><><>>>><>><>><<><>>><<><<<>><<>>>>>><>>><<<>><<<<<>><>><<>><<<<><><>><><><><><>><>>><<>>><<>>>>><><<<<><>><<<><<><>><<<>>>><><<><<><<><<>>><>>>><<<><><<><><><><><>>><>>>><><<><<<<<<>><><<<<<<<<>><>>><<><><<<>><><<<><<><<>>>><<><<<<><><>><<<><<><<<<<<<<<<<<<>>>><><>>>><<<><<>>>><>><><><<<<><>><<<<>>>><>>><<><><><><<><<>>>>><><<<<><<<>>>>><<>>>>><<><<><>><><<><><<>><<><<<<>>>>><<<><<<<<>>>><>><<><<>><<><>>><<>>><><><>><<<><<><><<><<><<><<<><<<<<>>><<>>><>>><<><<<>",
				"<>>><>><><<<<>><><<<><>>><>><<<<><<<><><<><<<<<<><<><",
				"<<><>>>><><<<>><<><>>>>><<<><><<<>>>>>",
				"<<<>>>><><>>>>>"),
				Arrays.asList(1, 1, 2, 436, 5, 11, 10))
				.forEach(System.out::println);

		FilesForChecking files1 = readData("", "");
		List<Integer> result1 = balancedOrNot(files1.input, files1.inputRepl);
		boolean result = true;
		for(int i=0; i< result1.size(); i++){
			if(result1.get(i) != files1.output.get(i)){
				result = false;
				break;
			}
		}
		System.out.println(result);
	}

	public static FilesForChecking readData(String inputName, String outputName){
		FilesForChecking files = new FilesForChecking();
		List<String> input = new ArrayList<>();
		List<Integer> inputRepl = new ArrayList<>();
		List<Integer> output = new ArrayList<>();


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
				}
				for(int j=0; j< s.length(); j++){
					if(s.charAt(j) == '<'){
						indexesOpen.add(j);
					} else{
						indexesClosed.add(j);
					}
				}
				if(indexesOpen.size() > indexesClosed.size()){
					result.add(0);
				} else if( indexesClosed.size() - indexesOpen.size() > maxReplacements.get(i)){
					result.add(0);
				} else{
					while(!indexesClosed.isEmpty() && !indexesOpen.isEmpty()){
						int removedOpened = indexesOpen.peek();
						int removedClosed = indexesClosed.remove();
						if(removedOpened < removedClosed){
							// everything is ok, continue
							indexesOpen.remove();
							continue;
						} else {
							indexesClosed.add(removedClosed);
						}
					}
					if(indexesClosed.isEmpty() && indexesOpen.isEmpty()){
						result.add(1);
					} else if( indexesClosed.size() <= maxReplacements.get(i)){
						result.add(1);
					} else{
						result.add(0);
					}
				}
				indexesOpen.clear();
				indexesClosed.clear();
			} else {
				result.add(0);
			}
		}
		return result;
	}
}
