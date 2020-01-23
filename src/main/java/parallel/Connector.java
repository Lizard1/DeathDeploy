package parallel;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {

    /**Строка подключения к БД, логин и пароль*/
    //private static final String URL = "jdbc:mysql://localhost:3306/thebankslist?autoReconnect=true&useSSL=false";
    //private static final String USERNAME = "root";
    //private static final String PASSWORD = "root";

    private final String URL = "jdbc:postgresql://ec2-54-247-92-167.eu-west-1.compute.amazonaws.com:5432/d958silr6v70vl";
    private final String USERNAME = "xufyajiujxtizo";
    private final String PASSWORD = "08cae26a2389aa0fb9cc5c6633fbf9fecae317c010128bcdc93a92aa94774303";

    private Connection connection;

    /**Конструктор.*/
    public Connector() {
        try {
            //Driver driver = new com.mysql.jdbc.Driver();
            Driver driver = new org.postgresql.Driver();
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
    public Connection getConnection() {
        return connection;
    }
}