package structures.leetcode_easy.others;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
	public static List<List<Integer>> generate(int numRows) {
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

	public static void main(String[] args) {
		System.out.println(generate(5));
	}
}
