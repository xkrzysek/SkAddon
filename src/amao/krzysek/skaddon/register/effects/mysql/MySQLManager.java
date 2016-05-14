package amao.krzysek.skaddon.register.effects.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLManager {

    private Connection connection;
    private Statement statement;

    public MySQLManager() {}

    public MySQLManager(String host, String port, String database, String user, String password) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database + "?autoReconnect=true&user" + user + "&password=" + password);
        statement = connection.createStatement();
    }

    public void disconnection() throws SQLException {
        if(!(statement.isClosed()))
            statement.close();
        if(!(connection.isClosed()))
            connection.close();
    }

    public void sendQuery(String query) throws SQLException {
        statement.executeQuery(query);
    }

    public void sendUpdate(String update) throws SQLException {
        statement.executeUpdate(update);
    }

}
