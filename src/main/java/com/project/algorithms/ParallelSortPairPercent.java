package com.project.algorithms;

import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class ParallelSortPairPercent {
    private int lowPercent = 1;
    private int highPercent = 10;

    private TreeMap<Double, ParallelPercentPair> treeMap = new TreeMap<>();
    private TreeMap<Double, Integer> treeMapCount = new TreeMap<>();

    public void sort(Map map) {
        for(int i = lowPercent; i <= highPercent; i++) {
            for(int x = lowPercent; x <= highPercent; x++) {
                ParallelPercentPair parallelPercentPair = new ParallelPercentPair(i , x);
                ParallelPrototypeAlgorithm parallelPrototypeAlgorithm = (ParallelPrototypeAlgorithm) map.get(parallelPercentPair);
                treeMap.put(parallelPrototypeAlgorithm.getBalance(), parallelPercentPair);
                treeMapCount.put(parallelPrototypeAlgorithm.getBalance(), parallelPrototypeAlgorithm.getCountOfOperation());
            }
        }
        System.out.println(treeMapCount);
        System.out.println(treeMap.size());
        System.out.println(treeMapCount.size());
    }

    public List<Map.Entry<Double, ParallelPercentPair>> getBest() {
        Set<Map.Entry<Double, ParallelPercentPair>> entrySet = treeMap.entrySet();
        List<Map.Entry<Double, ParallelPercentPair>> entryList = new ArrayList<>(entrySet);
        return entryList;
    }
}
