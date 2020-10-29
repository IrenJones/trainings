package leetcode.easy;

public class HeightChecker {

	public static void main(String[] args) {
		System.out.println(heightChecker(new int[]{2,1,2,1,1,2,2,1}) == 4);
		System.out.println(heightChecker(new int[]{1,1,4,2,1,3}) == 3);
		System.out.println(heightChecker(new int[]{5,1,2,3,4}) == 5);
		System.out.println(heightChecker(new int[]{1, 2, 3, 4, 5}) == 0);
	}

	public static int heightChecker(int[] heights) {
		int[] heightsCount  = new int[101];

		// help us to determine positions of sorted array
		for(int i=0; i<heights.length; i++){
			heightsCount[heights[i]]++;
		}

		int result = 0;
		int currentIndex = 0;
		int i = 1;
		while (i < 101 && currentIndex < heights.length){
			if(heightsCount[i] == 0){
				i++;
				continue;
			}
			if(heights[currentIndex] != i){
				result++;
			}
			heightsCount[i]--;
			currentIndex++;
		}
		return result;
	}
}
