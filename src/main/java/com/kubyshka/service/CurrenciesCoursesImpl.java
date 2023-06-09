package com.kubyshka.service;

import com.kubyshka.entity.Currency;
import com.kubyshka.entity.Saving;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.util.*;

@Service
public class CurrenciesCoursesImpl implements CurrenciesCourses {

    public List<String> convertListObjectToListString(List<Currency> allCurrencies) {
        List<String> allCurrenciesString = new ArrayList<>(allCurrencies.size());
        for (Currency currency : allCurrencies) {
            allCurrenciesString.add(currency != null ? currency.toString() : null);
        }
        return allCurrenciesString;
    }

    @Override
    public HashMap<String, Float> getCoursesFromCBR(List<String> currensies) throws IOException,
            ParserConfigurationException, ParseException, SAXException {
        HashMap<String, Float> coursesOfCurrencies = new HashMap<String, Float>();
        String url = "https://www.cbr.ru/scripts/XML_daily.asp";
        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        connection.setRequestMethod("GET");
        connection.addRequestProperty("User-Agent",
                "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.0)");
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder()
                .parse(new ByteArrayInputStream(response.toString().getBytes()));
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setDecimalSeparator(',');
        DecimalFormat decimalFormat = new DecimalFormat("#.####");
        decimalFormat.setDecimalFormatSymbols(symbols);
        for (String currency : currensies) {
            if (!currency.equals("RUB")) {
                NodeList nodeList = ((org.w3c.dom.Document) doc).getDocumentElement()
                        .getElementsByTagName("Valute");
                for (int i = 0; i < nodeList.getLength(); i++) {
                    Node node = nodeList.item(i);
                    if (node.getChildNodes().item(1).getTextContent().equals(currency)) {
                        Float course = decimalFormat.parse(node.getLastChild().getTextContent()).floatValue();
                        Float nominal = decimalFormat.parse(node.getLastChild().getPreviousSibling().getPreviousSibling().
                                getTextContent()).floatValue();
                        coursesOfCurrencies.put(currency, course / nominal);
                    }
                }
            } else {
                coursesOfCurrencies.put(currency, 1f);
            }
        }
        return coursesOfCurrencies;
    }

    @Override
    public List<Saving> getListSavingWithAllAmountInRUB(List<Saving> allSavings, HashMap<String, Float> currenciesAndCourses) {
        for (Saving saving : allSavings) {
            String currency = saving.getCurrency_name();
            Float amount = (float) saving.getAmount();
            Iterator<Map.Entry<String, Float>> new_Iterator
                    = currenciesAndCourses.entrySet().iterator();
            while (new_Iterator.hasNext()) {
                Map.Entry<String, Float> new_Map
                        = (Map.Entry<String, Float>)
                        new_Iterator.next();
                if (new_Map.getKey().equals(currency)) {
                    int newAmount = (int) (amount * new_Map.getValue());
                    saving.setAmount(newAmount);
                }

            }
        }
        return allSavings;
    }
}
