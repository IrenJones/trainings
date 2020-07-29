package hackerrank.algo;

import javax.validation.constraints.AssertTrue;

public class LonelyIntegerBitOperation {

	public static void main(String[] args) {
		System.out.println(lonelyinteger(new int[]{1,0,0,1,3}) == 3);
	}

	static int lonelyinteger(int[] a) {
		int result = 0;
		for (int value : a) {
			result = result ^ value;
		}
		return result;
	}
}
