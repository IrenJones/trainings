package leetcode.medium;

import java.util.Stack;

public class DecodeString {

	public static void main(String[] args) {
		System.out.println(decodeString("3[z]2[2[y]pq4[2[jk]e1[f]]]ef"));
		System.out.println(decodeString("3[a2[c]]"));
		System.out.println(decodeString("ea2[a]ea4[c]"));
		System.out.println(decodeString("ea3[a2[c]]"));
		System.out.println(decodeString("ea3[a2[cd]]"));
	}

	public static String decodeString(String s) {
		if(s.length() < 3) {
			return s;
		}

		Stack<Integer> countStack = new Stack<>();
		Stack<StringBuilder> subStringStack = new Stack<>();
		StringBuilder substring = new StringBuilder();
		int count = 0;

		StringBuilder tmp;
		for(char c: s.toCharArray()) {
			if(Character.isDigit(c)) {
				count = count * 10 + Character.digit(c, 10);
			} else if(c == '['){
				countStack.push(count);
				count = 0;
				subStringStack.push(substring);
				substring = new StringBuilder();
			} else if(c == ']'){
				tmp = subStringStack.pop();
				for(int i = countStack.pop(); i > 0; i--) {
					tmp.append(substring);
				}
				substring = tmp;
			} else{
				substring.append(c);
			}
		}

		return substring.toString();
	}
}
