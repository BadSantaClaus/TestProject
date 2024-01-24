package org.example.jupiter;

import org.example.annotation.ExportTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

public class AnnotationTest {

    @Test
    @ExportTest(name = "")
    public void test() {
        System.out.println("test start");
        NumberFormatException thrown = Assertions.assertThrows(NumberFormatException.class, () -> {
            Integer.parseInt("One");
        });
    }

    @BeforeEach()
    public void start(TestInfo testInfo) {
        System.out.println(testInfo.getTestMethod().orElseThrow()
                .getAnnotation(ExportTest.class) == null);
    }
}
