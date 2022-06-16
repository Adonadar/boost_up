package com.project.data.download;

import com.project.binance.BinanceApiGetter;
import com.project.data.connection.JdbcService;
import com.project.data.Coin;
import com.webcerebrium.binance.api.BinanceApi;
import com.webcerebrium.binance.api.BinanceApiException;
import com.webcerebrium.binance.datatype.BinanceCandlestick;
import com.webcerebrium.binance.datatype.BinanceInterval;
import com.webcerebrium.binance.datatype.BinanceSymbol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class UpdateData {
    private JdbcService jdbcService;

    private BinanceApi binanceApi;

    private ReformatKlineToCoin reformatFromKlineToCoin;

    private BinanceApiGetter binanceApiGetter;

    @Autowired
    public void setBinanceApiGetter(BinanceApiGetter binanceApiGetter) {
        this.binanceApiGetter = binanceApiGetter;
    }

    @Autowired
    public void setJdbcService(JdbcService jdbcService) {
        this.jdbcService = jdbcService;
    }

    @Autowired
    public void setReformatFromKlineToCoin(ReformatKlineToCoin reformatFromKlineToCoin) {
        this.reformatFromKlineToCoin = reformatFromKlineToCoin;
    }

    public void update(String pairOfAsset, String nameOfTable) {
        binanceApi = binanceApiGetter.getBinanceApi();
        Coin coin;
        BinanceSymbol symbol = null;
        boolean isNext = true;

        try {
            symbol = new BinanceSymbol(pairOfAsset);
        } catch (BinanceApiException e) {
            System.out.println("Ошибка при создании BinanceSymbol");
        }

        while (isNext) {
            coin = jdbcService.getLastRow(nameOfTable);
            Long startTime = coin.getOpenTime() + 60000;
            Long endTime = startTime + 48060000;

            long time = 0;

            try {
                time = binanceApi.time().get("serverTime").getAsLong();
            } catch (BinanceApiException e) {
                System.out.println("Ошибка при создании serverTime");
            }

            if(endTime > time) {
                endTime = time - (time % 60000);
                isNext = false;
            }

            Map<String, Long> option = new HashMap<>();
            option.put("startTime", startTime);
            option.put("endTime", endTime);

            Coin coinTransit;

            List<BinanceCandlestick> klines = null;

            try {
                klines = binanceApi.klines(symbol, BinanceInterval.ONE_MIN, 1000, option);
            } catch (BinanceApiException e) {
                System.out.println("Ошибка при извлечении данных klines");
            }

            for(int i = 0; i < klines.size(); i++) {
                coinTransit = reformatFromKlineToCoin.reform(klines.get(i));
                jdbcService.addToTable(nameOfTable, coinTransit);
            }

            System.out.println("Дозагружено строк: " + klines.size());
            System.out.println(time - endTime);
        }
    }
}
