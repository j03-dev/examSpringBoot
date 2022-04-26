package com.app.ekaly.controller;

import com.app.ekaly.model.Client;
import com.app.ekaly.model.Command;
import com.app.ekaly.model.Produit;
import com.app.ekaly.service.ClientService;
import com.app.ekaly.service.CommadService;
import com.app.ekaly.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private ProduitService produitService;

    @Autowired
    private ClientService clientService;

    @Autowired
    private CommadService commadService;

    @RequestMapping("admin3")
    public String admin(Model model) {
        List<Client> listClient = clientService.ListAllClient();
        List<Produit> listProduit = produitService.ListAllProduit();
        List<Command> listCommand = commadService.ListAllCommand();

        model.addAttribute("listClient", listClient);
        model.addAttribute("listProduit", listProduit);
        model.addAttribute("listCommand", listCommand);
        return "admin/admin";
    }

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
