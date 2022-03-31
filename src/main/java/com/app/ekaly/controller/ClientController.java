package com.app.ekaly.controller;

import com.app.ekaly.model.Client;
import com.app.ekaly.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;

@Controller
public class ClientController {
    @Autowired
    private ClientService clientService;

    // afficher touts les produits dans la base de donne
    // et afficher l'utilisateur courant, s'il est deja connecte
    @RequestMapping("/")
    public String home(Model model, HttpSession session) {
        String user = (String) session.getAttribute("user");
        if (user != null) {
            model.addAttribute("user", user);
        }
        return "index";
    }

    @RequestMapping("/login")
    public String login() {
        return "user/login";
    }

    @RequestMapping(value = "/auth", method = RequestMethod.POST, params = {"email", "password"})
    public String auth(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session) {
        Client auth_client = clientService.getClientByEmail(email);
        if (auth_client.getPassword().equals(password)) {
            session.setAttribute("user", email);
            return "redirect:/";
        } else {
            return signup();
        }
    }

    @RequestMapping("/signup")
    public String signup() {
        return "user/signup";
    }

    @RequestMapping(value = "/saveUser", method = RequestMethod.POST, params = {"username", "email", "password"})
    public String saveUser(@RequestParam("username") String username, @RequestParam("email") String email, @RequestParam("password") String password) {
        clientService.saveClient(new Client(username, email, password, LocalDate.now()));

        return "user/login";
    }


}
