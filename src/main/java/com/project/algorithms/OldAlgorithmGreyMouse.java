package com.project.algorithms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import com.project.data.connection.JdbcService;
import com.project.data.Coin;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
@Scope("prototype")
public class OldAlgorithmGreyMouse {
    private JdbcService jdbcService;

    private List<Coin> coinList = new ArrayList<>();

    @Autowired
    public void setJdbcService(JdbcService jdbcService) {
        this.jdbcService = jdbcService;
    }

    private volatile int id = 0;
    private double next = 0;
    private double pointA;
    private double pointB;
    private double pointC;

    private double percentBuy = 19;
    private double percentSell = 9;

    private boolean isBuy = true;
    private boolean isSell = false;
    private boolean first = true;

    private boolean lastIsBuy = false;
    private int count = 0;
    private double countOfCoin = 0;

    private double balance = 40;

    private Date date = new Date();

    public OldAlgorithmGreyMouse(double percentBuy, double percentSell) {
        this.percentBuy = percentBuy;
        this.percentSell = percentSell;
    }

    public void showBalance() {
        System.out.println(balance + " последняя покупка? " + lastIsBuy + " колличество сделок " + count);
    }

    public void analysis() {
        if(first) {
            prepareToStart();
        }

        if(isBuy) {
            buy();
        }
        if(isSell) {
            sell();
        }
    }

    private void buy() {
        for(int i = id; i < coinList.size(); i++) {
            next = coinList.get(i).getOpenKline();

            if(i == coinList.size()-1) {
                isBuy = false;
            }

            if(pointA > next) {
                pointA = next;
            }

            if(pointA + (pointA * (percentBuy / 100)) < next) {
                pointB = next;
                pointC = next;
                countOfCoin = balance / next;
                balance = 0;
                id = i;
                isBuy = false;
                isSell = true;
                lastIsBuy = true;
                count++;
                date.setTime(coinList.get(i).getOpenTime());
                System.out.println("Покупка " + date + " цена " + next + " колличество коинов " + countOfCoin);
                break;
            }

            if(isBuy) {
                continue;
            }
        }
        analysis();
    }

    private void sell() {
        for (int i = id; i < coinList.size(); i++) {
            next = coinList.get(i).getOpenKline();

            if(i == coinList.size()-1) {
                isSell = false;
            }

            if(pointB < next) {
                pointB = next;
            }

            if(pointB - (pointB * (percentSell / 100)) > next && pointC < next) {
                pointA = next;
                id = i;
                isSell = false;
                isBuy = true;
                lastIsBuy = false;
                count++;
                balance = countOfCoin * next;
                date.setTime(coinList.get(i).getOpenTime());
                System.out.println("Продажа " + date + " цена " + next + " колличество коинов " + countOfCoin);
                System.out.println(balance);
                break;
            }

            if(isSell) {
                continue;
            }
        }
        analysis();
    }

    public void prepareToStart() {
        coinList = jdbcService.getTable("bnbusdt_1m");
        pointA = coinList.get(0).getOpenKline();
        first = false;
    }

    public JdbcService getJdbcService() {
        return jdbcService;
    }

    public List<Coin> getCoinList() {
        return coinList;
    }

    public void setCoinList(List<Coin> coinList) {
        this.coinList = coinList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getNext() {
        return next;
    }

    public void setNext(double next) {
        this.next = next;
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

    public double getPercentBuy() {
        return percentBuy;
    }

    public void setPercentBuy(double percentBuy) {
        this.percentBuy = percentBuy;
    }

    public double getPercentSell() {
        return percentSell;
    }

    public void setPercentSell(double percentSell) {
        this.percentSell = percentSell;
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

    public boolean isFirst() {
        return first;
    }

    public void setFirst(boolean first) {
        this.first = first;
    }

    public boolean isLastIsBuy() {
        return lastIsBuy;
    }

    public void setLastIsBuy(boolean lastIsBuy) {
        this.lastIsBuy = lastIsBuy;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
