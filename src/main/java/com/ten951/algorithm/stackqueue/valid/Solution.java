package com.ten951.algorithm.stackqueue.valid;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Darcy
 * @date 2019-11-26 19:19
 */
public class Solution {

    /**
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     * 验证合法性
     *
     * @param s 字符串
     * @return 是否合法
     */
    public boolean isValid(String s) {

        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.offerFirst(')');
            } else if (c == '{') {
                stack.offerFirst('}');
            } else if (c == '[') {
                stack.offerFirst(']');
            } else if (stack.isEmpty() || stack.pollFirst() != c) {
                return false;
            }

        }
        return stack.isEmpty();

    }
}
