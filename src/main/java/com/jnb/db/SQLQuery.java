package com.jnb.db;

public class SQLQuery {
    private static final String tableName = "content_data";

    private String createTable = "CREATE TABLE IF NOT EXISTS " + tableName + " (cod SERIAL PRIMARY KEY, name TEXT NOT NULL, content_group INT NOT NULL, content_unit INT NOT NULL, platform TEXT, releaseDay INT, releasing BOOLEAN, personalStatus INT NOT NULL, category INT NOT NULL);";
    private String readTable = "SELECT * FROM " + tableName + ";";
    private String insertValue = "INSERT INTO " + tableName + " (name, content_group, content_unit, platform, releaseDay, releasing, personalStatus, category) VALUES ('%s', %d, %d, '%s', %d, %b, %d, %d);";
    private String updateValue = "UPDATE " + tableName + " SET name='%s', content_group=%d, content_unit=%d, platform='%s', releaseDay=%d, releasing=%b, personalStatus=%d, category=%d WHERE cod=%d";
    private String deleteValue = "DELETE FROM " + tableName + " WHERE cod = %d;";

    public SQLQuery() {
        this.setCreateTable(createTable);
        this.setInsertValue(insertValue);
        this.setUpdateValue(updateValue);
        this.setDeleteValue(deleteValue);
        this.setReadTable(readTable);
    }

    public String createTable() {
        return createTable;
    }
    public String insertValue() {
        return insertValue;
    }
    public String updateValue() {
        return updateValue;
    }
    public String deleteValue() {
        return deleteValue;
    }
    public String readTable() {
        return readTable;
    }

    public void setCreateTable(String createTable) {
        this.createTable = createTable;
    }
    public void setInsertValue(String insertValue) {
        this.insertValue = insertValue;
    }
    public void setUpdateValue(String updateValue) {
        this.updateValue = updateValue;
    }
    public void setDeleteValue(String deleteValue) {
        this.deleteValue = deleteValue;
    }
    public void setReadTable(String readTable) {
        this.readTable = readTable;
    }
}
