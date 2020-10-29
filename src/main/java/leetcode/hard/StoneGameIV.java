package leetcode.hard;

public class StoneGameIV {

	public static void main(String[] args) {
		System.out.println(winnerSquareGame(4) == true);
		System.out.println(winnerSquareGame(17) == false);
		System.out.println(winnerSquareGame(5) == false);
		System.out.println(winnerSquareGame(6) == true);
	}

	public static boolean winnerSquareGame(int n) {
		if(n == 2) {
			return false;
		} else{
			int result = (int)Math.sqrt(n);
			if(result*result == n) {
				return true;
			}
			// logic
			// 0 - lose state
			// 1 - win state
			int[] states = new int[n + 1];
			for(int i=0; i * i < n+1; i++) {
				states[i*i] = 1;
			}

			// calculate each step
			for(int i=1; i < n+1; i++) {
				for(int k=1; k*k <= i; k++) {
					// i - k*k - make a step with k*k size and leave i - k*k stones
					if(states[i - k*k] == 0) {
						states[i] = 1;
						break;
					}
				}
			}

			return states[n] == 1;
		}
	}
}
