package org.example.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Ex1 {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException {
        //3 Варианта создания объекта класса Class
        //1
        Class<?> employeeClass = Class.forName("org.example.reflection.Employee");
        //2
        Class<Employee> employeeClass2 = Employee.class;
        //3
        Employee emp = new Employee();
        Class<? extends Employee> employeeClass3 = emp.getClass();

        Field field = employeeClass.getField("id" );
        System.out.println("Type of field - " + field.getType());

        System.out.println("\n****WithPublicFields****\n");
        Field [] fields = employeeClass.getFields();
        Arrays.stream(fields)
                .forEach((f) -> {
                    System.out.print(f.getType() + " - ");
                    System.out.println(f.getName());
                });

        System.out.println("\n****WithPrivateFields****\n");
        Field [] allFields = employeeClass.getDeclaredFields();
        Arrays.stream(allFields)
                .forEach((f) -> {
                    System.out.print(f.getType() + " - ");
                    System.out.println(f.getName());
                });

        System.out.println("\n****Method****\n");
        Method methodIncreaseSalary = employeeClass.getMethod("increaseSalary");
        System.out.println("Return type of method - " + methodIncreaseSalary.getReturnType() + " " + Arrays.toString(methodIncreaseSalary.getParameterTypes()));

        System.out.println("\n****Method****\n");
        Method methodSetSalary = employeeClass.getMethod("setSalary", double.class);
        System.out.println("Return type of method - " + methodSetSalary.getReturnType() + " " + Arrays.toString(methodSetSalary.getParameterTypes()));

        System.out.println("\n****WithPublicMethodsWithParent****\n");
        //Возвращает еще и те методы, которые были унаследованы от родителей
        Method[] methods = employeeClass.getMethods();
        Arrays.stream(methods)
                .forEach((f) -> {
                    System.out.print(f.getName() + " - ");
                    System.out.println(Arrays.toString(f.getParameterTypes()));
                });

        System.out.println("\n****WithPublicMethodsWithoutParent****\n");
        //Возвращает только те методы которые написаны или переопределены в классе
        Method[] methods3 = employeeClass.getDeclaredMethods();
        Arrays.stream(methods3)
                .forEach((f) -> {
                    if(Modifier.isPublic(f.getModifiers())) {
                        System.out.print(f.getName() + " - ");
                        System.out.println(Arrays.toString(f.getParameterTypes()));
                    }
                });

        System.out.println("\n****WithPrivateMethods****\n");
        //Возвращает только те методы которые написаны или переопределены в классе
        Method[] methods2 = employeeClass.getDeclaredMethods();
        Arrays.stream(methods2)
                .forEach((f) -> {
                    System.out.print(f.getName() + " - ");
                    System.out.println(Arrays.toString(f.getParameterTypes()));
                });

        System.out.println("\n****Constructor****\n");
        Constructor<?> constructor = employeeClass.getConstructor();
        System.out.println("ParameterCount - " + constructor.getParameterCount() + ". Types - " + Arrays.toString(constructor.getParameterTypes()));

        System.out.println("\n****Constructor****\n");
        Constructor<?> constructor2 = employeeClass.getConstructor(int.class, String.class, String.class);
        System.out.println("ParameterCount - " + constructor2.getParameterCount() + ". Types - " + Arrays.toString(constructor2.getParameterTypes()));

        System.out.println("\n****WithPublicConstructor****\n");
        Constructor<?> [] constructors = employeeClass.getConstructors();
        Arrays.stream(constructors)
                .forEach((f) -> {
                    System.out.print(f.getName() + " - ");
                    System.out.println(Arrays.toString(f.getParameterTypes()));
                });


    }
}
