package org.example.interview;

public class CountCharInString {

    public static void main(String[] args) {
        String actual = "/Aligator/";
        char c = 'a';
        System.out.println(countChar(actual, c));
    }

    public static int countChar(String actual, char c) {
        char[] arr = actual.toLowerCase().toCharArray();
        int result = 0;
        for (char value : arr) {
            if (value == c) {
                result++;
            }
        }
        return result;
    }
}
