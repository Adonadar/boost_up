package com.project.data.download;

import com.project.data.Coin;
import com.project.constant.Constant;
import org.springframework.stereotype.Component;

@Component
public class SqlGenerator {

    public String getCreateDatabaseSql(String nameOfDatabase) {
        String sql = "CREATE SCHEMA `" + nameOfDatabase + "`;";

        return sql;
    }
    
    public String getCreateTableSql(String nameOfTable) {
        String sql = "CREATE TABLE `" +
                Constant.NAME_OF_DATABASE +
                "`.`" +
                nameOfTable +
                "`" +
                " (\n" +
                "  `id` BIGINT NOT NULL AUTO_INCREMENT,\n" +
                "  `openTime` BIGINT NULL,\n" +
                "  `openKline` DOUBLE NULL,\n" +
                "  `hightPrice` DOUBLE NULL,\n" +
                "  `lowPrice` DOUBLE NULL,\n" +
                "  `closeKline` DOUBLE NULL,\n" +
                "  `volume` DOUBLE NULL,\n" +
                "  `closeTime` BIGINT NULL,\n" +
                "  `quoteAssetVolume` DOUBLE NULL,\n" +
                "  `numberOfTrades` INT NULL,\n" +
                "  `takerBuyBaseAssetVolume` DOUBLE NULL,\n" +
                "  `takerBuyQuoteAssetVolume` DOUBLE NULL,\n" +
                "  `ignoreCV` INT NULL,\n" +
                "  PRIMARY KEY (`id`));";
        
        return sql;
    }
    
    public String getLoadDataSql(String nameOfFile, String pathToFile) {
        String sql = "LOAD DATA INFILE " +
                "\"" +
                pathToFile +
                "\"" +
                " INTO TABLE " +
                Constant.NAME_OF_DATABASE +
                "." +
                nameOfFile +
                " FIELDS TERMINATED BY ',' (openTime, openKline, hightPrice, \n" +
                "lowPrice, closeKline, volume, closeTime, quoteAssetVolume, numberOfTrades, \n" +
                "takerBuyBaseAssetVolume, takerBuyQuoteAssetVolume, ignoreCV);  ";

        return sql;
    }

    public String getIsTableExistSql(String nameOfTable) {
        String sql = "SELECT EXISTS (\n" +
                "    SELECT \n" +
                "        TABLE_NAME\n" +
                "    FROM \n" +
                "    information_schema.TABLES \n" +
                "    WHERE \n" +
                "    TABLE_SCHEMA LIKE '" +
                Constant.NAME_OF_DATABASE
                + "' AND \n" +
                "        TABLE_TYPE LIKE 'BASE TABLE' AND\n" +
                "        TABLE_NAME = '" +
                nameOfTable
                + "'\n" + "    );";

        return sql;
    }

    public String getIsDatabaseExistSql(String nameOfDatabase) {
        String sql = "SELECT EXISTS(\n" +
                "SELECT SCHEMA_NAME\n" +
                "  FROM INFORMATION_SCHEMA.SCHEMATA\n" +
                " WHERE SCHEMA_NAME = '" +
                nameOfDatabase +
                "');";

        return sql;
    }

    public String getDataTableSql(String nameOfTable) {
        String sql = "SELECT * FROM " +
                Constant.NAME_OF_DATABASE +
                "." +
                nameOfTable + ";";

        return sql;
    }

    public String getLastRowSql(String nameOfTable) {
        String sql = "SELECT * FROM " +
                Constant.NAME_OF_DATABASE +
                "." +
                nameOfTable + " ORDER BY id DESC LIMIT 1;";

        return sql;
    }

    public String getAddToTableSql(String nameOfTable, Coin coin) {
        String sql = "INSERT INTO "+nameOfTable+" (openTime, openKline, hightPrice, lowPrice, closeKline, volume, closeTime, quoteAssetVolume, numberOfTrades, takerBuyBaseAssetVolume, takerBuyQuoteAssetVolume, ignoreCV) " +
                     "VALUES ("   +coin.getOpenTime()+", " +
                                ""+coin.getOpenKline()+", " +
                                ""+coin.getHightPrice()+", " +
                                ""+coin.getLowPrice()+", " +
                                ""+coin.getCloseKline()+", " +
                                ""+coin.getVolume()+", " +
                                ""+coin.getCloseTime()+", " +
                                ""+coin.getQuoteAssetVolume()+", " +
                                ""+coin.getNumberOfTrades()+", " +
                                ""+coin.getTakerBuyBaseAssetVolume()+", " +
                                ""+coin.getTakerBuyQuoteAssetVolume()+", " +
                                ""+coin.getIgnoreCV()+");";

        return sql;
    }
}
