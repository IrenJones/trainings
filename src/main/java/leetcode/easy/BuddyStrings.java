package leetcode.easy;

public class BuddyStrings {

	public static void main(String[] args) {
		System.out.println(buddyStrings("aaaaaaabc", "aaaaaaabc") == true);
		System.out.println(buddyStrings("aa", "aa") == true);
		System.out.println(buddyStrings("ab", "ab") == false);
		System.out.println(buddyStrings("ab", "ba") == true);
	}

	public static boolean buddyStrings(String A, String B) {
		if (A.length() != B.length()) {
			return false;
		}

		if (A.equals(B)) {
			// check case if have the same letters
			int[] values = new int[26];
			int index;
			for (int i = 0; i < A.length(); i++) {
				index = A.charAt(i) - 'a';
				values[index]++;
			}

			for (int count : values) {
				if (count > 1) {
					return true;
				}
			}
			return false;
		} else {
			int indexOne = -1, indexTwo = -1;
			for (int i = 0; i < A.length(); i++) {
				if (A.charAt(i) != B.charAt(i)) {
					if (indexOne == -1) {
						indexOne = i;
					} else if (indexTwo == -1) {
						indexTwo = i;
					} else {
						// have more than 3 diffs
						return false;
					}
				}
			}

			// not enough diffs
			if (indexOne == -1 || indexTwo == -1) {
				return false;
			}

			return (A.charAt(indexOne) == B.charAt(indexTwo) && A.charAt(indexTwo) == B.charAt(indexOne));
		}
	}
}
