package leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MinimumDominoRotationsForEqualRow {

	public static void main(String[] args) {
		System.out.println(minDominoRotations(new int[]{2,3,2,1,1,1,2,2}, new int[]{2,1,2,1,1,3,1,1}) == -1);
		System.out.println(minDominoRotations(new int[]{2,1,2,2,2,2}, new int[]{1,2,1,1,1,1}) == 1);
		System.out.println(minDominoRotations(new int[]{2,1,2,2,2,2}, new int[]{2,2,3,2,2,2}) == 1);
		System.out.println(minDominoRotations(new int[]{2,1,2,4,2,2}, new int[]{5,2,6,2,3,2}) == 2);
		System.out.println(minDominoRotations(new int[]{3,5,1,2,3}, new int[]{3,6,3,3,4}) == -1);
	}

	public static int minDominoRotationsShorter(int[] A, int[] B) {
		int[] aCount = new int[6];
		int[] bCount = new int[6];
		int[] both = new int[6];

		for(int i=0; i< A.length; i++) {
			aCount[A[i] - 1]++;
			bCount[B[i] - 1]++;
			if(A[i] == B[i]) {
				both[A[i] - 1]++;
			}
		}

		int minRotations = A.length - 1;
		int currentRotations;
		int value;
		for(int i=0; i< aCount.length; i++) {
			value = aCount[i] + bCount[i] - both[i];
			if(value == A.length) {
				currentRotations = A.length - Math.max(aCount[i], bCount[i]);
				if(currentRotations < minRotations) {
					minRotations = currentRotations;
				}
			}
		}
		return minRotations == A.length - 1 ? -1 : minRotations;
	}

	public static int minDominoRotations(int[] A, int[] B) {
		Map<Integer, Map<Integer, Integer>> map = new HashMap<>();

		Map<Integer, Integer> localMap;
		for(int i=0; i < A.length; i++) {
			if(map.containsKey(A[i])) {
				localMap = map.get(A[i]);
			} else{
				localMap = new HashMap<>();
			}
			localMap.put(i, 1);
			map.put(A[i], localMap);

			if(map.containsKey(B[i])) {
				localMap = map.get(B[i]);
			} else{
				localMap = new HashMap<>();
			}
			localMap.put(i, localMap.getOrDefault(i, 0) - 1);
			map.put(B[i], localMap);
		}

		List<Map<Integer, Integer>> entries = map.entrySet()
				.stream()
				.filter(e -> e.getValue().size() == A.length)
				.map(e -> e.getValue())
				.collect(Collectors.toList());

		int minRotations = A.length - 1;
		int countA = 0;
		int countB = 0;
		for(int i=0; i< entries.size(); i++) {
			localMap = entries.get(i);
			for(int v: localMap.values()) {
				if(v > 0) {
					countA++;
				} else if (v < 0){
					countB++;
				}
			}
			if(Math.min(countA, countB) < minRotations) {
				minRotations = Math.min(countA, countB);
			}
			countA = 0;
			countB = 0;
		}
		return minRotations == A.length - 1 ? -1 : minRotations;
	}
}
