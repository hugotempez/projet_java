package fr.itii25.db;

import java.sql.Connection;

public class DBPostgresSQLConnexionFactory extends DBConnexionFactory{
    public DBPostgresSQLConnexionFactory() {
        this.driver = "org.postgresql.Driver";
    }

    @Override
    public Connection createDBConnexion(String host, String port, String database, String user, String pass) {
        String url = "jdbc:postgres://" + host + ":" + port + "/" + database;
        return this.initConnexion(url, user, pass);
    }
}
