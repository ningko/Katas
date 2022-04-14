import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AccountTest {

    private Account account;

    @BeforeEach
    void setUp() {
        account = new Account();
    }

    @Test
    void deposit500andWithdraw100ShouldPrintTheRightStatement() {
        account.deposit(500);
        account.withdraw(100);
        var actualStatement = account.printStatement();

        var expectedStatement =
                "Amount,Balance\n" +
                "+500,500\n" +
                "-100,400";

        Assertions.assertEquals(expectedStatement, actualStatement);
    }
}