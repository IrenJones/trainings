package leetcode.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class GoatLatin {

	static Set<Character> chars = new HashSet<>(
			Arrays.asList(
				'a', 'o', 'i', 'u', 'e',
					'A', 'O', 'I', 'U', 'E'
			));

	public static void main(String[] args) {
		System.out.println(toGoatLatin("I speak Goat Latin").equals("Imaa peaksmaaa oatGmaaaa atinLmaaaaa"));
		System.out.println(toGoatLatin("The quick brown fox jumped over the lazy dog").equals("heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa"));
	}

	public static String toGoatLatin(String S) {
		String[] s = S.split(" ");

		StringBuilder sb = new StringBuilder();
		StringBuilder aSb = new StringBuilder();

		for(int i=0; i< s.length; i++) {
			if(isVowel(s[i].charAt(0))) {
				sb.append(s[i]);
			} else {
				for(int j=1; j< s[i].length(); j++) {
					sb.append(s[i].charAt(j));
				}
				sb.append(s[i].charAt(0));
			}
			sb.append("ma");
			aSb.append('a');
			sb.append(aSb);
			if(i < s.length -1){
				sb.append(" ");
			}
		}
		return sb.toString();
	}

	private static boolean isVowel(char c) {
		return chars.contains(c);
	}
}
