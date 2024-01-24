package org.example.db_utils;

public class AppDb {

    public static void main(String[] args) {
        DbHelper dbHelper = new DbHelper("jdbc:postgresql://localhost:5432/ApacheDbTest?currentSchema=apache_db_test");
        Employee3 employee3 = dbHelper.findEmp("John");
        System.out.println(employee3);
    }
}
