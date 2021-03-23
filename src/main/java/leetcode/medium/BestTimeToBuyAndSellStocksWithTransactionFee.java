package leetcode.medium;

import java.util.HashSet;
import java.util.Set;

public class BestTimeToBuyAndSellStocksWithTransactionFee {

	public static void main(String[] args) {
		BestTimeToBuyAndSellStocksWithTransactionFee s = new BestTimeToBuyAndSellStocksWithTransactionFee();
		s.maxProfit(new int[]{1, 3, 2, 6, 8, 4, 5, 6, 9}, 2);
	}

	public int maxProfit(int[] prices, int fee) {
		int n = prices.length;
		int[] buy = new int[n];
		int[] sell = new int[n];
		buy[0] = -prices[0];

		for(int i = 1; i < n; i++) {
			buy[i] = Math.max(buy[i-1], sell[i - 1] - prices[i]);
			sell[i] = Math.max(sell[i - 1], buy[i-1] + prices[i] - fee);
		}

		return sell[n - 1];
	}
}
