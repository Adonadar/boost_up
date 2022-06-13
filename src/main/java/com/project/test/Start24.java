package com.project.test;

import com.project.algorithms.ParallelAnalysis;
import com.project.algorithms.ParallelSortPairPercent;

public class Start24 {
    public static void main(String[] args) throws CloneNotSupportedException {
        ParallelAnalysis analysis = new ParallelAnalysis(1, 10);
        ParallelSortPairPercent parallelSortPairPercent = new ParallelSortPairPercent();

//        analysis.start(100.0);
////        System.out.println(analysis.getMap());
//        analysis.start(99.0);
//        analysis.start(101.0);
//        analysis.start(105.0);
//        analysis.start(103.0);
//        System.out.println(analysis.getMap());

//        for(int i = 100; i > 50; i--) {
//            parallelSortPairPercent.sort(analysis.start((double) i));
////            System.out.println(analysis.getMap());
//        }
//        for(int i = 50; i < 150; i++) {
//            parallelSortPairPercent.sort(analysis.start((double) i));
//        }
//        for(int i = 150; i > 100; i--) {
//            parallelSortPairPercent.sort(analysis.start((double) i));
//        }

        parallelSortPairPercent.getBest();

//        System.out.println(analysis.getHashMap());
    }
}
