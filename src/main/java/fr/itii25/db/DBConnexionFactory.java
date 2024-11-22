package fr.itii25.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class DBConnexionFactory {
    protected String driver;

    public abstract Connection createDBConnexion(String host, String port, String database, String user, String password);

    protected Connection initConnexion(String url, String user, String pass) {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            System.out.println("Erreur driver MySqlConnexion");
            e.printStackTrace();
            System.exit(1);
        }

        Connection connexion = null;
        try{
            connexion = DriverManager.getConnection(url, user, pass);
        } catch (SQLException e) {
            System.out.println("Erreur connexion MySqlConnexion");
            e.printStackTrace();
            System.exit(-1);
        }
        return connexion;
    }
}
