package org.example.reflection;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Calculator {

    private void sum(int a, int b) {
        System.out.println("Sum = " + (a + b));
    }

    private void subtraction(int a, int b) {
        System.out.println("Subtraction = " + (a - b));
    }

    private void multiplication(int a, int b) {
        System.out.println("Multiplication = " + (a * b));
    }

    private void division(int a, int b) {
        System.out.println("Division = " + ((double) a / b));
    }
}

class TestCalculator {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("test100.txt"))) {
            String methodName = reader.readLine();
            String firstArgument = reader.readLine();
            String secondArgument = reader.readLine();

            Calculator calculator = new Calculator();

            Method method = Arrays.stream(calculator.getClass().getDeclaredMethods())
                    .peek((m) -> m.setAccessible(true))
                    .filter((m) -> m.getName().equals(methodName))
                    .findFirst()
                    .orElseThrow();

            method.invoke(calculator, Integer.parseInt(firstArgument), Integer.parseInt(secondArgument));

            //Without Reflection. Нельзя сделать если методы приватные
//            if(methodName.equals("sum")) {
//                calculator.sum(Integer.parseInt(firstArgument), Integer.parseInt(secondArgument));
//            }
//            if(methodName.equals("subtraction")) {
//                calculator.subtraction(Integer.parseInt(firstArgument), Integer.parseInt(secondArgument));
//            }
//            if(methodName.equals("multiplication")) {
//                calculator.multiplication(Integer.parseInt(firstArgument), Integer.parseInt(secondArgument));
//            }
//            if(methodName.equals("division")) {
//                calculator.division(Integer.parseInt(firstArgument), Integer.parseInt(secondArgument));
//            }

        } catch (IOException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}