package leetcode.medium;

import java.util.Arrays;

public class BagOfTokens {
	public int bagOfTokensScore(int[] tokens, int P) {
		// sort
		Arrays.sort(tokens);

		int score = 0;
		int currentScore = 0;
		int low = 0;
		int high = tokens.length - 1;

		while(low <= high){
			// start
			if(P>= tokens[low]) {
				P = P - tokens[low];
				low++;
				currentScore++;
				score = Math.max(currentScore, score);
			} else if(score >= 1) {
				P = P + tokens[high];
				high--;
				currentScore--;
			} else {
				break;
			}
		}

		return score;
	}
}
