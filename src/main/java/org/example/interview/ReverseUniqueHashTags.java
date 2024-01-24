package org.example.interview;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ReverseUniqueHashTags {

    //Написать метод, на вход которого приходит массив строк. содержащих в том числе и хештеги - на выход надо выдать тоже массив,
    // но уникальных хештегов, отсортированных в обратном порядке.
    // {"Сегодня в #Москва хорошая погода", "А в #Питер идет #дождь", "Вчера тоже был в #Москва"}
    // отсортировать по частоте встречаемых слов с хэштегом

    public static void main(String[] args) {
        String[] array = new String[]{"Сегодня в #Москва хорошая погода",
                "А в #Питер идет #Дождь",
                "Вчера #дождь тоже #москва был в #москва"};
        getReversAlphabetOrderList(array).forEach(System.out::println);
        System.out.println("================================================");
        getReverseCountOrderList(array).forEach(System.out::println);
    }

    public static List<String> getReversAlphabetOrderList(String[] array) {
        return Arrays.stream(array)
                .map(s -> s.split(" "))
                .flatMap(Arrays::stream)
                .filter(s -> s.startsWith("#"))
                .map(String::toLowerCase)
                .distinct()
                .sorted(Comparator.reverseOrder())
                .toList();
    }

    public static List<String> getReverseCountOrderList(String[] array) {
        Map<String, Long> map = Arrays.stream(array)
                .map(s -> s.split(" "))
                .flatMap(Arrays::stream)
                .filter(s -> s.startsWith("#"))
                .map(String::toLowerCase)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        return map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Collections.reverseOrder()))
                .map(Map.Entry::getKey)
                .toList();

    }

}
