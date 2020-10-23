package leetcode.hard;

public class BestTimeToBuyAndSellStockIV {

	public static void main(String[] args) {
		//System.out.println(maxProfit(2, new int[]{2,4,1}) == 2);
		System.out.println(maxProfit(1, new int[]{1, 2}) == 1);
		System.out.println(maxProfit(2, new int[]{3,2,6,5,0,3}) == 7);
	}

	public static int maxProfitOfficial(int k, int[] prices) {
		if (prices.length < 2 || k < 1) {
			return 0;
		}

		int maxProfit = 0;

		// case 1 -
		if(2*k > prices.length) {
			for(int i=0; i< prices.length - 1; i++) {
				maxProfit+= Math.max(0, prices[i+1] - prices[i]);
			}
			return maxProfit;
		}

		// case 2
		int[][][] dp = new int[prices.length][k+1][2];

		for (int i = 0; i < prices.length; i++) {
			for (int j = 0; j < k + 1; j++) {
				dp[i][j][0] = -1000000000;
				dp[i][j][1] = -1000000000;
			}
		}

		dp[0][0][0] = 0;
		dp[0][1][1] = -prices[0];

		for(int i=1; i< prices.length; i++) {
			for(int j=0; j < k+1; j++) {
				dp[i][j][0] = Math.max(dp[i-1][j][0], dp[i-1][j][1] + prices[i]);

				if(j > 0) {
					dp[i][j][1] = Math.max(dp[i-1][j][1], dp[i-1][j-1][0] - prices[i]);
				}
			}
		}

		for(int i=0; i< k+1; i++) {
			if(maxProfit < dp[prices.length - 1][i][0]) {
				maxProfit = dp[prices.length - 1][i][0];
			}
		}

		return maxProfit;
	}

	public static int maxProfitTooMuchMemory(int k, int[] prices) {
		if (prices.length < 2 || k < 1) {
			return 0;
		}

		// case 1 -
		if(2*k > prices.length) {
			return calculateResult(prices);
		}

		int rangeSize = prices.length;
		// case 2
		int[][] dp = new int[k+1][rangeSize];
		for (int i = 1; i < k + 1; i++) {
			int max = - prices[0];
			for (int j = 1; j < rangeSize; j++) {
				dp[i][j] = Math.max(dp[i][j-1],  prices[j] + max);
				max = Math.max(max, dp[i-1][j-1] - prices[j]);
			}
		}
		return dp[k][rangeSize-1];
	}

	public static int maxProfit(int k, int[] prices) {
		if (prices.length < 2 || k < 1) {
			return 0;
		}

		// case 1 -
		if(2*k > prices.length) {
			return calculateResult(prices);
		}

		int rangeSize = prices.length;
		// case 2
		int[] buy = new int[k + 1];
		for(int i=0; i< k + 1; i++) {
			buy[i] = Integer.MIN_VALUE;
		}
		int[] sell = new int[k + 1];
		for (int price : prices) {
			for (int i = 1; i < k + 1; i++) {
				buy[i] = Math.max(buy[i], sell[i - 1] - price);
				sell[i] = Math.max(sell[i], buy[i] + price);
			}
		}
		return sell[k];
	}

	private static int calculateResult(int[] prices) {
		int rangeSize = prices.length;
		int result = 0;
		for(int i=0; i< rangeSize - 1; i++) {
			if (prices[i + 1] > prices[i]) {
				result += prices[i + 1] - prices[i];
			}
		}
		return result;
	}
}
