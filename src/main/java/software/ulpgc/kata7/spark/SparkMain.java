package software.ulpgc.kata7.spark;

import software.ulpgc.kata7.Currency;
import software.ulpgc.kata7.fixerws.FixerCurrencyLoader;
import spark.Spark;

import java.util.List;

public class SparkMain {
    public static void main(String[] args) {
        Spark.port(8080);
        SparkAdapter adapter =  new FixerSparkAdapter();
        Spark.get("/",(req, res) -> {
            FixerCurrencyLoader currencyLoader = new FixerCurrencyLoader();
            List<Currency> currencies = currencyLoader.load();
            currencies.add(new Currency("EUR","Euro"));
            StringBuilder currencyOptions =  new StringBuilder();
            for(Currency currency : currencies){
                currencyOptions.append("<option value=\"")
                        .append(currency.code())
                        .append("\">")
                        .append(currency.code())
                        .append(" - ")
                        .append(currency.name())
                        .append("</option>");
            }
            return "<html>" +
                    "<head><title>Money Exchange Calculator</title></head>" +
                    " <body>" +
                    " <h1>Money Exchange Calculator</h1>" +
                    " <form action=\"/calculate\" method=\"post\">"+
                    " From Currency: <select name=\"fromCurrency\">"+
                    currencyOptions.toString() +
                    " </select><br>" +
                    " To Currency: <select name=\"toCurrency\">" +
                    currencyOptions.toString() +
                    " </select><br>" +
                    " Amount: <input type=\"number\" name=\"amount\" step=\"0,01\"><br>"+
                    "<input type=\"submit\" value=\"Calculate\">"+
                    " </form>"+
                    " </body>"+
                    "</html>";
        });

        Spark.post("/calculate",(req,res) -> {
            String fromCurrency = req.queryParams("fromCurrency");
            String toCurrency = req.queryParams("toCurrency");
            double amount = Double.parseDouble(req.queryParams("amount"));

            String result = adapter.getExchangeRate(fromCurrency,toCurrency,amount);
            return "<html><body><h1>Exchange Rate</h1><p>"+ result + "</p></body></html>";
        });

    }
}
