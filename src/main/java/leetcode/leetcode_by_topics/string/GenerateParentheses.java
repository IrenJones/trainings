package leetcode.leetcode_by_topics.string;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

	public static void main(String[] args) {
		GenerateParentheses solution = new GenerateParentheses();
		solution.generateParenthesis(3);
	}

	public List<String> generateParenthesis(int n) {
		List<String> result = new ArrayList<>();

		backTracking(n, n, new StringBuilder(), result);

		return result;
	}


	public void backTracking(int open, int closed, StringBuilder current,
							 List<String> result) {
		if (open == 0 && closed == 0) {
			result.add(current.toString());
			return;
		}

		if (open > 0) {
			current.append('(');
			backTracking(open - 1, closed, new StringBuilder(current), result);
			current.deleteCharAt(current.length() - 1);
		}
		if (open < closed) {
			current.append(')');
			backTracking(open, closed - 1, new StringBuilder(current), result);
			current.deleteCharAt(current.length() - 1);
		}
	}
}
