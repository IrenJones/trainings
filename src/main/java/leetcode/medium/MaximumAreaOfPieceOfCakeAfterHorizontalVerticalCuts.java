package leetcode.medium;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class MaximumAreaOfPieceOfCakeAfterHorizontalVerticalCuts {

	public static void main(String[] args) {
		System.out.println(maxAreaBetter(5, 4, new int[]{1, 2, 4}, new int[]{1, 3}) == 4);
	}

	public static int maxArea(int h, int w,
							  int[] horizontalCuts,
							  int[] verticalCuts) {

		if (h == 0 || w == 0 || horizontalCuts.length == 0 && verticalCuts.length == 0) {
			return h * w;
		}

		Arrays.sort(horizontalCuts);
		Arrays.sort(verticalCuts);

		int maxH = 0;
		for (int i = 0; i < horizontalCuts.length + 1; i++) {
			if (i == horizontalCuts.length) {
				maxH = Math.max(maxH, h - horizontalCuts[i - 1]);
			} else if (horizontalCuts[i] != 0 && horizontalCuts[i] != h) {
				if (i == 0) {
					maxH = Math.max(maxH, horizontalCuts[i]);
				} else {
					maxH = Math.max(maxH, horizontalCuts[i] - horizontalCuts[i - 1]);
				}
			}
		}

		int maxW = 0;
		for (int i = 0; i < verticalCuts.length + 1; i++) {
			if (i == verticalCuts.length) {
				maxW = Math.max(maxW, w - verticalCuts[i - 1]);
			} else if (verticalCuts[i] != 0 && verticalCuts[i] != w) {
				if (i == 0) {
					maxW = Math.max(maxW,verticalCuts[i]);
				} else {
					maxW = Math.max(maxW,verticalCuts[i] - verticalCuts[i - 1]);
				}
			}
		}
		return (int)((long)maxH * maxW % 1000000007);
	}


	public static int maxAreaBetter(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
		Arrays.sort(horizontalCuts);
		Arrays.sort(verticalCuts);

		PriorityQueue<Integer> xDiff = new PriorityQueue<>(Collections.reverseOrder());
		int n = horizontalCuts.length;
		for(int i = 0; i <= n; i++){
			if(i == 0){
				xDiff.add(horizontalCuts[0]);
			} else if(i == n){
				xDiff.add(h - horizontalCuts[n - 1]);
			} else {
				xDiff.add(horizontalCuts[i] - horizontalCuts[i - 1]);
			}
		}

		PriorityQueue<Integer> yDiff = new PriorityQueue<>(Collections.reverseOrder());
		int m = verticalCuts.length;
		for(int i = 0; i <= m; i++){
			if(i == 0){
				yDiff.add(verticalCuts[0]);
			} else if(i == m){
				yDiff.add(w - verticalCuts[m - 1]);
			} else {
				yDiff.add(verticalCuts[i] - verticalCuts[i - 1]);
			}
		}

		return (int)((long)xDiff.peek() * yDiff.peek() % 1_000_000_007);
	}
}
