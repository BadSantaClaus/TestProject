package org.example.interview;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MatrixCount {

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
    public static void main(String[] args) {
        int[][] array = {{1, 2, 3, 4, 5}, {5, 7, 9, 2, 1}, {0, 9, 1, 8, 7}, {6, 3, 6, 6, 6}, {99, 100, -2, 3, 1}};
        System.out.println(getMinElement(array));
    }

    public static int getMinElement(int[][] array) {
        List<Integer> list = new ArrayList<>();
        int excluded = 0;
        if (array.length % 2 != 0) {
            excluded = array.length / 2;
        }
        int j = array.length - 1;
        for (int[] ints : array) {
            list.add(ints[j]);
            j--;
        }
        if (excluded != 0) {
            list.remove(excluded);
        }
        list.sort(Comparator.naturalOrder());
        return list.get(0);
    }
}
