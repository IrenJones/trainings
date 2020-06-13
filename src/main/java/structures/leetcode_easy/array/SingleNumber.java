package structures.leetcode_easy.array;

public class SingleNumber {
	public static void main(String[] args) {
		System.out.println(findSingle(new int[]{1,2,3,4,5,6,5,4,3,2,1}));
	}

	public static int findSingle(int[] mas){
		int result = 0;
		for(int i= 0; i< mas.length; i++){
			result = result ^ mas[i];
		}
		return result;
	}
}
