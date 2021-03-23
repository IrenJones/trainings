package leetcode.easy;

public class BestTimeToBuyAndSellStockII {

	public static void main(String[] args) {
		System.out.println(maxProfitSecond(new int[]{7,1,5,3,6,4}) == 7);
		System.out.println(maxProfit(new int[]{7,1,5,3,6,4}) == 7);
	}

	public static int maxProfitOld(int[] prices) {
		return maxProfit(prices, 0);
	}

	public static int maxProfit(int[] prices, int indexStart) {
		// end
		if(indexStart == prices.length) {
			return 0;
		}

		int result = 0;
		int diff = 0, nextMaxProfit = 0, stageMaxProfit;
		for(int i=indexStart; i< prices.length; i++) {
			stageMaxProfit = 0;
			for(int j= i + 1; j < prices.length; j++) {
				if(prices[i] < prices[j]) {
					diff = prices[j] - prices[i];
					nextMaxProfit = maxProfit(prices, j+1);
					if(diff + nextMaxProfit > stageMaxProfit) {
						stageMaxProfit = diff + nextMaxProfit;
					}
				}
			}
			if(stageMaxProfit > result) {
				result = stageMaxProfit;
			}
		}
		return result;
	}


	public static int maxProfitSecond(int[] prices) {
		int index = 0;
		int low = prices[0];
		int high = prices[0];
		int result = 0;

		while(index < prices.length - 1) {
			// find low
			while(index < prices.length - 1 && prices[index] >= prices[index + 1]) {
				index++;
			}

			low = prices[index];

			//find high
			while(index < prices.length - 1 && prices[index] <= prices[index + 1]) {
				index++;
			}

			high = prices[index];
			result+= high - low;
		}

		return result;
	}

	public static int maxProfit(int[] prices) {
		int max = 0, start = 0;
		for(int i = 1; i < prices.length; i++) {
			if(prices[i] - prices[i - 1] > 0) {
				start = i - 1;
				while(i < prices.length && prices[i] - prices[i - 1] > 0){
					i++;
				}
				max += prices[i - 1] - prices[start];
			}
		}

		return max;
	}
}
