package org.example.reflection;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class Employee {

    public int id;

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

}

