package leetcode.easy;

public class SplitStringToBalancedStrings {
	public static void main(String[] args) {
		System.out.println(balancedStringSplit("RLRRLLRLRL") == 4);
		System.out.println(balancedStringSplit("RLLLLRRRLR") == 3);
		System.out.println(balancedStringSplit("LLLLRRRR") == 1);
	}

	public static int balancedStringSplit(String s) {
		// L -1
		// R +1

		int result = 0;
		int count = 0;

		for(int i=0; i< s.length(); i++){
			count+= s.charAt(i) == 'R'?
					1:
					-1;
			if(count == 0){
				result++;
			}
		}
		return result;
	}
}
