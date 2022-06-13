package com.project.binance;

import com.webcerebrium.binance.api.BinanceApi;
import com.webcerebrium.binance.api.BinanceApiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BinanceApiGetter {
    private BinanceApi binanceApi;

    private BinanceConnection binanceConnection;

    @Autowired
    public void setBinanceConnection(BinanceConnection binanceConnection) {
        this.binanceConnection = binanceConnection;
    }

    public BinanceApi getBinanceApi() {

        try {
            binanceApi = new BinanceApi(binanceConnection.getApiKey(), binanceConnection.getSecret());
        } catch (BinanceApiException e) {
            throw new RuntimeException(e);
        }

        return binanceApi;
    }
}
