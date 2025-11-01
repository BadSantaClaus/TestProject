package org.example;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import org.example.reflection.Employee;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SimpleTest {

    @Test
    @SneakyThrows
    public void test() {
        ObjectMapper objectMapper = new ObjectMapper();

        // Читаем оба JSON-файла
        JsonNode json1 = objectMapper.readTree(new File("src/test/resources/1a.json"));
        JsonNode json2 = objectMapper.readTree(new File("src/test/resources/1b.json"));

        // Сравниваем их
        boolean isEqual = json1.equals(json2);
        System.out.println(isEqual);
    }

    @Test
    @SneakyThrows
    void test2() {
        // Чтение JSON-файлов как строки
        String json1 = new String(Files.readAllBytes(Paths.get("src/test/resources/1a.json")));
        String json2 = new String(Files.readAllBytes(Paths.get("src/test/resources/1b.json")));

        // Сравнение с учетом эквивалентности (без учета порядка полей)
        JSONAssert.assertEquals(json1, json2, false);
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 3, 4, 5};
        int[] array1 = new int[]{6, 5, 4, 3};
        int[] array2 = new int[]{1, 31, 4, 6};
        int[] array3 = new int[]{61, 31, 4, 6};

        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(checkArray(array)).isTrue();
        softAssertions.assertThat(checkArray(array1)).isTrue();
        softAssertions.assertThat(checkArray(array2)).isFalse();
        softAssertions.assertThat(checkArray(array3)).isFalse();
        softAssertions.assertAll();
    }

    static boolean checkArray(int[] array) {
        if (array.length > 2) {
            boolean ascend = array[0] < array[1];
            boolean isChecked;
            for (int i = 0; i < array.length - 1; i++) {
                if (ascend) {
                    isChecked = array[i] < array[i + 1];
                } else {
                    isChecked = array[i] > array[i + 1];
                }
                if (!isChecked) return false;
            }
        }
        return true;
    }

    public static class Node {
        public List<Node> child = new ArrayList<>();
        public String name;

        public Node(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    public static class Util {
        public static List<Node> toFlatList(Node n) {
            List<Node> result = new ArrayList<>();
            result.add(n);
            if (!n.child.isEmpty()) {
                for (Node node : n.child) {
                    result.add(node);
                    if (!node.child.isEmpty()) {
                        result.remove(node);
                        result.addAll(toFlatList(node));
                    }
                }
            }
            return result;
        }
    }

    @Test
    public void treeTest() {
        Node a = new Node("a");
        Node b = new Node("b");
        Node c = new Node("c");
        Node d = new Node("d");
        Node e = new Node("e");
        Node f = new Node("f");

        a.child.add(b);
        a.child.add(c);

        c.child.add(d);
        c.child.add(e);
        c.child.add(f);

        List<Node> result = Util.toFlatList(a);

        Assertions.assertThat(result).containsExactlyInAnyOrder(a, b, c, d, e, f);
    }

}
