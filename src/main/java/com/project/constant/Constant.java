package com.project.constant;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Constant {
    public static String NAME_OF_DATABASE = null;
    public static String URL_TO_BINANCE_DATA = null;
    public static String PATH_TO_DIRECTORY = null;
    public static int DATE_YEAR = 0;
    public static int DATE_MONTH = 0;

    public Constant(@Value("${create.database.name}") String nameOfDatabase,
                    @Value("${url.to.binance.database}") String urlToBinanceData,
                    @Value("${path.to.directory}") String pathToDirectory,
                    @Value("${date.year}") int dateYear,
                    @Value("${date.month}") int dateMonth) {
        NAME_OF_DATABASE = nameOfDatabase;
        URL_TO_BINANCE_DATA = urlToBinanceData;
        PATH_TO_DIRECTORY = pathToDirectory;
        DATE_YEAR = dateYear;
        DATE_MONTH = dateMonth;
    }
}
