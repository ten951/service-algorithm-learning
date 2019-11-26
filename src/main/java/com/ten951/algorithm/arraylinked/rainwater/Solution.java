package com.ten951.algorithm.arraylinked.rainwater;

//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
//
//
//
// 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。
//
// 示例:
//
// 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
//输出: 6
// Related Topics 栈 数组 双指针

/**
 * @author Darcy
 * @date 2019-11-26 13:58
 */
public class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        /*左边最大的柱子*/
        int leftMax = 0,
                /*右边最大的柱子*/
                rightMax = 0,
                /*左指针*/
                left = 0,
                /*右指针*/
                right = height.length - 1,
                /*累计的水量*/
                res = 0;
        /*水量计算公式: min(leftMax,rightMax)-height[i]*/
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] < leftMax) {
                    res = res + leftMax - height[left];
                } else {
                    leftMax = height[left];
                }
                left++;
            } else {
                if (height[right] < rightMax) {
                    res = res + rightMax - height[right];
                } else {
                    rightMax = height[rightMax];
                }
                right--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] height = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int trap = new Solution().trap(height);
        System.out.println("trap = " + trap);
    }
}
