package com.kubyshka.controller;

import com.kubyshka.entity.Saving;
import com.kubyshka.entity.User;
import com.kubyshka.repositories.SavingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Set;

@Controller
public class MainController {
    @Autowired
    private SavingRepository savingRepository;

    @GetMapping("/")
    public String home(Map<String, Object> model) {
        return "home";
    }

    @GetMapping("/savings")
    public String savingPage(
            @AuthenticationPrincipal User user,
            Model model) {
        Set<Saving> savings = user.getSavings();
        model.addAttribute("savings", savings);
        return "savings";
    }

    @GetMapping("/editsavings")
    public String editSavingPage(Map<String, Object> model) {
        Iterable<Saving> savings = savingRepository.findAll();
        model.put("savings", savings);
        return "editsavings";
    }

    @RequestMapping("/updatesavings")
    public String updateSaving(Map<String, Object> model) {
        Iterable<Saving> savings = savingRepository.findAll();
        model.put("savings", savings);
        return "editsavings";
    }

    @GetMapping("/addsavings")
    public String addSavingPage(Map<String, Object> model) {
        return "addsavings";
    }

    @PostMapping("/addsavings")
    public String addSaving(
            @AuthenticationPrincipal User user,
            @RequestParam String saving_name,
            @RequestParam Float amount,
            @RequestParam String currency_name,
            @RequestParam String saving_type,
            Map<String, Object> model) {
        Saving saving = new Saving(saving_name, amount, currency_name, saving_type, user);
        savingRepository.save(saving);
        return "redirect:/savings";
    }
}