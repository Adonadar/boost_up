package com.project.test;

import com.project.algorithms.ParallelPercentPair;
import com.project.algorithms.ParallelPrototypeAlgorithm;

import java.util.HashMap;
import java.util.Map;

public class Start23 {
    public static void main(String[] args) {
        Map map = new HashMap<>();

        ParallelPercentPair couplePercent = new ParallelPercentPair(1 ,2);

        ParallelPrototypeAlgorithm prototypeGreyMouse = new ParallelPrototypeAlgorithm();
        prototypeGreyMouse.setBalance(1000);

        ParallelPercentPair couplePercent1 = new ParallelPercentPair(1, 2);

        map.put(couplePercent, prototypeGreyMouse);
        System.out.println(map);
        prototypeGreyMouse.setBalance(300);

        map.put(couplePercent1, prototypeGreyMouse);
        System.out.println(map);
    }
}

