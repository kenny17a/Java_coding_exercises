import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountTest {
    public Account account;
    @BeforeEach
    void setUp(){
        account = new Account("1","Femi Blaq","1234");
    }
    @Test
    void testThatAccountCanIncreaseAfterDeposit(){
        account.deposit("1",200);

        assertEquals(200,account.getBalance("1234"));
    }
    @Test
    void testThatAccountCanBeWithdrawFromWithValidPin(){
        account.deposit("1",4000);
        account.withdraw("1", "1234", 2500);
        assertEquals(1500, account.getBalance("1234"));
    }


}
