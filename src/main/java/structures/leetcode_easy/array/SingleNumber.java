package structures.leetcode_easy.array;

import java.util.HashMap;
import java.util.Map;

public class SingleNumber {
	public static void main(String[] args) {
		System.out.println(findSingle(new int[]{1,2,3,4,5,6,5,4,3,2,1}));
		System.out.println(singleNumber(new int[]{1,2,3,4,5,6,5,4,3,2,1}));
	}

	public static int findSingle(int[] mas){
		int result = 0;
		for(int i= 0; i< mas.length; i++){
			result = result ^ mas[i];
		}
		return result;
	}

	public static int singleNumber(int[] nums) {
		Map<Integer, Integer> mapa = new HashMap();
		for(int n: nums){
			mapa.put(n, mapa.getOrDefault(n, 0)+1);
		}

		return mapa.entrySet().stream()
				.filter(e -> e.getValue() == 1)
				.map(e -> e.getKey())
				.findFirst()
				.get();
	}
}
