package com.kubyshka.service;

import com.kubyshka.entity.Currency;
import com.kubyshka.entity.Saving;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;

public interface CurrenciesCourses {
    public List<String> convertListObjectToListString(List<Currency> allCurrencies);
    public HashMap<String, Float> getCoursesFromCBR(List<String> currencies) throws IOException,
            ParserConfigurationException, ParseException, SAXException;
    public List<Saving> getListSavingWithAllAmountInRUB(List<Saving> allSavings, HashMap<String, Float> currenciesAndCourses);
}
