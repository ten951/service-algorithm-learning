package com.ten951.algorithm.arraylinked.threesum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


//给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
//
// 注意：答案中不可以包含重复的三元组。
//
// 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
//
//满足要求的三元组集合为：
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
//
// Related Topics 数组 双指针

/**
 * @author Darcy
 * @date 2019-11-22 17:55
 */
public class Solution {
    /**
     * 求和为0的三元组
     *
     * @param num 数组
     * @return 三个数相加等于0的三元组
     */
    public List<List<Integer>> threeSum(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < num.length - 2; i++) {
            if (num[i] > 0) {
                break;
            }
            if (i == 0 || num[i] != num[i - 1]) {
                int left = i + 1, right = num.length - 1, sum = -num[i];
                while (left < right) {
                    int n = num[left] + num[right];
                    if (sum == n) {
                        res.add(Arrays.asList(num[i], num[left], num[right]));
                        while (left < right && num[left] == num[left + 1]) {
                            left++;
                        }
                        while (left < right && num[right] == num[right - 1]) {
                            right--;
                        }
                        left++;
                        right--;
                    } else if (n < sum) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return res;
    }
}
