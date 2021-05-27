package michal.blajet;

import michal.blajet.utils.CurrencyXMLParser;

import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Please, enter the name of xml file with currencies: ");
        Scanner scanner = new Scanner(System.in);
        String path = scanner.next();

        Map<String, Double> currencies = CurrencyXMLParser.loadCurrencies(path);
        CurrencyCalculator calculator = new CurrencyCalculator(currencies);

        boolean isRunning = true;
        System.out.println("In order to close app, type value smaller than 0");
        while (isRunning) {
            System.out.print("Enter value: ");
            double value = scanner.nextDouble();
            if (value < 0) {
                isRunning = false;
                continue;
            }

            System.out.print("Enter currency name: ");
            String command = scanner.next();
            try {
                double newValue = calculator.calculate(command, value);
                System.out.println(newValue);
            }
            catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
