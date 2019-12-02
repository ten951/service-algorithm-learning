package com.ten951.algorithm.stackqueue.largesthistogram;


//给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
//
// 求在该柱状图中，能够勾勒出来的矩形的最大面积。
//
//
//
//
//
// 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。
//
//
//
//
//
// 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。
//
//
//
// 示例:
//
// 输入: [2,1,5,6,2,3]
//输出: 10
// Related Topics 栈 数组

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Darcy
 * @date 2019-11-27 13:59
 */
public class Solution {

    /**
     * 时间复杂度
     * @param heights 目标数组
     * @return 最大矩形面积
     */
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.addFirst(-1);
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            /*栈顶元素大于当期元素*/
            while (stack.peekFirst() != -1 && heights[stack.peekFirst()] >= heights[i]) {
                maxArea = Math.max(maxArea, heights[stack.removeFirst()] * (i - stack.peekFirst() - 1));
            }
            stack.addFirst(i);
        }
        while (stack.peekFirst() != -1) {
            maxArea = Math.max(maxArea, heights[stack.removeFirst()] * (heights.length - stack.peekFirst() - 1));
        }
        return maxArea;

    }

    public int largestRectangleArea1(int[] heights) {
        return helper(heights, 0, heights.length - 1);
    }

    private int helper(int[] heights, int start, int end) {
        if (start > end) {
            return 0;
        }
        if (start == end) {
            return heights[start];
        }
        int min = heights[start];
        boolean sorted = true;
        /*判断数组是否有序, 并且找到数组中最小元素*/
        for (int i = start + 1; i <= end; i++) {
            min = Math.min(min, heights[i]);
            if (heights[i - 1] > heights[i]) {
                sorted = false;
            }
        }
        /*有序数组, 且是从小到大顺序的. 最大矩形 当前高度(h[i]* (end-i+1))*/
        if (sorted) {
            int max = 0;
            for (int i = start; i <= end; i++) {
                max = Math.max(max, heights[i] * (end - i + 1));
            }
            return max;
        }
        /*数组无序的情况, 算出最小元素的矩形面积*/
        int area = min * (end - start + 1);
        int startIndex = start;
        for (int i = start; i <= end; i++) {
            /*左边矩形面积和最小元素的矩形面积*/
            if (heights[i] == min) {
                area = Math.max(area, helper(heights, startIndex, i - 1));
                startIndex = i + 1;
            }
        }
        /*右边矩形面积*/
        return Math.max(area, helper(heights, startIndex, end));
    }
}
