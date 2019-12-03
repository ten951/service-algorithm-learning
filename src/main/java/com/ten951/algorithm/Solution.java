package com.ten951.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Darcy
 * @date 2019-12-02 17:06
 */
public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backtrack(ans, "", 0, 0, n);
        return ans;
    }

    /**
     * @param ans   集合
     * @param cur   生成的对
     * @param open  (的数量
     * @param close )的数量
     * @param max   最多多少对
     */
    public void backtrack(List<String> ans, String cur, int open, int close, int max) {
        /*字符串中(的数量和)的数量和 = max*2  就结束了. */
        if (cur.length() == max * 2) {
            ans.add(cur);
            return;
        }
        /*(数量要小于max 需要添加一个(*/
        if (open < max) {
            backtrack(ans, cur + "(", open + 1, close, max);
        }
        /*)的数量小于(的数量 需要加一个)*/
        if (close < open) {
            backtrack(ans, cur + ")", open, close + 1, max);
        }
    }


}
