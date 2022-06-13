package com.project.test;

import com.project.algorithms.ParallelPercentPair;
import com.project.algorithms.ParallelPrototypeAlgorithm;

import java.util.HashMap;
import java.util.Map;

public class Start26 {
    public static void main(String[] args) {
        Map map = new HashMap<>();
        ParallelPercentPair couplePercent = new ParallelPercentPair(5,8);
        ParallelPrototypeAlgorithm prototypeGreyMouse = new ParallelPrototypeAlgorithm();
        prototypeGreyMouse.setPointA(300);
        map.put(couplePercent, prototypeGreyMouse);
        System.out.println(map);

        ParallelPrototypeAlgorithm prototypeGreyMouseModify = (ParallelPrototypeAlgorithm) map.get(couplePercent);

        if(prototypeGreyMouseModify.isBuy()) {
            System.out.println("tut");
            prototypeGreyMouseModify.setCountOfCoin(prototypeGreyMouseModify.getBalance()/couplePercent.getPercentBuy());
            prototypeGreyMouseModify.setBalance(0);
            prototypeGreyMouseModify.setBuy(false);
            prototypeGreyMouseModify.setSell(true);
        }

        System.out.println(map);

        if(prototypeGreyMouseModify.isSell()) {
            prototypeGreyMouseModify.setBalance(prototypeGreyMouseModify.getCountOfCoin() * couplePercent.getPercentSell());
            prototypeGreyMouseModify.setCountOfCoin(0);
            prototypeGreyMouseModify.setBuy(true);
            prototypeGreyMouseModify.setSell(false);
        }

        System.out.println(map);
    }
}
