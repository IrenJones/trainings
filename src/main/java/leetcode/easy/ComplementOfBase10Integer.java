package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class ComplementOfBase10Integer {
	public static void main(String[] args) {
		System.out.println(bitwiseComplement(0) == 1);
		System.out.println(bitwiseComplement(5) == 2);
		System.out.println(bitwiseComplement(7) == 0);
		System.out.println(bitwiseComplement(10) == 5);


		System.out.println(bitwiseComplementSmart(0) == 1);
		System.out.println(bitwiseComplementSmart(5) == 2);
		System.out.println(bitwiseComplementSmart(7) == 0);
		System.out.println(bitwiseComplementSmart(10) == 5);
	}

	public static int bitwiseComplement(int N) {
		int result = 0;

		List<Integer> tmp = new ArrayList<>();

		if (N == 0){
			return 1;
		}

		while(N > 0) {
			tmp.add(N - N/2*2 == 0 ? 1 : 0);
			N = N/2;
		}

		for(int i =0; i< tmp.size(); i++) {
			result+= tmp.get(i) * Math.pow(2, i);
		}

		return result;
	}

	public static int bitwiseComplementSmart(int N) {
		int sum = 1;
		while (N > sum) {
			sum = sum * 2 + 1;
		}
		return sum ^ N;
	}

}
