package leetcode.medium;

public class NumbersWithUniqueDigits {

	public static void main(String[] args) {
		System.out.println(countNumbersWithUniqueDigits(2));
		System.out.println(countNumbersWithUniqueDigits(3));
		System.out.println(countNumbersWithUniqueDigits(4));
	}

	public static int countNumbersWithUniqueDigits(int n) {
		if (n == 0){
			return 1;
		} else if (n == 1){
			return 10;
		} else {
			int[] fnArr = new int[n+1];
			fnArr[0] = 0;
			fnArr[1] = 10;
			for(int digitCount = 2; digitCount <= n; digitCount++) {
				int fn = 9;
				for (int i = 1; i < digitCount; i++) {
					fn = fn * (10 - i);
				}
				fnArr[digitCount] = fn;
			}
			int result = 0;
			for(int i = 0; i< n+1; i++){
				result+=fnArr[i];
			}
			return result;
		}
	}
}
