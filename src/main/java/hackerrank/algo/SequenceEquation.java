package hackerrank.algo;

import java.util.HashMap;
import java.util.Map;

public class SequenceEquation {
	public static void main(String[] args) {
		int[] result = permutationEquation(new int[]{2, 3, 1});
		for(int v: result){
			System.out.print(v + " ");
		}
		System.out.println();
		result = permutationEquation(new int[]{4, 3, 5, 1, 2});
		for(int v: result){
			System.out.print(v + " ");
		}
	}

	static int[] permutationEquation(int[] p) {
		Map<Integer, Integer> map = new HashMap<>();
		for(int i = 0 ; i< p.length; i++){
			map.put(p[i], i+1);
		}
		int[] res = new int[p.length];
		for(int i = 0; i< p.length; i++){
			// p[2] = 3
			// x = 3 = p[2] = p[p[y] where p[y] = 2]
			int indexOfValue = p[i];
			res[indexOfValue-1] = map.get(i+1);
		}
		return res;
	}
}
