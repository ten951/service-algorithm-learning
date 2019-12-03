package com.ten951.algorithm.arraylinked.maxsubarrays;


//给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
//
// 示例:
//
// 输入: [-2,1,-3,4,-1,2,1,-5,4],
//输出: 6
//解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
//
//
// 进阶:
//
// 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
// Related Topics 数组 分治算法 动态规划

/**
 * @author Darcy
 * @date 2019-12-02 17:22
 */
public class Solution {
    public int maxSubArray(int[] nums) {
        /*最大子序列的和*/
        int maxSum = nums[0];
        /*上一个最大子序列的和*/
        int lastSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            /*当前序列的和*/
            int curSum;
            /*表示可以继续增大*/
            if (lastSum > 0) {
                curSum = nums[i] + lastSum;
            } else {
                /*不能继续增大了*/
                curSum = nums[i];
            }
            /*至于是不是最大的. 要比较cur和max*/
            maxSum = Math.max(curSum, maxSum);
            /*将当前最大的赋值给last指针*/
            lastSum = curSum;
        }
        return maxSum;
    }
}
