package com.project.test;

import com.project.algorithms.ParallelPercentPair;

public class Start22 {
    public static void main(String[] args) {
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
//        ProfitManager profitManager = context.getBean("profitManager", ProfitManager.class);
//        profitManager.calculate(17.3);
//        context.close();
        ParallelPercentPair couplePercent = new ParallelPercentPair(1, 2);
        ParallelPercentPair couplePercent1 = new ParallelPercentPair(1, 2);
        System.out.println(couplePercent.equals(couplePercent1));
    }
}
