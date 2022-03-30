package com.app.ekaly.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {
    @RequestMapping("/login/admin")
    public String login(){
        return "admin/login";
    }
}
