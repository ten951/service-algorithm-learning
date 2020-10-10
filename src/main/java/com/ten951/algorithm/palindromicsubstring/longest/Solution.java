package com.ten951.algorithm.palindromicsubstring.longest;

/**
 * 5. 最长回文子串
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <p>
 * 示例 1：
 * <p>
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 * <p>
 * 输入: "cbbd"
 * 输出: "bb"
 *
 * @author 王永天
 * @date 2020-10-10 14:22
 */
public class Solution {

    /**
     * 暴力解法
     * 时间复杂度 ON^3   空间复杂度 O1
     *
     * @param s 字符串
     * @return 最长回文子串
     */
    public String longestPalindrome(String s) {
        if (s == null || "".equals(s)) {
            return null;
        }
        int len = s.length();
        if (len < 2) {
            return s;
        }

        int maxLen = 1;
        int begin = 0;
        char[] charArray = s.toCharArray();


        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (j - i + 1 > maxLen && this.validPalindromic(charArray, i, j)) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }

        return s.substring(begin, begin + maxLen);

    }

    private Boolean validPalindromic(char[] charArray, int left, int right) {
        while (left < right) {
            if (charArray[left] != charArray[right]) {
                return Boolean.FALSE;
            }
            left++;
            right--;
        }
        return Boolean.TRUE;
    }


    /**
     * 动态规划
     * dp[i][j] 表示s[i...j]的子串是否为回文串
     * 1. si != sj时 dpij = false
     * 2. si == sj
     * 考察边界情况[i+1, j-1]  当 j-1 - (i+1) +1 < 2时 就是回文串即 i-j < 3
     * 2.1 j - i < 3 时  dpij = true
     * <p>
     * 2.2  dp[i][j] = dp[i + 1][j - 1];
     * 时间复杂度 ON^2   空间复杂度 ON^2
     *
     * @param s 字符串
     * @return 最长回文串
     */
    public String longestPalindrome1(String s) {
        if (s == null || "".equals(s)) {
            return null;
        }
        int len = s.length();
        if (len < 2) {
            return s;
        }
        int maxLen = 1;
        int begin = 0;
        boolean[][] dp = new boolean[len][len];
        char[] charArray = s.toCharArray();

        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                if (charArray[j] != charArray[i]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    /**
     * 中心扩散法
     *
     * @param s 字符串
     * @return 最长回文串
     */
    public String longestPalindrome3(String s) {
        if (s == null || "".equals(s)) {
            return null;
        }
        int len = s.length();
        if (len < 2) {
            return s;
        }
        int maxLen = 1;
        String res = s.substring(0, 1);
        for (int i = 0; i < len - 1; i++) {
            String odd = this.centerSpread(s, i, i);
            String even = this.centerSpread(s, i, i + 1);
            String maxLenStr = odd.length() > even.length() ? odd : even;
            if (maxLenStr.length() > maxLen) {
                maxLen = maxLenStr.length();
                res = maxLenStr;
            }

        }
        return res;
    }

    private String centerSpread(String s, int left, int right) {
        int len = s.length();
        int i = left;
        int j = right;
        while (i >= 0 && j < len) {
            if (s.charAt(i) == s.charAt(j)) {
                i--;
                j++;
            } else {
                break;
            }
        }
        // while 循环break是. 真实i!=j的时候. 因此 i和j都不能取. 要去i+1,j-1. s.substring(a,b) 本身b就是不包含
        return s.substring(i + 1, j);
    }




}
