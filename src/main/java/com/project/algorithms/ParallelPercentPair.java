package com.project.algorithms;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@Scope("prototype")
public class ParallelPercentPair {
    private double percentBuy;
    private double percentSell;

    @Override
    public String toString() {
        return "CouplePercent{" +
                "a=" + percentBuy +
                ", b=" + percentSell +
                '}';
    }

    public ParallelPercentPair(double a, double b) {
        this.percentBuy = a;
        this.percentSell = b;
    }

    public double getPercentBuy() {
        return percentBuy;
    }

    public void setPercentBuy(int percentBuy) {
        this.percentBuy = percentBuy;
    }

    public double getPercentSell() {
        return percentSell;
    }

    public void setPercentSell(int percentSell) {
        this.percentSell = percentSell;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParallelPercentPair that = (ParallelPercentPair) o;
        return percentBuy == that.percentBuy && percentSell == that.percentSell;
    }

    @Override
    public int hashCode() {
        return Objects.hash(percentBuy, percentSell);
    }
}
