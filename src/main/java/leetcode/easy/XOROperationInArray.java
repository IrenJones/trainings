package leetcode.easy;

public class XOROperationInArray {
	public static void main(String[] args) {
		System.out.println(xorOperation(5,0) == 8);
		System.out.println(xorOperation(4,3) == 8);
		System.out.println(xorOperation(1,7) == 7);
		System.out.println(xorOperation(10,5) == 2);
	}

	public static int xorOperation(int n, int start) {
		int result = 0;

		for(int i=0; i< n; i++){
			result = result ^ (start + 2*i);
		}
		return result;
	}
}
