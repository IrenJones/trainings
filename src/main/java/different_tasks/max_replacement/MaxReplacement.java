package different_tasks.max_replacement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class MaxReplacement {

	public static void main(String[] args) {
		balancedOrNot(Arrays.asList("<>", "<>><>", "<<<><>",
				"<>><<<><><<<<>><><><<<<><><><<>><><<>>>>><<<><<<>><>>><>><><><<><>><><><<<<><>>><<<<<<<<><<<><<>>><><>>>><><<><<>>>><>>><><<<>><<>>>>><<><>>>><<<<<<><<<><>><<<>>><<<<<<<><<><>><>><><><><>>><<><><><><<<>>><<><>><<><>><><><<<>>><<>>>>>><><<<<>>><<<<<>><<><>><>><<><>>><<><<<<<<<<><<>>>><>><<><<><><>><<<>><<><><<><><<><><>><><<<<<<<><>>><<>>><><><<<<><<<><<><<><<>>><<><<<><><>><>>>><><><<<>>><<>>><<<><>>><<<><<>>>>><><<<><<><><>><>>><><<><>>><><<<<><><><>>>><<>><>>>>>><><>><<>>><<<<<<><><<><<>><><><><><<>>><>>>>><<><<<><>><<><<<>><<<<>>>>>><><<<<<<><<><<>><><>>>><>><>><<><>>><<><<<>><<>>>>>><>>><<<>><<<<<>><>><<>><<<<><><>><><><><><>><>>><<>>><<>>>>><><<<<><>><<<><<><>><<<>>>><><<><<><<><<>>><>>>><<<><><<><><><><><>>><>>>><><<><<<<<<>><><<<<<<<<>><>>><<><><<<>><><<<><<><<>>>><<><<<<><><>><<<><<><<<<<<<<<<<<<>>>><><>>>><<<><<>>>><>><><><<<<><>><<<<>>>><>>><<><><><><<><<>>>>><><<<<><<<>>>>><<>>>>><<><<><>><><<><><<>><<><<<<>>>>><<<><<<<<>>>><>><<><<>><<><>>><<>>><><><>><<<><<><><<><<><<><<<><<<<<>>><<>>><>>><<><<<>"),
				Arrays.asList(1, 1, 2, 436))
				.forEach(System.out::println);
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
		Stack<Character> stack = new Stack<>();
		char cur, prev;
		for (int l = 0; l < expressions.size(); l++) {
			String s = expressions.get(l);
			int max = maxReplacements.get(l);
			if (s.length() > 0) {
				stack.push(s.charAt(0));
				int i =1;
				while (i < s.length()) {
					cur = s.charAt(i);
					if (!stack.isEmpty()) {
						prev = stack.pop();
						if (prev == '<' && cur == '<') {
							result.add(0);
							stack.empty();
							break;
						}
					} else if (cur == '>') {
						if (max > 0) {
							max--;
						} else {
							result.add(0);
							break;
						}
					} else {
						stack.push(cur);
					}
					i++;
				}
				if (result.size() < l + 1) {
					if (!stack.isEmpty()) {
						if (stack.pop() == '<') {
							result.add(0);
						} else {
							result.add(max > 0 ? 1 : 0);
						}
					} else {
						result.add(1);
					}
				}
				stack.empty();
			} else {
				result.add(0);
			}
		}
		return result;
	}
}
