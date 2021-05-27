package utils;

import michal.blajet.utils.CurrencyXMLParser;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

public class CurrencyXMLParserTest {

    @Test
    public void load_no_existing_file() {
        assertThrows(IllegalArgumentException.class, () -> {
            CurrencyXMLParser.loadCurrencies("no_existing_file.xyz");
        });
    }

    @Test
    public void load_bad_scheme_file() {
        String badFilePath = "src/test/resources/bad_scheme_file.xml";
        assertThrows(IllegalArgumentException.class, () -> {
            CurrencyXMLParser.loadCurrencies(badFilePath);
        });
    }

    @Test
    public void load_valid_file() {
        String goodFilePath = "src/test/resources/good_scheme_file.xml";
        Map<String, Double> currencies = CurrencyXMLParser.loadCurrencies(goodFilePath);

        assertTrue(currencies.containsKey("USD") && currencies.get("USD") == 1.2229);
    }
}
