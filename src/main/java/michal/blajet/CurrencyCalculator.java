package michal.blajet;

import java.util.Map;

public class CurrencyCalculator {
    private final Map<String, Double> currencies;

    public CurrencyCalculator(Map<String, Double> currencies) {
        this.currencies = currencies;
    }

    public double calculate(String currencyName, double value) {
        if (!currencies.containsKey(currencyName)) {
            throw new IllegalArgumentException("No such currency in base! Currency: " + currencyName);
        }

        double currencyValue = currencies.get(currencyName);
        return Math.floor(value * currencyValue * 100) / 100;
    }
}
