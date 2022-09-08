import java.util.Objects;

public class Bank {

    int count = 0;
    Account [] accounts = new Account[10];


    public void createAccount(String accountName, String pin){
        Account account = new Account((count + 1)+ "",accountName,pin);
        accounts[count] = account;
        count++;
    }
    public Account findAccount(String accountNumber){
        for(Account account: accounts){
            if (Objects.equals(accountNumber, account.getAccountNumber()))
             return account;
        }
        throw new NullPointerException("Account Not Found");
    }
    public int checkBalance(String accountNumber, String pin){
        Account account = findAccount(accountNumber);
        return account.getBalance(pin);
    }
    public void deposit(String accountNumber, int amount){
        Account account = findAccount(accountNumber);
        account.deposit(accountNumber, amount);

    }
    public void withdraw(String accountNumber, String pin, int amount){
        Account account = findAccount(accountNumber);
        account.withdraw(accountNumber, pin, amount);
    }
    public void transfer(String senderAccount, String receiverAccount, String pin, int amount){
        Account account1 = findAccount(senderAccount);
        Account account2 = findAccount(receiverAccount);
        account1.withdraw(senderAccount, pin, amount);
        account2.deposit(receiverAccount, amount);
    }
}

