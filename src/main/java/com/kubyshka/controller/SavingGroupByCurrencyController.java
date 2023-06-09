package com.kubyshka.controller;

import com.kubyshka.entity.Currency;
import com.kubyshka.entity.Saving;
import com.kubyshka.entity.SavingGroupByCurrencyContainer;
import com.kubyshka.entity.User;
import com.kubyshka.repositories.CurrencyRepository;
import com.kubyshka.repositories.SavingsRepository;
import com.kubyshka.service.CurrenciesCourses;
import com.kubyshka.service.SavingGroupByCurrency;
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
import java.util.Set;

@Controller
public class SavingGroupByCurrencyController {
    @Autowired
    private CurrencyRepository currencyRepository;
    @Autowired
    private CurrenciesCourses currenciesCourses;
    @Autowired
    private SavingsRepository savingsRepository;
    @Autowired
    private SavingGroupByCurrency savingGroupByCurrency;

    @RequestMapping("/savings-group-by-currency")
    public String showAllSavingsRubGroupByCurrency(@AuthenticationPrincipal User user, Model model) throws ParserConfigurationException, SAXException, ParseException, IOException {
        List<SavingGroupByCurrencyContainer> allSavingsGroupByCurrencyContainerInRUB =
                savingGroupByCurrency.getListSavingGroupByCurrencyWithAllAmountInRUB(
                        savingGroupByCurrency.convertListObjectToListSavingGroupByCurrencyContainer(
                                savingsRepository
                                        .findGroupByCurrency(user.getId())),
                        currenciesCourses
                                .getCoursesFromCBR(currenciesCourses
                                        .convertListObjectToListString((List<Currency>) currencyRepository.findAll())));
        model.addAttribute("allSavingsGroupByCurrencyContainerInRUB", allSavingsGroupByCurrencyContainerInRUB);
        return "all-savings-group-by-currency";
    }
}