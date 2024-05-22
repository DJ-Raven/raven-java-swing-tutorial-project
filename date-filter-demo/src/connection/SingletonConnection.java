package connection;

import java.sql.Connection;
import java.sql.SQLException;

public class SingletonConnection {

    private final String SERVER = "localhost:3305";
    private final String DB = "test_data";
    private final String USER = "raven";
    private final String PASS = "123";
    private static SingletonConnection instance = null;
    private Connection con;

    private SingletonConnection() {
    }

    public static SingletonConnection getInstance() {
        if (instance == null) {
            instance = new SingletonConnection();
        }
        return instance;
    }

    public void connectDatabase() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        con = java.sql.DriverManager.getConnection("jdbc:mysql://" + getSERVER() + "/" + getDB(), getUSER(), getPASS());
    }

    public void reconnect() throws Exception {
        con = java.sql.DriverManager.getConnection("jdbc:mysql://" + getSERVER() + "/" + getDB(), getUSER(), getPASS());
    }

    public Connection openConnection() {
        return con;
    }

    public void closeConnection() throws SQLException {
        if (con != null) {
            con.close();
        }
    }

    public String getSERVER() {
        return SERVER;
    }

    public String getDB() {
        return DB;
    }

    public String getUSER() {
        return USER;
    }

    public String getPASS() {
        return PASS;
    }
}
