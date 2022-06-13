package com.project.test;

import com.project.algorithms.ParallelPercentPair;

import java.util.LinkedHashMap;

public class Start21 {
    public static void main(String[] args) {
        LinkedHashMap map = new LinkedHashMap<>();
        map.put(new ParallelPercentPair(1,1), 100);
        map.put(new ParallelPercentPair(2,2), 200);
        map.put(new ParallelPercentPair(3,3), 50);
        System.out.println(map);
        ParallelPercentPair pair = new ParallelPercentPair(1,1);
        map.put(pair, 130);
        System.out.println(map);
    }
}
