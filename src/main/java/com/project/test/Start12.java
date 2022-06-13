package com.project.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.project.data.connection.JdbcService;
import com.project.data.Coin;
import com.project.spring.SpringConfig;

import java.util.List;

public class Start12 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        JdbcService jdbcService = context.getBean("jdbcService", JdbcService.class);
        List<Coin> coinList;

        coinList = jdbcService.getTable("bnbusdt_1m");

        double x = 40;
        double c = 0;
        boolean isC = true;

        double b = 0;

        double balance = 500;

        boolean sell = true;
        boolean buy = false;

        for(int i = 0; i < coinList.size(); i++) {
            if(sell) {
                if(isC) {
                    if(x + x / 10 < coinList.get(i).getOpenKline()) {
                        c = coinList.get(i).getOpenKline();
                        isC = false;
                    }
                }

                if(!isC) {
                    if(c < coinList.get(i).getOpenKline()) {
                        c = coinList.get(i).getOpenKline();
                    }
                    if(coinList.get(i).getOpenKline() < c - c / 20) {
                        System.out.println("sell " + coinList.get(i).getOpenKline());
                        b = coinList.get(i).getOpenKline();
                        balance = balance + coinList.get(i).getOpenKline();
                        sell = false;
                        buy = true;
                    }
                }
            }
            if(buy) {
                if(coinList.get(i).getOpenKline() < b) {
                    b = coinList.get(i).getOpenKline();
                }
                if(coinList.get(i).getOpenKline() > b + b / 20) {
                    System.out.println("buy " + coinList.get(i).getOpenKline());
                    balance = balance - coinList.get(i).getOpenKline();
                    x = coinList.get(i).getOpenKline();
                    sell = true;
                    isC = true;
                    buy = false;
                }
            }
        }
        System.out.println(balance);
    }
}
