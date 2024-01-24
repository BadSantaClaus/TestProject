package org.example.testng;

import org.example.annotation.ExportTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class AnnotationTest {

    @Test(expectedExceptions = NumberFormatException.class)
    @ExportTest(name = "")
    public void test() {
        System.out.println("test start");
        Integer.parseInt("One");
    }

    @BeforeMethod()
    public void start2(Method method) {
        System.out.println(method
                .getAnnotation(ExportTest.class) == null);
    }
}
