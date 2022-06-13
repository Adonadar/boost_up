package com.project.algorithms;

import com.project.data.Coin;
import com.project.data.connection.JdbcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
public class Head {
    private int countOfThread = 1;

    private Map<ParallelPercentPair, Algorithm> map = new HashMap<>();

    private ExecutorService executorService;

    private ParallelAnalysis parallelAnalysis;

    private JdbcService jdbcService;

    private List<Coin> coinList;

    private ParallelSortPairPercent parallelSortPairPercent;

    @Autowired
    public void setParallelAnalysis(ParallelAnalysis parallelAnalysis) {
        this.parallelAnalysis = parallelAnalysis;
    }

    @Autowired
    public void setJdbcService(JdbcService jdbcService) {
        this.jdbcService = jdbcService;
    }

    @Autowired
    public void setParallelSortPairPercent(ParallelSortPairPercent parallelSortPairPercent) {
        this.parallelSortPairPercent = parallelSortPairPercent;
    }

    public void start() {

        coinList = jdbcService.getTable("ETHUSDT_1m");
        parallelAnalysis = new ParallelAnalysis(1, 10);

        for(int i = 0; i < coinList.size(); i++) {
            parallelAnalysis.start(coinList.get(i).getOpenKline());
        }

        parallelSortPairPercent.sort(parallelAnalysis.getHashMap());

        List<Map.Entry<Double, ParallelPercentPair>> list = parallelSortPairPercent.getBest();

        System.out.println(list);

        executorService = Executors.newFixedThreadPool(countOfThread);

//        map.put(new ParallelPercentPair(7.0, 5.0), new Algorithm(new ParallelPercentPair(7.0, 5.0)));

        if(map.size() != 0) {
            for (Map.Entry<ParallelPercentPair, Algorithm> entry : map.entrySet()) {
                if (entry.getValue().isWorkDone()) {
                    System.out.println("Работа выполнена алгоритмом, он удален");
                    map.remove(entry.getKey());
                }
            }
        }

        if(map.size() == 0) {
            for(int i = 1; i <= countOfThread; i++) {
                map.put(list.get(list.size()-i).getValue(), new Algorithm(list.get(list.size()-i).getValue()));
                System.out.println("Создан алгоритм " + list.get(list.size()-i).getValue());
            }
        }

        if(countOfThread != 1) {
            if(map.size() > 0 && map.size() <= countOfThread) {
                for (Map.Entry<ParallelPercentPair, Algorithm> entry : map.entrySet()) {
                    for(int i = 1; i <= countOfThread; i++) {
                        int x = 1;
                        if(!entry.getKey().equals(list.get(list.size()-i).getValue())) {
                            x++;
                            continue;
                        }
                        if(x == countOfThread) {
                            map.put(list.get(list.size()-i).getValue(), new Algorithm(list.get(list.size()-i).getValue()));
                            System.out.println("Создан алгоритм " + list.get(list.size()-i).getValue());
                        }
                        if(x != countOfThread) {
                            System.out.println(entry.getKey() + " и " + list.get(list.size()-i).getValue() + " одинаковые");
                        }
                    }
                }
            }
        }

        for(int i = 0; i < coinList.size(); i++) {
            for (Map.Entry<ParallelPercentPair, Algorithm> entry : map.entrySet()) {
                entry.getValue().setNext(coinList.get(i).getOpenKline());
                entry.getValue().setTime(coinList.get(i).getOpenTime());
                entry.getValue().run();
            }
        }
        for (Map.Entry<ParallelPercentPair, Algorithm> entry : map.entrySet()) {
            entry.getValue().showStatisticBlock();
        }
        executorService.shutdown();
    }
}
