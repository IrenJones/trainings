package leetcode.easy;

public class DetectCapital {

	public static void main(String[] args) {
		System.out.println(detectCapitalUse("Hello"));
		System.out.println(detectCapitalUse("leetcode"));
		System.out.println(detectCapitalUse("USA"));
		System.out.println(detectCapitalUse("leetCode"));
		System.out.println(detectCapitalUseRegex("Hello"));
		System.out.println(detectCapitalUseRegex("leetcode"));
		System.out.println(detectCapitalUseRegex("USA"));
		System.out.println(detectCapitalUseRegex("leetCode"));
	}

	public static boolean detectCapitalUse(String word) {
		if(word.length() > 0){
			int detectedUppers = 0;
			boolean firstIsUpper = false;
			for(int i=0; i< word.length(); i++){
				if(i == 0 && (int)word.charAt(i) >= 65 && (int)word.charAt(i) <= 90) {
					detectedUppers++;
					firstIsUpper = true;
				} else if ((int)word.charAt(i) >= 65 && (int)word.charAt(i) <= 90) {
					detectedUppers++;
				}
			}
			if(detectedUppers == word.length() || detectedUppers == 1 && firstIsUpper || detectedUppers == 0){
				return true;
			}
		}
		return false;
	}

	public static boolean detectCapitalUseRegex(String word) {
		return word.matches("[A-Z]*|[a-z]*|[A-Z][a−z]*");
	}
}
