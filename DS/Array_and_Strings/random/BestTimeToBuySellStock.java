/*
Problem: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
*/

class BestTimeToBuySellStock {


	public static int maxProfit(int[] prices) {
		int profit = 0; // as if numbers are just decreasing then we won't buy stocks
		int min = Integer.MAX_VALUE;

		for(int i=0; i<prices.length; i++) {
			if(prices[i] < min) {
				min = prices[i];
			}
			else if((prices[i]-min) > profit) {
				profit = prices[i]-min;
			}
		}
		return profit;
	}

	public static void main(String[] args) {
		int[] prices = {7,1,5,3,6,4};
		// Brute force algorithm can be: where j will start from i+1; for every i we check where j is greater than i, we calculate min difference
		System.out.print(maxProfit(prices));
	}
}