package com.app.ekaly.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ClientController {
    @RequestMapping("/")
    public String index(Model model){
        model.addAttribute("id", 1);
        return "index";
    }

}
