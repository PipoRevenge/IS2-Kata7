package software.ulpgc.kata7.mocks;



import software.ulpgc.kata7.Currency;
import software.ulpgc.kata7.CurrencyDialog;

import java.util.List;

public class MockCurrencyDialog implements CurrencyDialog {
    private List<Currency> currencies;

    @Override
    public CurrencyDialog define(List<Currency> currencies) {
        this.currencies = currencies;
        return this;
    }

    @Override
    public Currency get() {
        return currencies.get(1);
    }
}
