package com.project.test;

import com.binance.api.client.BinanceApiClientFactory;
import com.binance.api.client.BinanceApiRestClient;
import com.webcerebrium.binance.api.BinanceApi;
import com.webcerebrium.binance.api.BinanceApiException;
import com.webcerebrium.binance.datatype.BinanceCandlestick;
import com.webcerebrium.binance.datatype.BinanceInterval;
import com.webcerebrium.binance.datatype.BinanceSymbol;


import java.util.*;

public class Start15 {
    public static void main(String[] args) throws InterruptedException, BinanceApiException {
        BinanceApiClientFactory factory = BinanceApiClientFactory.newInstance(
                "a7iv2AKpehqiuf7xDxMv1bHQlTx3nWzY82sHkQtRVfclyawJyHfP0OT0K5OYA66k",
                "JTB6BKNobPQ5kIEOMkJiVjs0tmhGE1rTCTze0iOwVTkUKAuTkF7Qmt7zqt5wiE7o");
        BinanceApiRestClient client = factory.newRestClient();

        BinanceSymbol symbol = new BinanceSymbol("BTCUSDT");

        Map<String, Long> map = new HashMap<>();
        map.put("startTime", 1654120000000l);
        map.put("endTime", 1654125000000l);

        List<BinanceCandlestick> klines = (new BinanceApi("", "")).klines(symbol, BinanceInterval.ONE_MIN, 5000, map);
        BinanceCandlestick binanceCandlestick = klines.get(0);
        System.out.println(klines.size());
    }
}
