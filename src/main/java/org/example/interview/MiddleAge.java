package org.example.interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class MiddleAge {

    /**
     * Дана таблица:
     * Имя|Возраст|Должность|Зарплата
     * Кирилл|26|Middle java dev|150000 руб
     * Виталий|28|Senior java automation QA|2000$
     * Александр|31|junior functional tester|50000 руб
     * Дементий|35|dev-ops|1500$
     * <p>
     * Данная таблица представлена в формате
     * List<Map<String,String>>, где каждый элемент list - строка, key в map - название столбца,
     * value в map - значение ячейки
     * <p>
     * Задача:
     * <p>
     * - вывести имена всех сотрудников, младше 30.
     * - вывести имена всех сотрудников, получающих зарплату в рублях.
     * - вывести средний возраст всех сотрудников.
     */

    public static void main(String[] args) {
        testEmployees();
    }

    public static void testEmployees() {
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
}
