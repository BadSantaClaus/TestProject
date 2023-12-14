package org.example.interview;

import java.util.Arrays;
import java.util.regex.Pattern;

public class RegEx {

    public static void main(String[] args) {
        String actual = "[d[]  ]";
        String[] arr = {"test@mail.ru", "123-123@google..com", "dede@gmail."};
        reg1(actual);
        reg2(arr);
    }

    public static void reg1(String actual) {
        System.out.println(Pattern.matches("^\\[.*\\]$", actual));
    }


    public static void reg2(String[] arr) {
        Arrays.stream(arr)
                .forEach(s -> {
                    System.out.printf("%s - %s%n", s, Pattern.matches("\\S*@\\S[^.]*\\.{1}\\w{2,3}", s));
                });
    }
}
