package different_tasks.sdet;

public class DigitSum {
	// Write a program to find sum of each digit of a given number using recursion
	public static void main(String[] args) {
		System.out.println(getSumOfDigits(13) == 4);
		System.out.println(getSumOfDigits(1) == 1);
		System.out.println(getSumOfDigits(0) == 0);
		System.out.println(getSumOfDigits(126) == 9);
	}

	public static int getSumOfDigits(int value){
		if (value < 10){
			return value;
		}
		return getSumOfDigits(value/10) + value%10;
	}
}
