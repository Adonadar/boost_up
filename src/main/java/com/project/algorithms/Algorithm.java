package com.project.algorithms;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Algorithm implements Runnable {

    private double next;

    private double pointA;
    private double pointB;
    private double pointC;

    private ParallelPercentPair parallelPercentPair;

    private boolean workDone = false;
    private boolean isBuy = true;
    private boolean isSell = false;
    private boolean first = true;

    private double countOfCoin = 0;
    private double balance = 10;

    private double turnStopLoss;
    private double stopLoss;
    private double criticalStopLoss;
    private boolean stopSell = false;
    private boolean ready = false;

    private int block1 = 0;
    private int block2 = 0;
    private int block3 = 0;

    private double tax = 0;

    private double lastSum = 0;
    private double midLine = 0;
    private int counter = 0;
    private List<Double> list  = new ArrayList<>();
    private double sum = 0;
    private int course = 0;

    private Date date = new Date();
    private Long time;

    @Override
    public void run() {
        if(first) {
            prepareToStart();
        }
        if(pointA == 0) {
            System.out.println("Не задана начальная точка");
            return;
        }

//        if(list.size() == 43200) {
//            list.remove(0);
//        }
//
//        if(list.size() < 43200) {
//            list.add(next);
//        }
//
//        for(int i = 0; i < list.size(); i++) {
//            sum = sum + list.get(i);
//        }
//
//        midLine = sum / list.size();
//        sum = 0;

//        if(midLine + midLine/33 < next) {
            if(isBuy) {
                buy();
            }
//        }
        if(isSell) {
            sell();
        }
    }

    private void buy() {
        if(pointA > next) {
            pointA = next;
        }

        if(pointA + (pointA * (parallelPercentPair.getPercentBuy() / 100)) < next) {
            pointB = next;
            pointC = next;
            turnStopLoss = next + next/100;
            stopLoss = next + next/200;
            criticalStopLoss = next - next/100;
            countOfCoin = balance / next;
            tax = tax + balance * 0.00075;
            isBuy = false;
            isSell = true;
            date.setTime(time);
            System.out.println("Покупка " + date + " цена " + next + " колличество коинов " + countOfCoin);
        }
    }

    private void sell() {
        if(turnStopLoss < next) {
            stopSell = true;
        }
        if(pointB < next) {
            pointB = next;
        }
        if((pointB - (pointB * (parallelPercentPair.getPercentSell() / 100)) > next && pointC < next)) {
            pointA = next;
            isSell = false;
            isBuy = true;
            balance = countOfCoin * next;
            workDone = true;
            date.setTime(time);
            tax = tax + balance * 0.00075;
            System.out.println("блок1");
            System.out.println("Продажа " + date + " цена " + next + " баланс " + balance);
            stopSell = false;
            block1++;
            return;
        }
        if(stopSell == true && stopLoss > next) {
            pointA = next;
            isSell = false;
            isBuy = true;
            balance = countOfCoin * next;
            workDone = true;
            date.setTime(time);
            tax = tax + balance * 0.00075;
            System.out.println("блок2");
            System.out.println("Продажа " + date + " цена " + next + " баланс " + balance);
            stopSell = false;
            block2++;
            return;
        }
        if(criticalStopLoss > next) {
            pointA = next;
            isSell = false;
            isBuy = true;
            balance = countOfCoin * next;
            workDone = true;
            date.setTime(time);
            tax = tax + balance * 0.00075;
            System.out.println("блок3");
            System.out.println("Продажа " + date + " цена " + next + " баланс " + balance);
            stopSell = false;
            block3++;
            return;
        }
    }

    public Algorithm(ParallelPercentPair parallelPercentPair) {
        this.parallelPercentPair = parallelPercentPair;
    }

    public void setNext(double next) {
        this.next = next;
    }

    public boolean isWorkDone() {
        return workDone;
    }

    public void prepareToStart() {
        pointA = next;
        first = false;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public void showStatisticBlock() {
        System.out.println("block1: " + block1 + " block2: " + block2 + " block3: " + block3);
        System.out.println("tax: " + tax);
    }

}
