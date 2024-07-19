package org.example;

import org.example.nested_classes.NestedClass;
import org.junit.jupiter.api.Test;

public class NestedClassTest {

    @Test
    public void test() {
        NestedClass nestedClass = new NestedClass();
        NestedClass.InnerClass innerClass = nestedClass.new InnerClass();
        innerClass.getAllYouHave();

        NestedClass.StaticInnerClass staticInnerClass = new NestedClass.StaticInnerClass();
        staticInnerClass.getAllYouHave();
    }
}
