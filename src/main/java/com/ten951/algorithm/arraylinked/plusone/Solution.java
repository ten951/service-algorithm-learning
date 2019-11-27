package com.ten951.algorithm.arraylinked.plusone;

/**
 * @author Darcy
 * @date 2019-11-27 09:25
 */
public class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            /*小于9直接加1*/
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            /*如果大于9 补0即可*/
            digits[i] = 0;
        }
        /*应对999这样的数字*/
        int[] newNumber = new int[n + 1];
        newNumber[0] = 1;
        return newNumber;
    }

}
