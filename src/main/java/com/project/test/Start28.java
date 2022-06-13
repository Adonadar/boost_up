package com.project.test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Start28 {
    public static void main(String[] args) {
        List<Double> list = new ArrayList<>();

        long start = System.currentTimeMillis();

        for(int i = 0; i < 1000000; i++) {
            list.add(Double.valueOf(i));
        }

        list.remove(0);
        list.add(20.0);
        System.out.println(list.get(0));
        System.out.println(list.get(list.size()-1));

        long end = System.currentTimeMillis();

        System.out.println(end - start);
    }
}
