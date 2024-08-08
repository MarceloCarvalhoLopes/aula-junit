package tests.entities;
import entities.Account;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AccountTests {

    @Test
    public void depositShouldIncreaseBalanceWhenPositiveAmount(){
        //Arrange -> prepared the data
        double amount = 200.0;
        double expectedValue = 196.0;
        Account acc = new Account(1L,0.0);

        //Act -> Necessary actions
        acc.deposit(amount);

        //Assert -> Expected value
        Assertions.assertEquals(expectedValue, acc.getBalance());
    }

    @Test
    public void depositShouldDoNothingWithNegativeAmount(){
        //Arrange -> prepared the data
        double amount = -200.0;
        double expectedValue = 200.0;
        Account acc = new Account(1L,expectedValue);

        //Act -> Necessary actions
        acc.deposit(amount);

        //Assert -> Expected value
        Assertions.assertEquals(expectedValue, acc.getBalance());
    }
}
