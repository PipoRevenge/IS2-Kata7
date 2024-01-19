package software.ulpgc.kata7;


public record Money(double amount, Currency currency) {
    @Override
    public String toString() {
        return amount + " " + currency;
    }
}
