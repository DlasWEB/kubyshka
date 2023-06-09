package com.kubyshka.controller;

import com.kubyshka.entity.Currency;
import com.kubyshka.entity.User;
import com.kubyshka.repositories.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;

@Controller
public class CurrencyController {
    @Autowired
    private CurrencyRepository currencyRepository;

    @GetMapping("/currencies")
    public String showAllCurrencies(Model model) {
        Iterable<Currency> allCurrencies = currencyRepository.findAll();
        model.addAttribute("allCurrencies", allCurrencies);
        return "all-currencies";
    }

    @PostMapping("/currencies")
    public String saveCurrency(
            @Valid Currency currency,
            BindingResult bindingResult,
            Model model
    ) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = ControllerUtils.getErrors(bindingResult);
            model.mergeAttributes(errors);
            Iterable<Currency> allCurrencies = currencyRepository.findAll();
            model.addAttribute("allCurrencies", allCurrencies);
            return "all-currencies";
        }
        if (currencyRepository.findByName(currency.getName()) != null) {
            model.addAttribute("nameError", "Такая валюта уже есть в БД");
            Iterable<Currency> allCurrencies = currencyRepository.findAll();
            model.addAttribute("allCurrencies", allCurrencies);
            return "all-currencies";
        }
        currencyRepository.save(currency);
        return "redirect:/currencies";
    }

    @GetMapping("/currencies-edit-{id}")
    public String editCurrency(
            @PathVariable(value = "id") int id,
            Model model
    ) {
        if (!currencyRepository.existsById(id)) {
            return "redirect:/currencies";
        }
        Optional<Currency> currencyOptional = currencyRepository.findById(id);
        ArrayList<Currency> currency = new ArrayList<>();
        currencyOptional.ifPresent(currency::add);
        model.addAttribute("currency", currency);
        return "currency-edit";
    }

    @PostMapping("/currencies-edit-{id}")
    public String updateCurrency(
            @PathVariable(value = "id") int id,
            @RequestParam(name = "name", required = false) String name
    ) {
        Currency currency = currencyRepository.findById(id).orElseThrow();
        currency.setName(name);
        currencyRepository.save(currency);
        return "redirect:/currencies";
    }

    @PostMapping("/currencies-delete-{id}")
    public String deleteCurrency(
            @PathVariable(value = "id") int id
    ) {
        Currency currency = currencyRepository.findById(id).orElseThrow();
        currencyRepository.delete(currency);
        return "redirect:/currencies";
    }
}
