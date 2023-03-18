package com.mdrsolutions.springbootprod.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @Autowired
    private Environment env;

    @Value("${corporate.name}")
    private String corporateName;

    @Value("${logo.title}")
    private String logoTitle;

    @GetMapping({"/", "/index"})
    public String welcomePage(Model model){
        model.addAttribute("environments", env.getActiveProfiles());
        model.addAttribute("corporateName", corporateName);
        model.addAttribute("logoTitle", logoTitle);

        return "index";
    }
}
