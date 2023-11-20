package org.example.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Ex2 {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException,
            InstantiationException, IllegalAccessException {
        Class<Employee> employeeClass = Employee.class;

        System.out.println("\n****Employee****\n");
        Constructor<Employee> constructor2 = employeeClass.getConstructor(int.class, String.class, String.class);
        Object employee = constructor2.newInstance(1, "John", "IT");
        System.out.println(employee);

        System.out.println("\n****Method****\n");
        Method method = employeeClass.getMethod("setSalary", double.class);
        method.invoke(employee, 23.2);
        System.out.println(employee);

    }
}
