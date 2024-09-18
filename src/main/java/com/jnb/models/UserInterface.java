package com.jnb.models;

import com.jnb.db.connection.DBConnection;

import java.sql.Connection;
import java.util.Calendar;
import java.util.List;

public class UserInterface implements Control {
    DBConnection dbConnection = new DBConnection();

    @Override
    public Content newContent(String name, int group, int unit, String platform, int releaseDay, boolean releasing, int personalStatus, int category) {
        Calendar weekDay = Calendar.getInstance();
        weekDay.set(Calendar.DAY_OF_WEEK, releaseDay);

        Content content;
        content = new Content(name, group, unit, platform, weekDay , releasing, personalStatus, category);

        return content;
    }

    @Override
    public void addContent(Connection connection, Content content) {
        dbConnection.insertValue(dbConnection.getConnection(), content.getName(), content.group, content.unit, content.platform, content.getReleaseDay().get(Calendar.DAY_OF_WEEK), content.isReleasing(), content.getPersonalStatus(), content.getCategory());
    }

    @Override
    public void updateContent(Connection connection, Content content) {
        dbConnection.updateValue(dbConnection.getConnection(), content.getName(), content.group, content.unit, content.platform, content.getReleaseDay().get(Calendar.DAY_OF_WEEK), content.isReleasing(), content.getPersonalStatus(), content.getCategory(), content.getCod());
    }

    @Override
    public void deleteContent(Connection connection, int cod) {
        dbConnection.deleteValue(dbConnection.getConnection(), cod);
    }

    @Override
    public List<Content> listCatalog(Connection connection) {
        List<Content> catalog;
        catalog = dbConnection.readTable(dbConnection.getConnection());
        return catalog;
    }
}
