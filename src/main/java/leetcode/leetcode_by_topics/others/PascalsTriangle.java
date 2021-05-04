package leetcode.leetcode_by_topics.others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalsTriangle {
	public static List<List<Integer>> generateOld(int numRows) {
		List<List<Integer>> list = new ArrayList<>();
		for(int i=0; i< numRows; i++){
			int countInLine = i + 1;
			List<Integer> listInside = new ArrayList<>();
			for(int j=0; j< countInLine; j++){
				if(j==0 || countInLine - j == 1){
					listInside.add(1);
				} else{
					List<Integer> prevLine = list.get(i-1);
					listInside.add(prevLine.get(j-1) + prevLine.get(j));
				}
			}
			list.add(listInside);
		}
		return list;
	}


	public static List<List<Integer>> generate(int numRows) {
		List<List<Integer>> res = new ArrayList<>();
		res.add(Arrays.asList(1));
		for(int i = 1; i < numRows; i++){
			List<Integer> list = new ArrayList<>();
			for(int j = 0; j <= i; j++) {
				if(j == 0){
					list.add(res.get(i-1).get(0));
				} else if(j == i){
					list.add(res.get(i - 1).get(j - 1));
				} else{
					list.add(res.get(i - 1).get(j) + res.get(i - 1).get(j - 1));
				}
			}
			res.add(list);
		}

		return res;
	}

	public static void main(String[] args) {
		System.out.println(generate(5));
	}
}
