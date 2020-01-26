package com.ten951.algorithm.search.majorityelement;

/**
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * <p>
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 * @author Darcy
 * @date 2020-01-26 14:35
 */
public class Solution {
    /**
     * 分治思路, 当数组中只有1个元素时, 众数就是他自己. 递归搜索数组左半部分和右半部分. 当left == right left就是众数. 当不相等时, 对left和right分别计数.
     * 出现次数多的就是目标. 直到递归完成. 返回的就会次数最多的数
     *
     * @param nums 目标数组
     * @return 众数
     */
    public int majorityElement(int[] nums) {
        return this.majorityHelper(nums, 0, nums.length - 1);
    }

    private int majorityHelper(int[] nums, int lo, int hi) {
        if (nums.length == 0) {
            return 0;
        }
        if (lo == hi) {
            return nums[lo];
        }
        int mid = (hi - lo) / 2 + lo;
        int left = this.majorityHelper(nums, lo, mid);

        int right = this.majorityHelper(nums, mid + 1, hi);
        if (left == right) {
            return left;
        }
        int leftCount = this.countNumber(nums, left, lo, hi);
        int rightCount = this.countNumber(nums, right, lo, hi);
        return leftCount > rightCount ? left : right;
    }

    private int countNumber(int[] nums, int number, int lo, int hi) {
        int count = 0;
        for (int i = lo; i <= hi; i++) {
            if (nums[i] == number) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        new Solution().majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2});
    }
}
