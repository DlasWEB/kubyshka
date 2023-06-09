package com.kubyshka.controller;

import com.kubyshka.entity.Currency;
import com.kubyshka.entity.Saving;
import com.kubyshka.entity.User;
import com.kubyshka.repositories.CurrencyRepository;
import com.kubyshka.repositories.SavingsRepository;
import com.kubyshka.service.CurrenciesCourses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

@Controller
public class SavingRubController {
    @Autowired
    private CurrencyRepository currencyRepository;
    @Autowired
    private CurrenciesCourses currenciesCourses;
    @Autowired
    private SavingsRepository savingsRepository;

    @RequestMapping("/savings-rub")
    public String showAllSavingsRub(@AuthenticationPrincipal User user, Model model) throws ParserConfigurationException, SAXException, ParseException, IOException {
        List<Saving> allSavingsRUB = currenciesCourses.getListSavingWithAllAmountInRUB(
                (List<Saving>) savingsRepository.findByAuthorId(user.getId()),
                currenciesCourses.getCoursesFromCBR(
                        currenciesCourses.convertListObjectToListString((List<Currency>) currencyRepository.findAll())));
        model.addAttribute("allSavingsRUB", allSavingsRUB);
        return "all-savings-in-rub";
    }
}
