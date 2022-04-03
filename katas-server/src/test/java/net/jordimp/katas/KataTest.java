package net.jordimp.katas;

import java.util.Date;

public class KataTest {

    public static void main(String[] args) {
        System.out.println("Hello World!");

    }

    int calculateDaysBetweenDates(Date startDate, Date endDate) {
        long diff = endDate.getTime() - startDate.getTime();
        return (int) (diff / (24 * 60 * 60 * 1000));
    }
}
