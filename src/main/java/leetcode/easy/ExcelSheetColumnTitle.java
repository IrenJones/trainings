package leetcode.easy;

public class ExcelSheetColumnTitle {

	public static void main(String[] args) {
		System.out.println(convertToTitle(26));
		System.out.println(convertToTitle(27));
		System.out.println(convertToTitle(52));
		System.out.println(convertToTitle(53));
	}

	public static String convertToTitle(int n) {
		StringBuilder result = new StringBuilder();
		while(n != 0){
			int value = n % 26;
			char current = value==0 ? 'Z':(char)(value + 'A' - 1);
			result.append(current);
			n = value == 0 ? (n/26) - 1 : n/26;
		}
		return result.reverse().toString();
	}
}
