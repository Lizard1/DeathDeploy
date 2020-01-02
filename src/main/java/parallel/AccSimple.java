package parallel;
import java.util.Objects;

public class AccSimple {

    private int id;
    private int accountNumber;
    private int userId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }


    public AccSimple() {
    }

    public AccSimple(int id, int accountNumber, int userId) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccSimple account = (AccSimple) o;
        return id == account.id &&
                accountNumber == account.accountNumber &&
                userId == account.userId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, accountNumber, userId);
    }

}
