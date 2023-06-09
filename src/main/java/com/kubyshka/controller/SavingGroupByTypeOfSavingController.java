package com.kubyshka.controller;

import com.kubyshka.entity.Currency;
import com.kubyshka.entity.Saving;
import com.kubyshka.entity.SavingGroupByTypeOfSavingContainer;
import com.kubyshka.entity.User;
import com.kubyshka.repositories.CurrencyRepository;
import com.kubyshka.repositories.SavingsRepository;
import com.kubyshka.service.CurrenciesCourses;
import com.kubyshka.service.SavingGroupByTypeOfSaving;
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
import java.util.Map;

@Controller
public class SavingGroupByTypeOfSavingController {
    @Autowired
    private CurrenciesCourses currenciesCourses;
    @Autowired
    private SavingsRepository savingsRepository;
    @Autowired
    private SavingGroupByTypeOfSaving savingGroupByTypeOfSaving;
    @Autowired
    private CurrencyRepository currencyRepository;

    @RequestMapping("/savings-group-by-type-of-saving")
    public String showAllSavingsGroupByTypeOfSaving(@AuthenticationPrincipal User user, Model model) throws ParserConfigurationException, SAXException, ParseException, IOException {
        Map<SavingGroupByTypeOfSavingContainer, Integer> collectSavingGroupByTypeOfSavingContainerList =
                savingGroupByTypeOfSaving.getMapSavingGroupByTypeOfSavingContainer(
                        savingGroupByTypeOfSaving.getListSavingGroupByTypeOfSavingContainer(
                                currenciesCourses.getListSavingWithAllAmountInRUB(
                                        (List<Saving>) savingsRepository.findByAuthorId(user.getId()),
                                        currenciesCourses.getCoursesFromCBR(
                                                currenciesCourses.convertListObjectToListString(
                                                        (List<Currency>) currencyRepository.findAll())))
                        ));
        model.addAttribute("collectSavingGroupByTypeOfSavingContainerList", collectSavingGroupByTypeOfSavingContainerList);
        return "all-savings-group-by-type-of-saving";
    }
}
