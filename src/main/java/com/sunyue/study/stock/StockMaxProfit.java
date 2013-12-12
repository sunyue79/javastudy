package com.sunyue.study.stock;

import java.util.Arrays;

public class StockMaxProfit {

	private static int[] PRICES = new int[] { 49, 38, 65, 97, 200, 76, 13, 27 };

	/**
	 * @question 
	 *           假设你有一个数组包含了每天的股票价格，它的第i个元素就是第i天的股票价格。你只能进行一次交易（一次买进和一次卖出），设计一个算法求出最大的收益
	 *           。
	 * 
	 * @solution 记住卖总是在买之后。遍历数组，如果发现比当前的最小值还要小，就重新购买,如果发现比当前最大值还要大，就试着卖出。
	 * 
	 */
	public int maxProfitOneDeal(int[] prices) {
		int tmpBuyDay, tmpSaleDay;
		int buyDay, saleDay, maxProfit;
		if (prices.length < 2) {
			// throw new RuntimeException("At least two days' prices!");
			return 0;
		}

		tmpBuyDay = tmpSaleDay = 0;
		buyDay = saleDay = 0;
		maxProfit = 0;

		for (int i = 1; i < prices.length; i++) {
			if (prices[tmpBuyDay] > prices[i]) {
				tmpBuyDay = tmpSaleDay = i;
			} else if (prices[tmpSaleDay] < prices[i]) {
				tmpSaleDay = i;
				if (maxProfit < prices[tmpSaleDay] - prices[tmpBuyDay]) {
					maxProfit = prices[tmpSaleDay] - prices[tmpBuyDay];
					buyDay = tmpBuyDay;
					saleDay = tmpSaleDay;
				}
			}
		}

		System.out.println("Max profit by one deal: " + maxProfit);
		System.out.println("Buy at " + buyDay + " day, price is "
				+ prices[buyDay]);
		System.out.println("Sale at " + saleDay + " day, price is "
				+ prices[saleDay]);
		System.out.println("");

		return maxProfit;
	}

	/**
	 * @question 
	 *           假设你有一个数组包含了每天的股票价格，它的第i个元素就是第i天的股票价格。设计一个算法寻找最大的收益。你可以进行任意多次交易。但是
	 *           ，你不能同时进行多次交易，也就是说你买股票之前，必须卖掉手中股票。 。
	 * 
	 * @solution 为了得到最大收益，必须在所有上升的曲线段的开始点买入，在最高点卖出。而在下降阶段不出手。
	 * 
	 */
	public int maxProfitMultiDeal(int[] prices) {
		int buyDay, saleDay, profit, totalProfit;
		if (prices.length < 2) {
			throw new RuntimeException("At least two days' prices!");
		}

		buyDay = saleDay = 0;
		profit = 0;
		totalProfit = 0;

		for (int i = 1; i < prices.length; i++) {
			if (prices[i - 1] < prices[i]) { // ASC
				saleDay = i;
				profit = prices[saleDay] - prices[buyDay];
			} else { // DESC
				if (profit > 0) {
					System.out.println("Profit: " + profit);
					System.out.println("Buy at " + buyDay + " day, price is "
							+ prices[buyDay]);
					System.out.println("Sale at " + saleDay + " day, price is "
							+ prices[saleDay]);
					totalProfit += profit;
					profit = 0;
					saleDay = buyDay = i;
				}
				if (prices[buyDay] > prices[i]) {
					buyDay = i;
				}
			}
		}

		if (profit > 0) { // the last profit
			System.out.println("Profit: " + profit);
			System.out.println("Buy at " + buyDay + " day, price is "
					+ prices[buyDay]);
			System.out.println("Sale at " + saleDay + " day, price is "
					+ prices[saleDay]);
			totalProfit += profit;
		}

		System.out.println("Total profit : " + totalProfit);
		System.out.println("");

		return totalProfit;
	}

	/**
	 * @question 
	 *           假设你有一个数组包含了每天的股票价格，它的第i个元素就是第i天的股票价格。设计一个算法寻找最大的收益。你可以最多进行两次交易。注意
	 *           ：你不能同时进行多次交易，也就是说你买股票之前，必须卖掉手中股票。
	 * 
	 * @solution 把n天分为两段，分别计算这两段的最大收益，就可以得到一个最大收益。穷举所有这样的分法，就可以得到全局的最大收益。
	 * 
	 */
	public int maxProfitTwoDeal(int[] prices) {
		int maxProfit = 0;
		int[] profit1 = new int[prices.length];
		int[] profit2 = new int[prices.length];

		for (int i = 0; i < prices.length; i++) {
			profit1[i] = maxProfitOneDeal(Arrays.copyOfRange(prices, 0, i));
			profit2[i] = maxProfitOneDeal(Arrays.copyOfRange(prices, i,
					prices.length));
		}

		for (int i = 0; i < prices.length; i++) {
			maxProfit = maxProfit < profit1[i] + profit2[i] ? profit1[i]
					+ profit2[i] : maxProfit;
		}

		System.out.println("Max profit : " + maxProfit);
		System.out.println("");

		return maxProfit;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		StockMaxProfit stock = new StockMaxProfit();
		System.out.println("1 ------------------------------------------");
		//stock.maxProfitOneDeal(PRICES);
		System.out.println("2 ------------------------------------------");
		//stock.maxProfitMultiDeal(PRICES);
		System.out.println("3 ------------------------------------------");
		stock.maxProfitTwoDeal(PRICES);
	}

}
