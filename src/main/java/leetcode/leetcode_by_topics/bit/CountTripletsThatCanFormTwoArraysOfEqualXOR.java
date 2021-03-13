package leetcode.leetcode_by_topics.bit;

public class CountTripletsThatCanFormTwoArraysOfEqualXOR {

	public static void main(String[] args) {
		CountTripletsThatCanFormTwoArraysOfEqualXOR s = new CountTripletsThatCanFormTwoArraysOfEqualXOR();
		s.countTriplets(new int[]{2,3,1,6,7});
	}

	public int countTriplets(int[] arr) {
		int n = arr.length;
		int count = 0;
		int[][] xor = new int[n][n];
		for(int i = 0; i < n; i++) {
			for(int j = i; j < n; j++) {
				int res = arr[i];
				for(int k = i + 1; k <= j; k++) {
					res = res ^ arr[k];
				}
				xor[i][j] = res;
			}
		}

		for(int i = 0; i < n; i++) {
			for(int j = i + 1; j < n; j++) {
				for(int k = j; k < n; k++) {
					if(xor[i][j - 1] == xor[j][k]) {
						count++;
					}
				}
			}
		}

		return count;
	}
}
