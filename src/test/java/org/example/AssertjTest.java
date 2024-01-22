package org.example;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.SoftAssertions;
import org.assertj.core.api.recursive.comparison.RecursiveComparisonConfiguration;
import org.example.reflection.Employee;
import org.example.reflection.Employee2;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.BiFunction;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class AssertjTest {

    @Test
    public void assertjTest() {
        List<Employee> list1 = List.of(new Employee("Jhon", "I"),
                new Employee("Jack", "C"));
        List<Employee> list2 = List.of(new Employee("Jerry", "S"),
                new Employee("Givi", "R"));
        List<Employee2> list3 = List.of(new Employee2("Jhon", "I"),
                new Employee2("Jack", "C"));


        RecursiveComparisonConfiguration configuration = new RecursiveComparisonConfiguration();
        configuration.useOverriddenEquals();
        configuration.ignoreFields("name", "department");
        configuration.strictTypeChecking(false);


        assertThat(list1)
                .usingRecursiveComparison(configuration)
                .isEqualTo(list2);
    }

    @Test
    public void assertationsTest() {
        SoftAssertions assertions = new SoftAssertions();
        assertions.fail("Object not found");
        assertions.assertThat(40)
                        .isEqualTo(10);
        //assertions.errorsCollected().forEach(er -> log.error("Errors: ", er));
        //assertions.assertAll();
        assertions.assertAlso(get().apply(10, 20));
    }

    public BiFunction<Integer, Integer, SoftAssertions> get() {
        return (n1, n2) -> {
            SoftAssertions softAssertions = new SoftAssertions();
            softAssertions.assertThat(n1)
                    .isEqualTo(n2);
            return softAssertions;
        };
    }
}
