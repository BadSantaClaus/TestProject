package org.example.reflection;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;


@ToString
public class Employee {

    public int id;

    @Setter
    @Getter
    public String name;
    public String department;
//    @Getter
//    @Setter
    private double salary = 1000;

    public Employee() {
    }

    public Employee(int id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;

    }

    public Employee(String name, String department) {
        this.name = name;
        this.department = department;

    }

    public Employee(String name) {
        this.name = name;
    }

//    public Employee(int id, String name, String department, double salary) {
//        this.id = id;
//        this.name = name;
//        this.department = department;
//        this.salary = salary;
//    }

    private void changeDepartment(String newDepartment) {
        department = newDepartment;
        System.out.println("New dep - " + department);
    }

    public void increaseSalary() {
        salary *= 2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Double.compare(salary, employee.salary) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(salary);
    }

}

