package com.ten951.algorithm.search.buysell;

/**
 *
 * 动态规划解决方法, 第i天持有股票(1)和第i天没有持有股票(0)
 * dp[i][0] = Max(dp[i-1][0], dp[i-1][1]+prices[i])
 * dp[i][1] = Max(dp[i-1][1], 0)
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 *
 * @author Darcy
 * @date 2020-01-26 16:27
 */
public class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int dpI0 = 0;
        int dpI1 = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            dpI0 = Math.max(dpI0, dpI1 + prices[i]);
            dpI1 = Math.max(dpI1, -prices[i]);
        }
        return dpI0;

    }
}
