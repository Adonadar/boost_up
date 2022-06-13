package com.project.test;

import java.util.Calendar;

public class Start10 {
    public static void main(String[] args) {
//        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(date);
        System.out.println(calendar.get(Calendar.YEAR));
        System.out.println(calendar.get(Calendar.MONTH));
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
    }
}
