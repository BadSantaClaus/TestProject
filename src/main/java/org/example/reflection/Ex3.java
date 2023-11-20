package org.example.reflection;

import java.lang.reflect.Field;

public class Ex3 {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {

        //Получаем доступ к полям, у которых нет геттеров и можем их менять
        Employee employee = new Employee(10, "Roman", "IT");
        Class<? extends Employee> employeeClass = employee.getClass();
        Field fieldSalary = employeeClass.getDeclaredField("salary");
        fieldSalary.setAccessible(true);
        double salaryFromReflection = (Double) fieldSalary.get(employee);
        System.out.println(salaryFromReflection);

        fieldSalary.set(employee, 1500);
        salaryFromReflection = (Double) fieldSalary.get(employee);
        System.out.println(salaryFromReflection);
    }
}
