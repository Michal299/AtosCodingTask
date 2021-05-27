import michal.blajet.CurrencyCalculator;
import org.junit.Test;
import static org.junit.Assert.*;


import java.util.HashMap;
import java.util.Map;

public class CurrencyCalculatorTest {

    @Test
    public void calculating_existing_currency() {
        Map<String, Double> currencies = new HashMap<String, Double>();
        currencies.put("PLN", 4.5);

        CurrencyCalculator calculator = new CurrencyCalculator(currencies);

        double value = calculator.calculate("PLN", 10);

        assertTrue(value == 45);
    }

    @Test
    public void calculating_no_existing_currency() {
        Map<String, Double> currencies = new HashMap<String, Double>();
        CurrencyCalculator calculator = new CurrencyCalculator(currencies);
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculate("PLN", 10);
        });
    }
}
