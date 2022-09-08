import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BankTest {
    Bank bank;
    @BeforeEach
    void setUp(){
        bank = new Bank();
    }
    @Test
    void testThatAccountExist(){
        bank.createAccount("Tracy","1234");
        assertEquals("Tracy",bank.findAccount("1").getAccountName());
    }
    @Test
    void testThatMultiplyAccountCanBeCreated(){
        bank.createAccount("Brian","1234");
        bank.createAccount("Ashley","1921");
        bank.createAccount("Fedrick","5324");

        assertEquals("Ashley", bank.findAccount("2").getAccountName());
        assertEquals("Fedrick", bank.findAccount("3").getAccountName());
    }
    @Test
    void testForBalanceInAccount(){
        bank.createAccount("phil","5671");
        assertEquals(0, bank.checkBalance("1", "5671"));
    }
    @Test
    void testThatBankAccountCanHoldDepositAmount(){
        bank.createAccount("leo","7777");
        assertEquals(0, bank.checkBalance("1","7777"));
        bank.deposit("1",3000);
        assertEquals(3000, bank.checkBalance("1","7777"));

    }
    @Test
    void testThatBankAccountCanBeWithdrawFrom(){
        bank.createAccount("Kieran","9999");
        bank.deposit("1",5000);
        assertEquals(5000, bank.checkBalance("1","9999"));
        bank.withdraw("1", "9999",3000);
        assertEquals(2000, bank.checkBalance("1","9999"));

    }
    @Test
    void testThatAccountCanBeTransferFromFirstAccountToAnotherAccount(){
        bank.createAccount("Joyce","2345");
        bank.createAccount("Hannah", "1111");
        assertEquals("Joyce", bank.findAccount("1").getAccountName());
        assertEquals("Hannah", bank.findAccount("2").getAccountName());

        bank.deposit("1",5000);
        assertEquals(5000, bank.checkBalance("1","2345"));

        bank.transfer("1","2","2345",3000);
        assertEquals(2000, bank.checkBalance("1","2345"));
        assertEquals(3000, bank.checkBalance("2","1111"));

    }
    @Test
    void testThatAccountDoesNotExist(){
        bank.createAccount("Raphl","2222");
        //assertEquals("Raphl", bank.findAccount("2").getAccountNumber());
        assertThrows(NullPointerException.class, ()->bank.findAccount("2"));
    }
    @Test
    void testThatWrongPinWillThrowIllegalException(){
        bank.createAccount("Justin","1010");
        assertThrows(InvalidPinException.class, ()->bank.checkBalance("1","1111"));
    }
    @Test
    void testThatWrongPinThrowsError(){
        bank.createAccount("Marvins","1111");
        bank.withdraw("1","2222",3000);
        assertThrows(InvalidPinException.class, ()->bank.withdraw("1","2001",1500));
    }
    @Test
    void testThatNegativeAmountCannotBrWithdraw(){
        bank.createAccount("Harvey","5555");
        bank.withdraw("1","5555",-5000);
        assertThrows(InvalidAmountException.class, ()->bank.withdraw("1","5555",-5000));
    }


}
