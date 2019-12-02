package com.ten951.algorithm.arraylinked.reversestring;


//给定一个字符串和一个整数 k，你需要对从字符串开头算起的每个 2k 个字符的前k个字符进行反转。如果剩余少于 k 个字符，则将剩余的所有全部反转。如果有小于 2k 但大于或等于 k 个字符，则反转前 k 个字符，并将剩余的字符保持原样。
//
// 示例:
//
//
//输入: s = "abcdefg", k = 2
//输出: "bacdfeg"
//
//
// 要求:
//
//
// 该字符串只包含小写的英文字母。
// 给定字符串的长度和 k 在[1, 10000]范围内。
//
// Related Topics 字符串

/**
 * @author Darcy
 * @date 2019-12-02 16:39
 */
public class Solution2 {

    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        /*按照2k序列遍历chars*/
        for (int start = 0; start < chars.length - 1; start += 2 * k) {
            /*start为开始反转的下标  j为结束反转的下标*/
            int i = start, j = Math.min(start + k - 1, chars.length - 1);
            char temp;
            while (i < j) {
                temp = chars[i];
                chars[i] = chars[j];
                chars[j] = temp;
                i++;
                j--;
            }
        }
        return new String(chars);
    }
}
