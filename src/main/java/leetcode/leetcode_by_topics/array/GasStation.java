package leetcode.leetcode_by_topics.array;

public class GasStation {

	public static void main(String[] args) {
		GasStation solution = new GasStation();
		solution.canCompleteCircuitBetter(new int[]{1,2,3,4,5}, new int[]{3,4,5,1,2});
		solution.canCompleteCircuit(new int[]{1,2,3,4,5}, new int[]{3,4,5,1,2});
	}

	public int canCompleteCircuit(int[] gas, int[] cost) {

		int n = gas.length;

		mc: for(int i = 0; i < n; i++) {
			if(gas[i] >= cost[i % n]) {
				int current = gas[i] - cost[i];
				int j = (i + 1) % n;
				while(i != j) {
					if(current + gas[j] < cost[j % n]) {
						continue mc;
					} else {
						current += gas[j];
						current -= cost[j];
					}
					j = (j + 1) % n;
				}
				return i;
			}
		}
		return -1;
	}

	public int canCompleteCircuitBetter(int[] gas, int[] cost) {

		int result = 0;
		int diffSum = 0;
		int start = 0;

		for(int i=0; i < gas.length; i++) {
			diffSum += gas[i] - cost[i];
			if(diffSum < 0) {
				start = i + 1;
				result += diffSum;
				diffSum = 0;
			}
		}

		result += diffSum;

		if(result < 0) {
			return -1;
		} else {
			return start;
		}
	}
}
