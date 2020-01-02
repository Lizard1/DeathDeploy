package parallel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        for (int i = 1; i < 10; i++){
            Thread t = new Thread(new RecieverAccounts(i));
            t.setName("Thread "+ i);
            t.start();
            t.join();
        }
    }
}

