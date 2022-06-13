package com.project.data.download;

import com.project.data.Coin;
import com.webcerebrium.binance.datatype.BinanceCandlestick;
import org.springframework.stereotype.Component;

@Component
public class ReformatKlineToCoin {
    public Coin reform(BinanceCandlestick kline) {
        Coin coin = new Coin(0, kline.openTime,
                kline.open.doubleValue(),
                kline.high.doubleValue(),
                kline.low.doubleValue(),
                kline.close.doubleValue(),
                kline.volume.doubleValue(),
                kline.closeTime,
                kline.quoteAssetVolume.doubleValue(),
                kline.numberOfTrades.intValue(),
                kline.takerBuyBaseAssetVolume.doubleValue(),
                kline.takerBuyQuoteAssetVolume.doubleValue(), 0);

        return coin;
    }
}
