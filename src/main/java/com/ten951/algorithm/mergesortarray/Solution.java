package com.ten951.algorithm.mergesortarray;


//给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
//
// 说明:
//
//
// 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
// 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
//
//
// 示例:
//
// 输入:
//nums1 = [1,2,3,0,0,0], m = 3
//nums2 = [2,5,6],       n = 3
//
//输出: [1,2,2,3,5,6]
// Related Topics 数组 双指针

/**
 * @author Darcy
 * @date 2019-12-03 16:19
 */
public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        /*1数组的最后一个元素*/
        int lo = m - 1;
        /*2数组的最后一个元素*/
        int hi = n - 1;
        /*目标添加数组的最后一个元素指针*/
        int p = m + n - 1;
        while (lo >= 0 && hi >= 0) {
            /*1<=2 p的位置就放2的元素*/
            nums1[p--] = (nums1[lo] < nums2[hi]) ? nums2[hi--] : nums1[lo--];
        }

        System.arraycopy(nums2, 0, nums1, 0, hi + 1);

    }
}