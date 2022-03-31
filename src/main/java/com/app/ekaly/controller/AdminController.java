package com.app.ekaly.controller;

import com.app.ekaly.model.Produit;
import com.app.ekaly.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private ProduitService produitService;

    @RequestMapping("login")
    public String login() {
        return "admin/login";
    }

    @RequestMapping("upload")
    public String upload() {
        return "admin/upload";
    }

    @RequestMapping(value = "saveProduit", method = RequestMethod.POST, params = {"name", "photo", "description", "prix"})
    public String saveProduit(@RequestParam("name") String name, @RequestParam("photo") String photo, @RequestParam("description") String description, @RequestParam("prix") Integer prix) {
        produitService.saveProduit(new Produit(name, photo, prix, description));
        return "redirect:/admin/upload";
    }
}
