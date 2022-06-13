package com.project.test;

import com.project.algorithms.ParallelPercentPair;
import com.project.algorithms.ParallelPrototypeAlgorithm;

import java.util.HashMap;
import java.util.Map;

public class Start25 {
    public static void main(String[] args) {
        Map map = new HashMap();
        for(int i = 1; i <= 3; i++) {
            for(int x = 1; x <= 3; x++) {
                ParallelPercentPair couplePercent = new ParallelPercentPair(i, x);
                ParallelPrototypeAlgorithm prototypeGreyMouse = new ParallelPrototypeAlgorithm();

                prototypeGreyMouse.setLastPrice(333);
                prototypeGreyMouse.setPointA(333);
                prototypeGreyMouse.incrementCount();

                map.put(couplePercent, prototypeGreyMouse);
            }
        }

        System.out.println(map);
        System.out.println("---------------------------------------------------------------------");

        for(int i = 1; i <= 3; i++) {
            for(int x = 1; x <= 3; x++) {
                ParallelPercentPair couplePercent = new ParallelPercentPair(i, x);
                ParallelPrototypeAlgorithm prototypeGreyMouse = (ParallelPrototypeAlgorithm) map.get(couplePercent);

                double cou = Math.random() * 10;

                prototypeGreyMouse.setLastPrice(cou);
                prototypeGreyMouse.setPointA(cou);
                prototypeGreyMouse.incrementCount();

                map.put(couplePercent, prototypeGreyMouse);

                if(prototypeGreyMouse.isBuy()) {
                    go(prototypeGreyMouse);
                }
            }
        }

        System.out.println(map);
    }

    public static void go(ParallelPrototypeAlgorithm prototypeGreyMouse) {
        prototypeGreyMouse.setCountOfCoin(222);
    }
}
