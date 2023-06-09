package com.kubyshka.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login(@RequestParam(value = "error", defaultValue = "false") boolean loginError, Model model) {
        if (loginError) {
            model.addAttribute("loginError", "Логин и/или Пароль не правильные");
        }
        return "login";
    }
}
