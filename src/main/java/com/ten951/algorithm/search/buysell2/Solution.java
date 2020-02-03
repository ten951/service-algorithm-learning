package com.ten951.algorithm.search.buysell2;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/submissions/
 * dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
 * dp[i][1] = max(dp[i-1][1], dp[i-1][0] - prices[i])
 * @author Darcy
 * @date 2020-01-26 17:01
 */
public class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            /*今天不持有股票的利益 = Max(昨儿就没有持有股票,昨儿持有股票的利益+今儿买掉股票的利益)*/
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            /*今儿持有股票的利益 = Max(昨儿就持有股票, 昨儿没有持有股票的利益 - 今儿买入股票的利益)*/
            dp_i_1 = Math.max(dp_i_1, dp_i_0 - prices[i]);
        }
        return dp_i_0;
    }
}
