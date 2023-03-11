package com.kubyshka;

import com.kubyshka.entity.Saving;
import com.kubyshka.repositories.SavingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class MainController {
    @Autowired
    private SavingRepository savingRepository;

    @GetMapping
    public String main(Map<String, Object> model) {
        Iterable<Saving> savings = savingRepository.findAll();
        model.put("savings", savings);
        return "main";
    }

    @PostMapping
    public String addSaving(@RequestParam String saving_name,
                            @RequestParam Float amount,
                            @RequestParam String currency_name,
                            @RequestParam String saving_type,
                            Map<String, Object> model) {
        Saving saving = new Saving(saving_name, amount, currency_name, saving_type);
        savingRepository.save(saving);
        Iterable<Saving> savings = savingRepository.findAll();
        model.put("savings", savings);

        return "main";
    }
}