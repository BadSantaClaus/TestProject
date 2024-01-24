package org.example.jupiter;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.List;
import java.util.stream.Stream;

public class DataProviderTest {

    @ParameterizedTest
    @ArgumentsSource(DataProvider.class)
    public void test(List<Object> st) {
        for (Object o : st) {
            System.out.println(o);
        }
    }

    static class DataProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
            return Stream.of(
                    Arguments.of(List.of("Hi", "Jack")),
                    Arguments.of(List.of("Hi", "Jack", "world"))
            );
        }
    }
}
