package com.my.concurrency.test;

import java.util.Date;

public class TestAnything {
    public static void main(String[] args) {
        Date date = new Date();
        date.setYear(date.getYear() + 1);
        System.out.println(date);

    }
}
