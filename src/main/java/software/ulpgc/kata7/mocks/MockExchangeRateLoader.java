package software.ulpgc.kata7.mocks;



import software.ulpgc.kata7.Currency;
import software.ulpgc.kata7.ExchangeRate;
import software.ulpgc.kata7.ExchangeRateLoader;

import java.time.LocalDate;

public class MockExchangeRateLoader implements ExchangeRateLoader {
    @Override
    public ExchangeRate load(Currency from, Currency to) {
        return new ExchangeRate(from, to, LocalDate.now(), 1.218);
    }
}
