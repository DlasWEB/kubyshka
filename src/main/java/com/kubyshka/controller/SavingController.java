package com.kubyshka.controller;

import com.kubyshka.entity.Currency;
import com.kubyshka.entity.Saving;
import com.kubyshka.entity.TypeOfSaving;
import com.kubyshka.entity.User;
import com.kubyshka.repositories.CurrencyRepository;
import com.kubyshka.repositories.SavingsRepository;
import com.kubyshka.repositories.TypeOfSavingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;

@Controller
public class SavingController {
    @Autowired
    private SavingsRepository savingsRepository;
    @Autowired
    private TypeOfSavingRepository typeOfSavingRepository;
    @Autowired
    private CurrencyRepository currencyRepository;

    @GetMapping("/savings")
    public String showAllSavings(@AuthenticationPrincipal User user, Model model) {
        Iterable<Saving> allSavings = savingsRepository.findByAuthorId(user.getId());
        model.addAttribute("allSavings", allSavings);
        Iterable<Currency> allCurrencies = currencyRepository.findAll();
        model.addAttribute("allCurrencies", allCurrencies);
        Iterable<TypeOfSaving> allTypesOfSavings = typeOfSavingRepository.findAll();
        model.addAttribute("allTypesOfSavings", allTypesOfSavings);
        return "all-savings";
    }

    @PostMapping("/savings")
    public String saveSaving(
            @AuthenticationPrincipal User user,
            @Valid Saving saving,
            BindingResult bindingResult,
            Model model
    ) {
        saving.setAuthor(user);

        if (bindingResult.hasErrors()) {
            Map<String, String> errors = ControllerUtils.getErrors(bindingResult);
            model.mergeAttributes(errors);
            Iterable<Currency> allCurrencies = currencyRepository.findAll();
            model.addAttribute("allCurrencies", allCurrencies);
            Iterable<TypeOfSaving> allTypesOfSavings = typeOfSavingRepository.findAll();
            model.addAttribute("allTypesOfSavings", allTypesOfSavings);
            Iterable<Saving> allSavings = savingsRepository.findByAuthorId(user.getId());
            model.addAttribute("allSavings", allSavings);
            return "all-savings";
        }

        savingsRepository.save(saving);
        return "redirect:/savings";

    }

    @GetMapping("/savings-edit-{id}")
    public String editSaving(
            @PathVariable(value = "id") int id,
            Model model
    ) {
        if (!savingsRepository.existsById(id)) {
            return "redirect:/savings";
        }
        Optional<Saving> savingOptional = savingsRepository.findById(id);
        ArrayList<Saving> saving = new ArrayList<>();
        savingOptional.ifPresent(saving::add);
        model.addAttribute("saving", saving);
        Iterable<Currency> allCurrencies = currencyRepository.findAll();
        model.addAttribute("allCurrencies", allCurrencies);
        Iterable<TypeOfSaving> allTypesOfSavings = typeOfSavingRepository.findAll();
        model.addAttribute("allTypesOfSavings", allTypesOfSavings);
        return "saving-edit";
    }

    @PostMapping("/savings-edit-{id}")
    public String updateCurrency(
            @PathVariable(value = "id") int id,
            @RequestParam(name = "saving_name", required = false) String saving_name,
            @RequestParam(name = "amount", required = false) int amount,
            @RequestParam(name = "currency_name", required = false) String currency_name,
            @RequestParam(name = "saving_type", required = false) String saving_type
    ) {
        Saving saving = savingsRepository.findById(id).orElseThrow();
        saving.setSaving_name(saving_name);
        saving.setAmount((int) amount);
        saving.setCurrency_name(currency_name);
        saving.setSaving_type(saving_type);
        savingsRepository.save(saving);
        return "redirect:/savings";
    }

    @PostMapping("/savings-delete-{id}")
    public String deleteSaving(
            @PathVariable(value = "id") int id
    ) {
        Saving saving = savingsRepository.findById(id).orElseThrow();
        savingsRepository.delete(saving);
        return "redirect:/savings";
    }
}
