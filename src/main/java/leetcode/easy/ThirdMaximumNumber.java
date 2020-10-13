package leetcode.easy;

public class ThirdMaximumNumber {
	public static void main(String[] args) {
		System.out.println(thirdMax(new int[]{3,2,1}) == 1);
		System.out.println(thirdMax(new int[]{2,1}) == 2);
		System.out.println(thirdMax(new int[]{3, 2, 1, 2}) == 1);
	}

	public static int thirdMax(int[] nums) {
		Integer valueOne = null;
		Integer valueTwo = null;
		Integer valueThree = null;

		for (Integer value : nums) {
			if (!(value.equals(valueOne) ||
					value.equals(valueTwo) ||
					value.equals(valueThree))) {
				if (valueThree == null || value > valueThree) {
					valueOne = valueTwo;
					valueTwo = valueThree;
					valueThree = value;
				} else if (valueTwo == null || value > valueTwo) {
					valueOne = valueTwo;
					valueTwo = value;
				} else if (valueOne == null || value > valueOne) {
					valueOne = value;
				}
			}
		}
		return valueOne == null ? valueThree : valueOne;
	}
}
