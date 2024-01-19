package software.ulpgc.kata7.fixerws;


import software.ulpgc.kata7.Currency;
import software.ulpgc.kata7.CurrencyLoader;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        CurrencyLoader currencyLoader = new FixerCurrencyLoader();
        List<Currency> currencies = currencyLoader.load();
        for (Currency currency : currencies) {
            System.out.println(currency);
        }
    }
}
