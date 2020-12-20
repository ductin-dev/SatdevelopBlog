package com.satellite.myblog.controller;

import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    //HOME ============================================
    @GetMapping({"/", "/index"})
    public String Home(Model model) {
        return "index";
    }

}
