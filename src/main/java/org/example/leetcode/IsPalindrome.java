package org.example.leetcode;

import java.util.ArrayList;
import java.util.List;

public class IsPalindrome {

    public static void main(String[] args) {
        IsPalindrome isPalindrome = new IsPalindrome();
        System.out.println(isPalindrome.isPalindrome_mySolution(1211));
        System.out.println(isPalindrome.isPalindrome(1121));
    }

    public boolean isPalindrome_mySolution(int x) {
        String s = String.valueOf(x);
        char[] ar = s.toCharArray();
        List<String> list = new ArrayList<>();
        for (int i = ar.length - 1; i >= 0; i--) {
            list.add(String.valueOf(ar[i]));
        }
        String reversed = String.join("", list);
        return s.equals(reversed);
    }

    public boolean isPalindrome(int x) {
        String s = String.valueOf(x); // Convert to String
        int n = s.length(); // Store the String length to int n

        for (int i = 0; i < n / 2; i++) {
            // We check whether the elements at the same distance from
            // beginning and from ending are same, if not we return false
            if (s.charAt(i) != s.charAt(n - i - 1)) {
                return false;
            }
        }

        // if no flaws are found we return true
        return true;
    }
}
