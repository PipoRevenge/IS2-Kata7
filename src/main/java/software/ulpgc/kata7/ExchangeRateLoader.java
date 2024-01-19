package software.ulpgc.kata7;



public interface ExchangeRateLoader {
    ExchangeRate load(Currency from, Currency to);
}
