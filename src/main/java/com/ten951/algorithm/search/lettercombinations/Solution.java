package com.ten951.algorithm.search.lettercombinations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Darcy
 * @date 2020-01-26 15:10
 */
public class Solution {
    public List<String> letterCombinations(String digits) {
        Map<Character, String> map = new HashMap<>(8);
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        List<String> ans = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return ans;
        }
        this.letterCombinationsHelper("", digits, ans, 0, map);
        return ans;
    }

    private void letterCombinationsHelper(String s, String digits, List<String> ans, int level, Map<Character, String> map) {
        if (level == digits.length()) {
            ans.add(s);
            return;
        }
        char c = digits.charAt(level);
        String target = map.get(c);
        for (int i = 0; i < target.length(); i++) {
            this.letterCombinationsHelper(s + target.charAt(i), digits, ans, level + 1, map);
        }
    }
}
