package leetcode.leetcode_by_topics.string;

import java.util.Stack;

public class SimplifyPath {

	public static void main(String[] args) {
		SimplifyPath sp = new SimplifyPath();

		sp.simplifyPath("/home/");
	}

	public String simplifyPath(String path) {
		if(path.length() == 0) {
			return path;
		}

		Stack<String> stack = new Stack<>();

		for(String s: path.split("/")){
			if(s.equals("..")){
				if(!stack.isEmpty()) {
					//up to dir
					stack.pop();
				}
			} else if(!s.equals("") && !s.equals(".")) {
				stack.add(s);
			}
		}

		if(stack.size() == 0) {
			return "/";
		}

		return "/" + String.join("/", stack);
	}
}
