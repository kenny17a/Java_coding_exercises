import java.util.Objects;

public class Account {
    private String accountNumber;
    private  String accountName;
    private  String pin;
    private int balance;

    public Account(String accountNumber, String accountName, String pin){
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.pin = pin;

    }

    public void deposit(String accountNumber, int amount){
        balance += amount;
    }

    public void withdraw(String accountNumber, String pin, int amount){
        if(pin != this.pin)throw new InvalidPinException("InvalidPin");
        else if(amount <= 0 ) throw new InvalidAmountException("Amount must be > 0 ");
        else {
            balance -= amount;
        }
    }

    public int getBalance(String pin){
        if(Objects.equals(pin, this.pin)) return balance;
        else throw new InvalidPinException("Invalid Pin!!!");
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountName() {
        return accountName;
    }
}
