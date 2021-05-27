package michal.blajet.utils;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.input.sax.XMLReaderJDOMFactory;
import org.jdom2.input.sax.XMLReaderXSDFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CurrencyXMLParser {

    public static Map<String, Double> loadCurrencies(String path) {
        HashMap<String, Double> currencies = new HashMap<>();
        File inputFile = new File(path);

        File xsdfile = new File("src/main/resources/envelop.xsd");

        try {
            XMLReaderJDOMFactory schemafac = new XMLReaderXSDFactory(xsdfile);
            SAXBuilder builder = new SAXBuilder(schemafac);
            Document document = builder.build(inputFile);

            Element root = document.getRootElement();
            List<Element> children = root.getChildren();

            Element mainCube = children.get(children.size()-1);
            List<Element> cubeChildren = mainCube.getChildren();

            Element secondDimension = cubeChildren.get(0);
            List<Element> currencyList = secondDimension.getChildren();

            for(Element element : currencyList) {
                Attribute nameAttr = element.getAttribute("currency");
                Attribute rateAttr = element.getAttribute("rate");

                if (nameAttr == null || rateAttr == null) {
                    throw new IllegalArgumentException("Ill formed xml. There is no needed attributes.");
                }

                String name = nameAttr.getValue();
                String strValue = rateAttr.getValue();

                double value = Double.parseDouble(strValue);
                currencies.put(name, value);
            }

        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException("No such given file (file: " + path + ")");
        } catch (JDOMException e) {
            throw new IllegalArgumentException("Given file is not valid.");
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return currencies;
    }
}
