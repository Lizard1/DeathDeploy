package parallel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RecieverAccounts implements Runnable{
    private Connector connector;
    private String query;
    private int count;

    public RecieverAccounts(int count){
        this.count = count;
    }


   synchronized public AccSimple findById(int id) {
        AccSimple account = new AccSimple();
        connector = new Connector();
        query = "SELECT * FROM account WHERE userid =" + id;

        try (Connection connection = connector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);) {

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                account.setId(resultSet.getInt(1));
                account.setAccountNumber(resultSet.getInt(2));
                account.setUserId(resultSet.getInt(3));
            }
        } catch (SQLException e) {
            System.out.println(e.getStackTrace());
        }
        return account;
    }

    @Override
    public void run() {
        AccSimple accSimple = findById(count);
        System.out.println(accSimple.getId()+" "+ accSimple.getUserId() +" " + accSimple.getAccountNumber());

    }
}
