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
    // отсортировать по частоте встречаемых слов с хэштегом
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
        for (int i = arr.length - 1; i >= 0; i--) {
            result.add(arr[i]);
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

    @Test
    public void test8() {
        /**
         * Дана таблица:
         * Имя|Возраст|Должность|Зарплата
         * Кирилл|26|Middle java dev|150000 руб
         * Виталий|28|Senior java automation QA|2000$
         * Александр|31|junior functional tester|50000 руб
         * Дементий|35|dev-ops|1500$
         *
         * Данная таблица представлена в формате
         * List<Map<String,String>>, где каждый элемент list - строка, key в map - название столбца,
         * value в map - значение ячейки
         *
         * Задача:
         *
         * - вывести имена всех сотрудников, младше 30.
         * - вывести имена всех сотрудников, получающих зарплату в рублях.
         * - вывести средний возраст всех сотрудников.
         */
        String NAME = "Имя";
        String AGE = "Возраст";
        String JOB = "Должность";
        String SALARY = "Зарплата";

        List<Map<String, String>> list = new ArrayList<>();
        Map<String, String> map1 = new HashMap<>();
        map1.put(NAME, "Кирилл");
        map1.put(AGE, "21");
        map1.put(JOB, "Тестер");
        map1.put(SALARY, "60000 руб.");

        Map<String, String> map2 = new HashMap<>();
        map2.put(NAME, "Роман");
        map2.put(AGE, "30");
        map2.put(JOB, "Автотестер");
        map2.put(SALARY, "150000 $");

        list.add(map1);
        list.add(map2);

        list.stream()
                .filter(m -> Integer.parseInt(m.get(AGE)) < 30)
                .forEach(System.out::println);

        list.stream()
                .filter(m -> Pattern.matches(".*\\$$", m.get(SALARY)))
                .forEach(System.out::println);

        long sum = list.stream()
                .map(m -> Integer.parseInt(m.get(AGE)))
                .reduce(0, Integer::sum);

        System.out.println((double) sum / list.size());

    }

    /**
     * Дан массив NxN. Напишите программу на Java которая находит минимальный
     * элемент побочной диагонали, без учёта элемента пересечения главной и побочной диагонали.
     * Для примера приведена матрица 5х5. Побочная диагональ выделена жирным, минимальный элемент побочной диагонали – красным и подчеркнут: 2
     * 1	2	3	4	5
     * 5	7	9	2	1
     * 0	9	1	8	7
     * 6	3	6	6	6
     * 99 	100	-2	3	1
     */
    @Test
    public void test9() {
        int[][] array = {{1, 2, 3, 4, 5}, {5, 7, 9, 2, 1}, {0, 9, 1, 8, 7}, {6, 3, 6, 6, 6}, {99, 100, -2, 3, 1}};
        List<Integer> list = new ArrayList<>();
        int excluded = 0;
        if (array.length % 2 != 0) {
            excluded = (int) Math.ceil((double) array.length / 2);
        }
        int j = array.length - 1;
        for (int[] ints : array) {
            list.add(ints[j]);
            j--;
        }
        if (excluded != 0) {
            list.remove(excluded - 1);
        }
        list.sort(Comparator.naturalOrder());
        System.out.println(list.get(0));
    }

}
