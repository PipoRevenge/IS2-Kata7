package software.ulpgc.kata7.mocks;

import software.ulpgc.kata7.*;

public class MockMoneyDisplay implements MoneyDisplay {
    @Override
    public void show(Money money) {
        System.out.println(money);
    }
}
