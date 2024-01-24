package org.example;

import lombok.SneakyThrows;
import org.example.annotation.ExportTest;
import org.testng.annotations.Test;


import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

@ExportTest(name = "annotated class")
public class SimpleTest {



    @ExportTest(name = "export method")
    @SneakyThrows
    public static void test() {
        Class<?> clazz = ClassLoader.getSystemClassLoader()
                .loadClass("org.example.SimpleTest");
        ExportTest classAnnotation = clazz.getAnnotation(ExportTest.class);
        System.out.println(classAnnotation);
        Method[] methods = clazz.getMethods();
        List<String> annotatedMethods = new ArrayList<>();
        for (Method method : methods) {
            ExportTest annotation = method.getAnnotation(ExportTest.class);
            if (annotation != null) {
                annotatedMethods.add(annotation.name());
            }
        }
        annotatedMethods.forEach(System.out::println);

        Method methodByName = clazz.getMethod("test");
        System.out.println(methodByName.getAnnotation(ExportTest.class));
    }

    @SneakyThrows
    public static void test(String m) {
        Class<?> clazz = ClassLoader.getSystemClassLoader()
                .loadClass("org.example.SimpleTest");
        Method methodByName = clazz.getMethod("test", String.class);
        System.out.println(methodByName.getAnnotation(ExportTest.class));
    }


    public static void main(String[] args) {
        //test();
        test("test");
    }

}
