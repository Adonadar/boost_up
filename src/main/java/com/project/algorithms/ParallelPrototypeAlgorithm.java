package com.project.algorithms;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope("prototype")
public class ParallelPrototypeAlgorithm implements Cloneable {
    private int count = 0;

    private double lastPrice;
    private double pointA;
    private double pointB;
    private double pointC;

    private ParallelPercentPair parallelPercentPair;

    private boolean isBuy = true;
    private boolean isSell = false;
    
    private int countOfOperation = 0;
    private double countOfCoin = 0;

    private double turnStopLoss;
    private double stopLoss;
    private double criticalStopLoss;
    private boolean stopSell = false;
    private boolean ready = false;

    private double balance = 10;

    private List<Double> list  = new ArrayList<>();
    private double midLine = 0;
    private double sum = 0;

    public void incrementCount() {
        count++;
    }

    public void incrementCountOfOperation() {
        countOfOperation++;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getLastPrice() {
        return lastPrice;
    }

    public void setLastPrice(double lastPrice) {
        this.lastPrice = lastPrice;
    }

    public double getPointA() {
        return pointA;
    }

    public void setPointA(double pointA) {
        this.pointA = pointA;
    }

    public double getPointB() {
        return pointB;
    }

    public void setPointB(double pointB) {
        this.pointB = pointB;
    }

    public double getPointC() {
        return pointC;
    }

    public void setPointC(double pointC) {
        this.pointC = pointC;
    }

    public boolean isBuy() {
        return isBuy;
    }

    public void setBuy(boolean buy) {
        isBuy = buy;
    }

    public boolean isSell() {
        return isSell;
    }

    public void setSell(boolean sell) {
        isSell = sell;
    }

    public int getCountOfOperation() {
        return countOfOperation;
    }

    public void setCountOfOperation(int countOfOperation) {
        this.countOfOperation = countOfOperation;
    }

    public double getCountOfCoin() {
        return countOfCoin;
    }

    public void setCountOfCoin(double countOfCoin) {
        this.countOfCoin = countOfCoin;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public ParallelPercentPair getParallelPercentPair() {
        return parallelPercentPair;
    }

    public void setParallelPercentPair(ParallelPercentPair parallelPercentPair) {
        this.parallelPercentPair = parallelPercentPair;
    }

    public double getTurnStopLoss() {
        return turnStopLoss;
    }

    public void setTurnStopLoss(double turnStopLoss) {
        this.turnStopLoss = turnStopLoss;
    }

    public double getStopLoss() {
        return stopLoss;
    }

    public void setStopLoss(double stopLoss) {
        this.stopLoss = stopLoss;
    }

    public double getCriticalStopLoss() {
        return criticalStopLoss;
    }

    public void setCriticalStopLoss(double criticalStopLoss) {
        this.criticalStopLoss = criticalStopLoss;
    }

    public boolean isStopSell() {
        return stopSell;
    }

    public void setStopSell(boolean stopSell) {
        this.stopSell = stopSell;
    }

    public boolean isReady() {
        return ready;
    }

    public void setReady(boolean ready) {
        this.ready = ready;
    }

    public List<Double> getList() {
        return list;
    }

    public void setList(List<Double> list) {
        this.list = list;
    }

    public double getMidLine() {
        return midLine;
    }

    public void setMidLine(double midLine) {
        this.midLine = midLine;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    @Override
    public String toString() {
        return "ParallelPrototypeAlgorithm{" +
                "count=" + count +
                ", lastPrice=" + lastPrice +
                ", pointA=" + pointA +
                ", pointB=" + pointB +
                ", pointC=" + pointC +
                ", parallelPercentPair=" + parallelPercentPair +
                ", isBuy=" + isBuy +
                ", isSell=" + isSell +
                ", countOfOperation=" + countOfOperation +
                ", countOfCoin=" + countOfCoin +
                ", balance=" + balance +
                '}';
    }

    public ParallelPrototypeAlgorithm clone() throws CloneNotSupportedException {
        return (ParallelPrototypeAlgorithm) super.clone();
    }
}
