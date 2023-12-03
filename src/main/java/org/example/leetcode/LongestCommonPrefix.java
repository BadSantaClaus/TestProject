package org.example.leetcode;

import java.util.Arrays;

public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] array = {"flower", "flow", "flight"};
//        String[] array = {"dog", "racecar", "car"};
        System.out.println(longestCommonPrefix(array));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        String prefix = strs[0];
        for (String s : strs)
            while (s.indexOf(prefix) != 0)
                prefix = prefix.substring(0, prefix.length() - 1);
        return prefix;
    }
}
