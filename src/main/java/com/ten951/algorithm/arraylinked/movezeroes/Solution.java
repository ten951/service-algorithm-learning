package com.ten951.algorithm.arraylinked.movezeroes;

//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
//
// 示例:
//
// 输入: [0,1,0,3,12]
//输出: [1,3,12,0,0]
//
// 说明:
//
//
// 必须在原数组上操作，不能拷贝额外的数组。
// 尽量减少操作次数。
//
// Related Topics 数组 双指针

/**
 * @author Darcy
 * @date 2019-11-22 16:22
 */
public class Solution {
    /**
     * 将0移动到数组末尾. 非零数字前移, 并保持元素自有顺序.
     * 所示两次循环但不是嵌套 O(n)
     * 空间负责度 恒定不变  O(1)
     *
     * @param nums 目标数组
     */
    public void moveZeroes(int[] nums) {
        /*标记0的位置*/
        int j = 0;
        /*循环结束后, 所有非0的元素全部前移了, j标记的就是最后一个0的位置*/
        for (int num : nums) {
            /*num不等于0, 将num赋值给0位置*/
            if (num != 0) {
                nums[j++] = num;
            }
        }
        /*j到nums.length 就是非零数字前移留下的空缺. 补0即可*/
        while (j < nums.length) {
            nums[j++] = 0;
        }
    }
}
