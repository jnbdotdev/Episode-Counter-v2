package com.jnb;

import com.jnb.db.connection.DBConnection;
import com.jnb.models.Content;
import com.jnb.models.UserInterface;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserInterface userInterface = new UserInterface();

        DBConnection dbConnection = new DBConnection();
        dbConnection.connect();
        dbConnection.createTable(dbConnection.getConnection());

        List<Content> catalog = userInterface.listCatalog(dbConnection.getConnection());
        System.out.println(catalog);

    }
}