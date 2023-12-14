package org.example.interview;

import java.time.LocalDate;

public class IterateThroughYear {

    public static void main(String[] args) {
        LocalDate start = LocalDate.of(2023, 1, 1);
        LocalDate end = start.plusYears(1);
        for (LocalDate date = start; date.isBefore(end); date = date.plusDays(1)) {
            System.out.println(date);
        }
    }
}
