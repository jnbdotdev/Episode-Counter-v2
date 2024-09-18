package com.jnb.db.connection;

import com.jnb.db.SQLQuery;
import com.jnb.models.Content;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DBConnection {
    private static final String driverUrl = "org.postgresql.Driver";
    private static final String hostUrl = "jdbc:postgresql://localhost:5432/episodecounter";
    private static final String user = "postgres";
    private static final String password = "root123";
    protected static SQLQuery sqlQuery = new SQLQuery();
    protected Statement statement;
    protected ResultSet resultSet;

    public Connection getConnection() {
        Connection connection;
        try {
            Class.forName(driverUrl);
            connection = DriverManager.getConnection(hostUrl, user, password);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return connection;
    }
    public void connect() {
        Connection connection = null;
        try {
            Class.forName(driverUrl);
            connection = DriverManager.getConnection(hostUrl, user, password);

            if (connection != null) {
                System.out.println("Connected.");
            } else {
                System.out.println("Connection failed.");
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public void createTable(Connection connection) {
        try {
            statement = connection.createStatement();
            statement.executeUpdate(sqlQuery.createTable());
            System.out.println("Table successfully created.");
        } catch (Exception e) {
            System.out.println("Exception caught: " + e);
        }
    }
    public void insertValue(Connection connection, String name, int group, int unit, String platform, int releaseDay, boolean releasing, int personalStatus, int category) {
        String sQuery = String.format(sqlQuery.insertValue(), name, group, unit, platform, releaseDay, releasing, personalStatus, category);

        try {
            statement = connection.createStatement();
            statement.executeUpdate(sQuery);
            System.out.println("Value inserted successfully.");
        } catch (Exception e) {
            System.out.println("Exception caught: " + e);
        }
    }
    public void updateValue(Connection connection, String name, int group, int unit, String platform, int releaseDay, boolean releasing, int personalStatus, int category, int cod){
        String sQuery = String.format(sqlQuery.updateValue(), name, group, unit, platform, releaseDay, releasing, personalStatus, category, cod+1);

        try {
            statement = connection.createStatement();
            statement.executeUpdate(sQuery);
            System.out.println("Value updated successfully.");
        } catch (Exception e) {
            System.out.println("Exception caught: " + e);
        }
    }
    public void deleteValue(Connection connection, int cod) {
        String sQuery = String.format(sqlQuery.deleteValue(), cod);

        try {
            statement = connection.createStatement();
            statement.executeUpdate(sQuery);
            System.out.println("Value deleted successfully.");
        } catch (Exception e) {
            System.out.println("Exception caught: " + e);
        }
    }
    public List<Content> readTable(Connection connection) {
        List<Content> catalog =new ArrayList<>();

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sqlQuery.readTable());

            while(resultSet.next()) {
                Content content = new Content();
                content.setCod(resultSet.getInt("cod"));
                content.setName(resultSet.getString("name"));
                content.setGroup(resultSet.getInt("content_group"));
                content.setUnit(resultSet.getInt("content_unit"));
                content.setPlatform(resultSet.getString("platform"));
                content.setReleaseDay(resultSet.getInt("releaseday"));
                content.setReleasing(resultSet.getBoolean("releasing"));
                content.setPersonalStatus(resultSet.getInt("personalstatus"));
                content.setCategory(resultSet.getInt("category"));
                catalog.add(content);
            }
        } catch (Exception e) {
            System.out.println("Exception caught: " + e);
        }

        return catalog;
    }
}
