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
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        for (int i = 0; i < num.length - 2; i++) {
            /*在有序数组中. i的位置的元素就>0, 三数相加不仅可能等于0*/
            if (num[i] > 0) {
                break;
            }
            /*去除重复(i指针的)*/
            if (i == 0 || num[i] != num[i - 1]) {
                /*双指针*/
                int lo = i + 1, hi = num.length - 1, sum = -num[i];
                while (lo < hi) {
                    int n = num[lo] + num[hi];
                    if (n == sum) {
                        List<Integer> tmp = new ArrayList<Integer>();
                        tmp.add(num[i]);
                        tmp.add(num[lo]);
                        tmp.add(num[hi]);
                        res.add(tmp);
                        //res.add(Arrays.asList(num[i], num[lo], num[hi]));
                        while (lo < hi && num[lo] == num[lo + 1]) {
                            lo++;
                        }
                        while (lo < hi && num[hi] == num[hi - 1]) {
                            hi--;
                        }
                        lo++;
                        hi--;
                    } else if (n < sum) {
                        lo++;
                    } else {
                        hi--;
                    }
                }
            }
        }
        return res;
    }
}
