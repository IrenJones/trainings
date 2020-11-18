package leetcode.easy;

public class FlippingImage {

	public static void main(String[] args) {
		int[][] A = {
				{1,1,0,0},
				{1,0,0,1},
				{0,1,1,1},
				{1,0,1,0}
		};

		flipAndInvertImage(A);
	}

	public static int[][] flipAndInvertImage(int[][] A) {
		if(A.length == 0 || A[0].length == 0) {
			return A;
		}

		int tmp;
		for(int i=0; i< A.length; i++) {
			for(int j=0; j <= A[0].length/2; j++) {
				if(A[0].length % 2 == 1 && j == A[0].length/2) {
					A[i][j] ^= 1;
				} else if(j != A[0].length/2){
					tmp = A[i][j];
					A[i][j] = A[i][A[0].length - 1 - j] ^ 1;
					A[i][A[0].length - 1 - j] = tmp ^ 1;
				}
			}
		}

		return A;
	}
}
