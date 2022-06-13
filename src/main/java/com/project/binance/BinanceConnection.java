package com.project.binance;

import com.binance.api.client.BinanceApiClientFactory;
import com.binance.api.client.BinanceApiRestClient;
import org.springframework.stereotype.Component;

@Component
public class BinanceConnection {
    private String apiKey = "a7iv2AKpehqiuf7xDxMv1bHQlTx3nWzY82sHkQtRVfclyawJyHfP0OT0K5OYA66k";
    private String secret = "JTB6BKNobPQ5kIEOMkJiVjs0tmhGE1rTCTze0iOwVTkUKAuTkF7Qmt7zqt5wiE7o";

    public BinanceApiRestClient getConnection() {
        BinanceApiClientFactory factory = BinanceApiClientFactory.newInstance(apiKey, secret);
        BinanceApiRestClient binanceApiRestClient = factory.newRestClient();
        return binanceApiRestClient;
    }

    public String getApiKey() {
        return apiKey;
    }

    public String getSecret() {
        return secret;
    }
}
