package com.project.test;

import com.project.algorithms.ParallelPercentPair;

import java.util.*;

public class Start18 {
    public static void main(String[] args) throws InterruptedException {
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
//        GreyMouse greyMouse = context.getBean("greyMouse",  GreyMouse.class);
//
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
//        JdbcService jdbcService = context.getBean("jdbcService",  JdbcService.class);

//        greyMouse.analysis();
//        greyMouse.showBalance();

        TreeMap<Double, ParallelPercentPair> array = new TreeMap<>();
        array.put(32.23, new ParallelPercentPair(1,1));
        array.put(12.23, new ParallelPercentPair(2,2));
        array.put(2.11, new ParallelPercentPair(3,3));
        System.out.println(array);

//        AlgorithmGreyMouse greyMouse;
//
//        for(int i = 1; i <= 20; i++) {
//            for(int x = 1; x <= 20; x++) {
//                greyMouse = new AlgorithmGreyMouse(i, x);
//                greyMouse.setJdbcService(jdbcService);
//                greyMouse.analysis();
//                System.out.println("Баланс при проценте покупки " + i + " при проценте продажи " + x);
//                greyMouse.showBalance();
////                array.put(greyMouse.getBalance(), new CouplePercent(i, x, greyMouse.getCount()));
//                System.out.println(array);
//            }
//        }

//        context.close();
    }
}
