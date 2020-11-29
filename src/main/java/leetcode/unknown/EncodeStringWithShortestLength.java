package leetcode.unknown;

public class EncodeStringWithShortestLength {

	// The encoding rule is: k[encoded_string], where the encoded_string inside the square
	// brackets is being repeated exactly k times.
	// If an encoding process does not make the string shorter, then do not encode it.
	// If there are several solutions, return any of them is fine
	public static void main(String[] args) {
		System.out.println(encode("aaaaaaaaaa").equals("10[a]"));
		System.out.println(encode("abbbabbbcabbbabbbc").equals("2[2[abbb]c]"));
		System.out.println(encode("aaa").equals("aaa"));
	}

	public static String encode(String s) {
		return "";
	}
}
