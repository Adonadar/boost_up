package com.project.data.connection;

import com.project.data.download.SqlGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.project.data.Coin;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcService {
    private JdbcConnection jdbcConnection;

    private SqlGenerator sqlGenerator;

    private ResultSet resultSet;

    private Connection connection;

    private Statement statement;

    @Autowired
    public void setJdbcConnection(JdbcConnection jdbcConnection) {
        this.jdbcConnection = jdbcConnection;
    }

    @Autowired
    public void setSqlGenerator(SqlGenerator sqlGenerator) {
        this.sqlGenerator = sqlGenerator;
    }

    public boolean isTableExist(String nameOfTable) {
        String sql = sqlGenerator.getIsTableExistSql(nameOfTable);
        List<String> stringList = new ArrayList<>();
        int result;

        try {
            connection = jdbcConnection.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            int id = resultSet.getMetaData().getColumnCount();

            while(resultSet.next()) {
                for(int i = 1; i <= id; i++) {
                    stringList.add(String.valueOf(resultSet.getString(i)));
                }
            }

            result = Integer.valueOf(stringList.get(0));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                statement.close();
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        if(result == 1) {
            return true;
        }
        return false;
    }

    public boolean isDatabaseExist(String nameOfDatabase) {
        String sql = sqlGenerator.getIsDatabaseExistSql(nameOfDatabase);
        List<String> stringList = new ArrayList<>();
        int result;

        try {
            connection = jdbcConnection.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            int id = resultSet.getMetaData().getColumnCount();

            while(resultSet.next()) {
                for(int i = 1; i <= id; i++) {
                    stringList.add(String.valueOf(resultSet.getString(i)));
                }
            }

            result = Integer.valueOf(stringList.get(0));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                statement.close();
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        if(result == 1) {
            return true;
        }
        return false;
    }

    public List<Coin> getTable(String nameOfTable) {
        String sql = sqlGenerator.getDataTableSql(nameOfTable);
        Coin coin;
        List<Coin> table = new ArrayList<>();

        try {
            connection = jdbcConnection.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            while(resultSet.next()) {
                coin = new Coin(Integer.parseInt(resultSet.getString("id")),
                    Long.parseLong(resultSet.getString("openTime")),
                    Double.parseDouble(resultSet.getString("openKline")),
                    Double.parseDouble(resultSet.getString("hightPrice")),
                    Double.parseDouble(resultSet.getString("lowPrice")),
                    Double.parseDouble(resultSet.getString("closeKline")),
                    Double.parseDouble(resultSet.getString("volume")),
                    Long.parseLong(resultSet.getString("closeTime")),
                    Double.parseDouble(resultSet.getString("quoteAssetVolume")),
                    Integer.parseInt(resultSet.getString("numberOfTrades")),
                    Double.parseDouble(resultSet.getString("takerBuyBaseAssetVolume")),
                    Double.parseDouble(resultSet.getString("takerBuyQuoteAssetVolume")),
                    Integer.parseInt(resultSet.getString("ignoreCV")));
                table.add(coin);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                statement.close();
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        return table;
    }

    public void createTable(String nameOfTable) {
        String sql = sqlGenerator.getCreateTableSql(nameOfTable);

        try {
            connection = jdbcConnection.getConnection();
            statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                statement.close();
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void loadData(String nameOfFile, String pathToFile) {
        String sql = sqlGenerator.getLoadDataSql(nameOfFile, pathToFile);

        try {
            connection = jdbcConnection.getConnection();
            statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                statement.close();
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void createDatabase(String nameOfDatabase) {
        String sql = sqlGenerator.getCreateDatabaseSql(nameOfDatabase);

        try {
            connection = jdbcConnection.getConnection();
            statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                statement.close();
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public Coin getLastRow(String nameOfTable) {
        String sql = sqlGenerator.getLastRowSql(nameOfTable);
        Coin coin = null;

        try {
            connection = jdbcConnection.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            while(resultSet.next()) {
                coin = new Coin(Integer.parseInt(resultSet.getString("id")),
                        Long.parseLong(resultSet.getString("openTime")),
                        Double.parseDouble(resultSet.getString("openKline")),
                        Double.parseDouble(resultSet.getString("hightPrice")),
                        Double.parseDouble(resultSet.getString("lowPrice")),
                        Double.parseDouble(resultSet.getString("closeKline")),
                        Double.parseDouble(resultSet.getString("volume")),
                        Long.parseLong(resultSet.getString("closeTime")),
                        Double.parseDouble(resultSet.getString("quoteAssetVolume")),
                        Integer.parseInt(resultSet.getString("numberOfTrades")),
                        Double.parseDouble(resultSet.getString("takerBuyBaseAssetVolume")),
                        Double.parseDouble(resultSet.getString("takerBuyQuoteAssetVolume")),
                        Integer.parseInt(resultSet.getString("ignoreCV")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                statement.close();
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        return coin;
    }

    public void addToTable(String nameOfTable, Coin coin) {
        String sql = sqlGenerator.getAddToTableSql(nameOfTable, coin);

        try {
            connection = jdbcConnection.getConnection();
            statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                statement.close();
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
