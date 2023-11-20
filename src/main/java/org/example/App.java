package org.example;

import org.example.reflection.Employee;

import java.lang.reflect.Field;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws ClassNotFoundException, NoSuchFieldException {
        //3 Варианта создания обьекта класса Class
        //1
        Class<?> employeeClass = Class.forName("rg.example.reflection.Employee");
        //2
        Class<Employee> employeeClass2 = Employee.class;
        //3
        Employee emp = new Employee();
        Class<? extends Employee> employeeClass3 = emp.getClass();

        Field field = employeeClass.getField("id" );
        System.out.println("Type of field - " + field.getType());
    }
}
