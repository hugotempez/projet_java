package fr.itii25.db;

import java.sql.Connection;

public class DBMySQLConnexionFactory extends DBConnexionFactory{
    public DBMySQLConnexionFactory() {
        this.driver = "com.mysql.jdbc.Driver";
    }

    @Override
    public Connection createDBConnexion(String host, String port, String database, String user, String pass) {
        String url = "jdbc:mysql://" + host + ":" + port + "/" + database;
        return this.initConnexion(url, user, pass);
    }
}
