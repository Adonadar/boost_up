package com.project.data;

public class Coin {

    private int id;

    private long openTime;

    private double openKline;

    private double hightPrice;

    private double lowPrice;

    private double closeKline;

    private double volume;

    private long closeTime;

    private double quoteAssetVolume;

    private int numberOfTrades;

    private double takerBuyBaseAssetVolume;

    private double takerBuyQuoteAssetVolume;

    private int ignoreCV = 0;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getOpenTime() {
        return openTime;
    }

    public void setOpenTime(long openTime) {
        this.openTime = openTime;
    }

    public double getOpenKline() {
        return openKline;
    }

    public void setOpenKline(double openKline) {
        this.openKline = openKline;
    }

    public double getHightPrice() {
        return hightPrice;
    }

    public void setHightPrice(double hightPrice) {
        this.hightPrice = hightPrice;
    }

    public double getLowPrice() {
        return lowPrice;
    }

    public void setLowPrice(double lowPrice) {
        this.lowPrice = lowPrice;
    }

    public double getCloseKline() {
        return closeKline;
    }

    public void setCloseKline(double closeKline) {
        this.closeKline = closeKline;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public long getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(long closeTime) {
        this.closeTime = closeTime;
    }

    public double getQuoteAssetVolume() {
        return quoteAssetVolume;
    }

    public void setQuoteAssetVolume(double quoteAssetVolume) {
        this.quoteAssetVolume = quoteAssetVolume;
    }

    public int getNumberOfTrades() {
        return numberOfTrades;
    }

    public void setNumberOfTrades(int numberOfTrades) {
        this.numberOfTrades = numberOfTrades;
    }

    public double getTakerBuyBaseAssetVolume() {
        return takerBuyBaseAssetVolume;
    }

    public void setTakerBuyBaseAssetVolume(double takerBuyBaseAssetVolume) {
        this.takerBuyBaseAssetVolume = takerBuyBaseAssetVolume;
    }

    public double getTakerBuyQuoteAssetVolume() {
        return takerBuyQuoteAssetVolume;
    }

    public void setTakerBuyQuoteAssetVolume(double takerBuyQuoteAssetVolume) {
        this.takerBuyQuoteAssetVolume = takerBuyQuoteAssetVolume;
    }

    public int getIgnoreCV() {
        return ignoreCV;
    }

    public void setIgnoreCV(int ignoreCV) {
        this.ignoreCV = ignoreCV;
    }

    public Coin() {
    }

    public Coin(int id, long openTime, double openKline, double hightPrice, double lowPrice,
                double closeKline, double volume, long closeTime, double quoteAssetVolume,
                int numberOfTrades, double takerBuyBaseAssetVolume, double takerBuyQuoteAssetVolume, int ignore) {
        this.id = id;
        this.openTime = openTime;
        this.openKline = openKline;
        this.hightPrice = hightPrice;
        this.lowPrice = lowPrice;
        this.closeKline = closeKline;
        this.volume = volume;
        this.closeTime = closeTime;
        this.quoteAssetVolume = quoteAssetVolume;
        this.numberOfTrades = numberOfTrades;
        this.takerBuyBaseAssetVolume = takerBuyBaseAssetVolume;
        this.takerBuyQuoteAssetVolume = takerBuyQuoteAssetVolume;
        this.ignoreCV = ignore;
    }

    @Override
    public String toString() {
        return "Coin{" +
                "id=" + id +
                ", openTime=" + openTime +
                ", openKline=" + openKline +
                ", hightPrice=" + hightPrice +
                ", lowPrice=" + lowPrice +
                ", closeKline=" + closeKline +
                ", volume=" + volume +
                ", closeTime=" + closeTime +
                ", quoteAssetVolume=" + quoteAssetVolume +
                ", numberOfTrades=" + numberOfTrades +
                ", takerBuyBaseAssetVolume=" + takerBuyBaseAssetVolume +
                ", takerBuyQuoteAssetVolume=" + takerBuyQuoteAssetVolume +
                ", ignore=" + ignoreCV +
                '}';
    }
}
