package leetcode.leetcode_by_topics.array;

import java.util.LinkedList;
import java.util.List;

public class AddToArrayFormOfInteger {

	public static void main(String[] args) {
		addToArrayForm(new int[]{2, 1, 5}, 806);
		addToArrayForm(new int[]{2,7,4}, 181);
	}

	public static List<Integer> addToArrayForm(int[] A, int K) {
		int tmp = 0;
		LinkedList<Integer> list = new LinkedList<>();
		int index = A.length - 1;
		int value;
		while(true) {
			if(index < 0 && K == 0) {
				break;
			} else if(index < 0) {
				while(K > 0) {
					value = K % 10 + tmp ;
					list.addFirst(value % 10);
					K = K / 10;
					tmp = value / 10;
				}
				break;
			} else if (K == 0) {
				while(index >= 0) {
					value = A[index] + tmp ;
					list.addFirst(value % 10);
					index--;
					tmp = value / 10;
				}
			} else {
				value = K % 10 + tmp + A[index];
				list.addFirst(value % 10);
				index--;
				K = K / 10;
				tmp = value / 10;
			}
		}
		if(tmp != 0) {
			list.addFirst(tmp);
		}
		return list;
	}

}
