package hackerrank.algo;

public class FindDigits {
	public static void main(String[] args) {
		System.out.println(findDigits(12) == 2);
		System.out.println(findDigits(1012) == 3);
	}

	// Complete the findDigits function below.
	static int findDigits(int n) {
		int result = 0;
		int current = n;
		int digit;
		while(current > 0){
			digit = current % 10;
			if(digit != 0 && n % digit == 0){
				result++;
			}
			current/=10;
		}
		return result;
	}
}
