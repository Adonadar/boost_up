package com.project.algorithms;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class ParallelAnalysis {
    private int lowPercent;

    private int highPercent;

    private boolean firstStart = true;

    private Map<ParallelPercentPair, ParallelPrototypeAlgorithm> hashMap = new HashMap();

    public void start(Double next) {
        if(firstStart) {
            for(int i = lowPercent; i <= highPercent; i++) {
                for(int x = lowPercent; x <= highPercent; x++) {
                    ParallelPercentPair parallelPercentPair = new ParallelPercentPair(i, x);
                    hashMap.put(parallelPercentPair, new ParallelPrototypeAlgorithm());

                    ParallelPrototypeAlgorithm parallelPrototypeAlgorithm = hashMap.get(parallelPercentPair);
                    parallelPrototypeAlgorithm.setLastPrice(next);
                    parallelPrototypeAlgorithm.setPointA(next);
                    parallelPrototypeAlgorithm.incrementCount();
                    parallelPrototypeAlgorithm.setParallelPercentPair(new ParallelPercentPair(i, x));

                }
            }

            firstStart = false;
        }

        for(int i = lowPercent; i <= highPercent; i++) {
            for (int x = lowPercent; x <= highPercent; x++) {
                ParallelPercentPair parallelPercentPair = new ParallelPercentPair(i, x);
                ParallelPrototypeAlgorithm parallelPrototypeAlgorithm = hashMap.get(parallelPercentPair);

                if(parallelPrototypeAlgorithm.isBuy()) {
                    buy(next, parallelPercentPair, parallelPrototypeAlgorithm);
                    continue;
                }

                if(parallelPrototypeAlgorithm.isSell()) {
                    sell(next, parallelPercentPair, parallelPrototypeAlgorithm);
                    continue;
                }
            }
        }
    }

    public void buy(Double next, ParallelPercentPair parallelPercentPair, ParallelPrototypeAlgorithm parallelPrototypeAlgorithm) {

        if(parallelPrototypeAlgorithm.getPointA() > next) {
            parallelPrototypeAlgorithm.setPointA(next);
        }

        if(parallelPrototypeAlgorithm.getPointA() + (parallelPrototypeAlgorithm.getPointA() * (parallelPercentPair.getPercentBuy() / 100)) < next) {
            parallelPrototypeAlgorithm.setPointB(next);
            parallelPrototypeAlgorithm.setPointC(next);
            parallelPrototypeAlgorithm.setCountOfCoin(parallelPrototypeAlgorithm.getBalance() / next);
            parallelPrototypeAlgorithm.incrementCountOfOperation();
            parallelPrototypeAlgorithm.setBuy(false);
            parallelPrototypeAlgorithm.setSell(true);

            parallelPrototypeAlgorithm.setTurnStopLoss(next + next/100);
            parallelPrototypeAlgorithm.setStopLoss(next + next/200);
            parallelPrototypeAlgorithm.setCriticalStopLoss(next - next/100);
        }

        parallelPrototypeAlgorithm.setLastPrice(next);
        parallelPrototypeAlgorithm.incrementCount();
    }

    public void sell(Double next, ParallelPercentPair parallelPercentPair, ParallelPrototypeAlgorithm parallelPrototypeAlgorithm) {
        if(parallelPrototypeAlgorithm.getTurnStopLoss() < next) {
            parallelPrototypeAlgorithm.setStopSell(true);
        }

        if(parallelPrototypeAlgorithm.getPointB() < next) {
            parallelPrototypeAlgorithm.setPointB(next);
        }

        if(parallelPrototypeAlgorithm.getPointB() - (parallelPrototypeAlgorithm.getPointB() * (parallelPercentPair.getPercentSell() / 100)) > next) {
            parallelPrototypeAlgorithm.setPointA(next);
            parallelPrototypeAlgorithm.setBalance(parallelPrototypeAlgorithm.getCountOfCoin() * next);
            parallelPrototypeAlgorithm.incrementCountOfOperation();
            parallelPrototypeAlgorithm.setBuy(true);
            parallelPrototypeAlgorithm.setSell(false);

            parallelPrototypeAlgorithm.setStopSell(false);
        }

        if(parallelPrototypeAlgorithm.isStopSell() == true && parallelPrototypeAlgorithm.getStopLoss() > next) {
            parallelPrototypeAlgorithm.setPointA(next);
            parallelPrototypeAlgorithm.setBalance(parallelPrototypeAlgorithm.getCountOfCoin() * next);
            parallelPrototypeAlgorithm.incrementCountOfOperation();
            parallelPrototypeAlgorithm.setBuy(true);
            parallelPrototypeAlgorithm.setSell(false);

            parallelPrototypeAlgorithm.setStopSell(false);
        }

        if(parallelPrototypeAlgorithm.getCriticalStopLoss() > next) {
            parallelPrototypeAlgorithm.setPointA(next);
            parallelPrototypeAlgorithm.setBalance(parallelPrototypeAlgorithm.getCountOfCoin() * next);
            parallelPrototypeAlgorithm.incrementCountOfOperation();
            parallelPrototypeAlgorithm.setBuy(true);
            parallelPrototypeAlgorithm.setSell(false);

            parallelPrototypeAlgorithm.setStopSell(false);
        }

        parallelPrototypeAlgorithm.setLastPrice(next);
        parallelPrototypeAlgorithm.incrementCount();
    }

    public ParallelAnalysis() {
    }

    public ParallelAnalysis(int lowPercent, int highPercent) {
        this.lowPercent = lowPercent;
        this.highPercent = highPercent;
    }

    public Map getHashMap() {
        return hashMap;
    }
}
