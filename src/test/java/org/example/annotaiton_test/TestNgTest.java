package org.example.annotaiton_test;

import org.example.annotation.ExportTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class TestNgTest {

    @Test
    @ExportTest
    public void test() {
        System.out.println("test start");
    }

    @BeforeMethod()
    public void start2(Method method) {
        System.out.println(method
                .getAnnotation(ExportTest.class) == null);
    }
}
