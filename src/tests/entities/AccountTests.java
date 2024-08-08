package tests.entities;
import entities.Account;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tests.factory.AccountFactory;

public class AccountTests {

    @Test
    public void depositShouldIncreaseBalanceWhenPositiveAmount(){
        //Arrange -> prepared the data
        double amount = 200.0;
        double expectedValue = 196.0;
        Account acc = AccountFactory.createEmptyAccount();

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
        Account acc = AccountFactory.createAccount(expectedValue);

        //Act -> Necessary actions
        acc.deposit(amount);

        //Assert -> Expected value
        Assertions.assertEquals(expectedValue, acc.getBalance());
    }

    @Test
    public void fullWithdrawClearBalanceAndReturnFullBalance(){

        //Arrange -> prepared the data
        double expectedValue = 0.0;
        double initialBalance = 800.0;
        Account acc = AccountFactory.createAccount(initialBalance);

        //Act -> Necessary actions
        double result = acc.fullWithdraw();

        //Assert -> Expected value
        Assertions.assertEquals(expectedValue,acc.getBalance());
        Assertions.assertEquals(result,initialBalance);

    }

    @Test
    public void withdrawShouldDecreaseBalanceWhenSufficientBalance(){
        //Arrange -> prepared the data
        double amount = 200.0;
        double expectedValue = 600.0;
        double initialBalance = 800.0;
        Account acc = AccountFactory.createAccount(initialBalance);

        //Act -> Necessary actions
        acc.withdraw(amount);

        //Assert -> Expected value
        Assertions.assertEquals(expectedValue, acc.getBalance());
    }

    @Test
    public void withdrawShouldThrowExceptionWhenInsufficientBalance(){

        //Assert -> Expected value
        Assertions.assertThrows(IllegalArgumentException.class, ()->{
            //Arrange -> prepared the data
            double amount = 801.0;
            double initialBalance = 800.0;
            Account acc = AccountFactory.createAccount(initialBalance);

            //Act -> Necessary actions
            acc.withdraw(amount);
        });
    }


}
