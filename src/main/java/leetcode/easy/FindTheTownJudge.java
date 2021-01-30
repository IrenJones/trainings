package leetcode.easy;

public class FindTheTownJudge {
	public int findJudge(int N, int[][] trust) {
		if (N == 1 && trust.length == 0) {
			return 1;
		} else if (N == 1 && trust.length != 0) {
			return -1;
		}

		int[] res = new int[N + 1];
		int[] resRev = new int[N + 1];

		for (int i = 0; i < trust.length; i++) {
			if (trust[i][0] == trust[i][1]) {
				return -1;
			}
			res[trust[i][1]]++;
			resRev[trust[i][0]]++;
		}

		int pos = -1;
		for (int i = 0; i < N + 1; i++) {
			if (pos == -1 && res[i] == N - 1 && resRev[i] == 0) {
				pos = i;
			}
		}
		return pos;
	}
}
