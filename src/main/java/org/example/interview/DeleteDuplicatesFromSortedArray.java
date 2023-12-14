package org.example.interview;

import java.util.ArrayList;
import java.util.List;

public class DeleteDuplicatesFromSortedArray {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 6, 6, 7, 7, 8, 8, 9, 9, 9, 10};
        getListWithoutFuplicates(arr).forEach(System.out::println);
    }
    public static List<Integer> getListWithoutFuplicates(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] != arr[i + 1]) {
                list.add(arr[i]);
            }
        }
        list.add(arr[arr.length - 1]);
        return list;
    }
}
