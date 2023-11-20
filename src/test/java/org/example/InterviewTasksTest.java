package org.example;

import jdk.jfr.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InterviewTasksTest {

    //Написать метод, на вход которого приходит массив строк. содержащих в том числе и хештеги - на выход надо выдать тоже массив,
    // но уникальных хештегов, отсортированных в обратном порядке.
    // {"Сегодня в #Москва хорошая погода", "А в #Питер идет #дождь", "Вчера тоже был в #Москва"}
    @DisplayName("Уникальные хэштеги")
    @Test
    public void test() {
        String[] array = new String[]{"Сегодня в #Москва хорошая погода",
                "А в #Питер идет #дождь",
                "Вчера тоже был в #Москва"};

        List<String> result = new ArrayList<>();
        Arrays.stream(array)
                .map(s -> s.split(" "))
                .forEach(a -> {
                    result.addAll(Arrays.asList(a));
                });

        result.stream()
                .filter(s -> s.startsWith("#"))
                .distinct()
                .sorted(Collections.reverseOrder(Comparator.comparing(String::toLowerCase)))
                .forEach(System.out::println);
    }

    @DisplayName("А как сделать так чтобы проверялась каждая дата в течении одного года?")
    @Test
    public void test2() {

        LocalDate start = LocalDate.of(2023, 1, 1);
        LocalDate end = start.plusYears(1);
        for (LocalDate date = start; date.isBefore(end); date = date.plusDays(1)) {
            System.out.println(date);
        }
    }

    @DisplayName("Валидация закрытия скобок")
    @Test
    public void test3() {
        String actual = "[d[]  ]";
        System.out.println(Pattern.matches("^\\[.*\\]$", actual));
    }

    @DisplayName("Перевернуть строку без реверса")
    @Test
    public void test4() {
        String s = "waterfall is great water";
        char[] arr = s.toCharArray();
        List<Character> result = new ArrayList<>();
        int j = 0;
        for (int i = arr.length; i > 0; i--) {
            result.add(arr[i - 1]);
            j++;
        }
        String f = result.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());

        System.out.println(f);
    }

    @DisplayName("Удалить дубликаты из сортированного списка")
    @Test
    public void test5() {
        int[] arr = {1, 2, 3, 4, 5, 6, 6, 6, 7, 7, 8, 8, 9, 9, 9, 10};
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] != arr[i + 1]) {
                list.add(arr[i]);
            }
        }
        list.add(arr[arr.length - 1]);
        list.forEach(System.out::println);
    }

    @DisplayName("Проверить соответствуют ли элементы массива валидации по e-mail с помощью regex")
    @Test
    public void test6() {
        String[] arr = {"test@mail.ru", "123-123@google..com", "dede@gmail."};
        Arrays.stream(arr)
                .forEach(s -> {
                    System.out.printf("%s - %s%n", s, Pattern.matches("\\S*@\\S[^.]*\\.{1}\\w{2,3}", s));
                });
    }

    @DisplayName("Реализовать метод, который будет возвращать количество передаваемого символа в слове")
    @Test
    public void test7() {
        char c = 'a';
        String actual = "/Aligator/";
        char[] arr = actual.toLowerCase().toCharArray();
        int result = 0;
        for (char value : arr) {
            if (value == c) {
                result++;
            }
        }

        System.out.println(result);

    }
}
