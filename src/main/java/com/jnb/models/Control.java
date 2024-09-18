package com.jnb.models;

import java.sql.Connection;
import java.util.List;

public interface Control {

    public abstract Content newContent(String name, int group, int unit, String platform, int releaseDay, boolean releasing, int personalStatus, int category);

    public abstract void addContent(Connection connection, Content content);
    public abstract void updateContent(Connection connection, Content content);
    public abstract void deleteContent(Connection connection, int cod);
    public abstract List<Content> listCatalog(Connection connection);
}
