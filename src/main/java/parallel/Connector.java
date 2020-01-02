package parallel;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {

    /**Строка подключения к БД, логин и пароль*/
    private static final String URL = "jdbc:mysql://localhost:3306/thebankslist?autoReconnect=true&useSSL=false";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    private Connection connection;

    /**Конструктор.*/
    public Connector() {
        try {
            Driver driver = new com.mysql.jdbc.Driver();
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            if (!connection.isClosed()) {
                System.out.println("Connection is established.");
            }
        } catch (SQLException e) {
            e.getStackTrace();
        }
    }

    /**Геттеры*/
    public static String getURL() {
        return URL;
    }

    public static String getUSERNAME() {
        return USERNAME;
    }

    public static String getPASSWORD() {
        return PASSWORD;
    }

    public Connection getConnection() {
        return connection;
    }
}