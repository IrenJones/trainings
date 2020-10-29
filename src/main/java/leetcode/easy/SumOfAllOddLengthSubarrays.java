package leetcode.easy;

public class SumOfAllOddLengthSubarrays {

	public static void main(String[] args) {
		System.out.println(sumOddLengthSubarrays(new int[]{1,4,2,5,3}) == 58);
	}

	public static int sumOddLengthSubarrays(int[] arr) {
		int result = 0;
		int cur = 0;
		for(int i=1; i<=arr.length; i+=2) {
			for(int j=0; j<=arr.length-i; j++){
				for(int k=j; k<j+i; k++) {
					cur+=arr[k];
				}
				result+=cur;
				cur = 0;
			}
		}
		return result;
	}

	public static int sumOddLengthSubarraysBetter(int[] arr) {
		int res = 0, n = arr.length;
		for (int i = 0; i < n; ++i) {
			res += ((i + 1) * (n - i) + 1) / 2 * arr[i];
		}
		return res;
	}
}
