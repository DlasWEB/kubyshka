package com.kubyshka.controller;

import com.kubyshka.entity.TypeOfSaving;
import com.kubyshka.repositories.TypeOfSavingRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
public class TypeOfSavingController {
    @Autowired
    private TypeOfSavingRepository typeOfSavingRepository;

    @GetMapping("/types-of-savings")
    public String showAllTypesOfSavings(Model model) {
        Iterable<TypeOfSaving> allTypesOfSavings = typeOfSavingRepository.findAll();
        model.addAttribute("allTypesOfSavings", allTypesOfSavings);
        return "all-types-of-savings";
    }

    @PostMapping("/types-of-savings")
    public String saveTypeOfSaving(
            @Valid TypeOfSaving typeOfSaving,
            BindingResult bindingResult,
            Model model
    ) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = ControllerUtils.getErrors(bindingResult);
            model.mergeAttributes(errors);
            Iterable<TypeOfSaving> allTypesOfSavings = typeOfSavingRepository.findAll();
            model.addAttribute("allTypesOfSavings", allTypesOfSavings);
            return "all-types-of-savings";
        }
        if (typeOfSavingRepository.findByName(typeOfSaving.getName()) != null) {
            model.addAttribute("nameError", "Такой тип сбережения уже есть в БД");
            Iterable<TypeOfSaving> allTypesOfSavings = typeOfSavingRepository.findAll();
            model.addAttribute("allTypesOfSavings", allTypesOfSavings);
            return "all-currencies";
        }
        typeOfSavingRepository.save(typeOfSaving);
        return "redirect:/types-of-savings";
    }

    @GetMapping("/type-of-saving-edit-{id}")
    public String editTypeOfSaving(
            @PathVariable(value = "id") int id,
            Model model
    ) {
        if (!typeOfSavingRepository.existsById(id)) {
            return "redirect:/types-of-savings";
        }
        Optional<TypeOfSaving> typeOfSavingOptional = typeOfSavingRepository.findById(id);
        ArrayList<TypeOfSaving> typeOfSaving = new ArrayList<>();
        typeOfSavingOptional.ifPresent(typeOfSaving::add);
        model.addAttribute("typeOfSaving", typeOfSaving);
        return "type-of-saving-edit";
    }

    @PostMapping("/type-of-saving-edit-{id}")
    public String updateCurrency(
            @PathVariable(value = "id") int id,
            @RequestParam(name = "name", required = false) String name
    ) {
        TypeOfSaving typeOfSaving = typeOfSavingRepository.findById(id).orElseThrow();
        typeOfSaving.setName(name);
        typeOfSavingRepository.save(typeOfSaving);
        return "redirect:/types-of-savings";
    }

    @PostMapping("/type-of-saving-delete-{id}")
    public String deleteTypeOfSaving(
            @PathVariable(value = "id") int id
    ) {
        TypeOfSaving typeOfSaving = typeOfSavingRepository.findById(id).orElseThrow();
        typeOfSavingRepository.delete(typeOfSaving);
        return "redirect:/types-of-savings";
    }
}
