package org.example.annotaiton_test;

import org.example.annotation.ExportTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

public class JupiterTest {

    @Test
    @ExportTest
    public void test() {
        System.out.println("test start");
    }

    @BeforeEach()
    public void start(TestInfo testInfo) {
        System.out.println(testInfo.getTestMethod().orElseThrow()
                .getAnnotation(ExportTest.class) == null);
    }
}
