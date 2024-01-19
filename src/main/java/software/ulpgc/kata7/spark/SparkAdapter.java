package software.ulpgc.kata7.spark;

public interface SparkAdapter {
    String getExchangeRate(String fromCurrency, String toCurrency, double amount);
}
