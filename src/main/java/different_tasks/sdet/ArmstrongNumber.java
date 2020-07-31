package different_tasks.sdet;


import java.util.ArrayList;
import java.util.List;

public class ArmstrongNumber {
	public static void main(String[] args) {
		System.out.println(!check(8204));
		System.out.println(check(8208));
		System.out.println(check(153));
		System.out.println(check(370));
		System.out.println(check(371));
		System.out.println(check(407));
	}

	private static boolean check(int inputValue) {
		int sum = 0;
		int current = inputValue;
		int countDigit = countDigit(inputValue);
		for(int i=0; i< countDigit; i++){
			sum = sum + (int)Math.pow(current%10, countDigit);
			current = current/10;
		}
		return sum == inputValue;
	}

	static int countDigit(long n) {
		return (int) Math.floor(Math.log10(n) + 1);
	}
}
