package org.example.leetcode;

import java.util.Stack;

public class ValidParentheses {
    /*
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
An input string is valid if:
Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.
     */

    public static void main(String[] args) {
        System.out.println(isValidMyVersion("(]"));
        System.out.println(isValid("]()"));
    }

    public static boolean isValidMyVersion(String s) {
        for (int i = 0; i < s.toCharArray().length - 1; i++) {
            if (s.charAt(i) == '(') {
                if (s.charAt(i + 1) != ')') {
                    return false;
                }
            }

            if (s.charAt(i) == '[') {
                if (s.charAt(i + 1) != ']') {
                    return false;
                }
            }


            if (s.charAt(i) == '{') {
                if (s.charAt(i + 1) != '}') {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isValid(String s) {
        //LIFO
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }
}
