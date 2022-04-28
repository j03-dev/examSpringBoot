package com.app.ekaly.controller;

import com.app.ekaly.model.Admin;
import com.app.ekaly.model.Client;
import com.app.ekaly.model.Command;
import com.app.ekaly.model.Produit;
import com.app.ekaly.service.AdminService;
import com.app.ekaly.service.ClientService;
import com.app.ekaly.service.CommadService;
import com.app.ekaly.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
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

    @Autowired
    private AdminService adminService;

    public Boolean isAdmin(HttpSession session){
        String admin = (String) session.getAttribute("admin");
        if (admin != null){
            return true;
        }
        return false;
    }

    @RequestMapping("admin")
    public String admin(Model model, HttpSession session) {
        if (isAdmin(session)){
            List<Client> listClient = clientService.ListAllClient();
            List<Produit> listProduit = produitService.ListAllProduit();
            List<Command> listCommand = commadService.ListAllCommand();

            model.addAttribute("listClient", listClient);
            model.addAttribute("listProduit", listProduit);
            model.addAttribute("listCommand", listCommand);
            return "admin/admin";
        }
        return "redirect:/admin/login";
    }

    @RequestMapping(value = "deleteClient", method = RequestMethod.POST, params = {"id_client"})
    public String deleteClient(@RequestParam("id_client") Long id, HttpSession session) {
        if (isAdmin(session)){
            clientService.deleteClient(id);
            return "redirect:/admin/admin";
        }
        return "redirect:/admin/login";

    }

    @RequestMapping(value = "deleteProduit", method = RequestMethod.POST, params = {"id_produit"})
    public String deleteProduit(@RequestParam("id_produit") Long id, HttpSession session) {
        if (isAdmin(session)){
            produitService.deleteProduit(id);
            return "redirect:/admin/admin";
        }
        return "redirect:/admin/login";

    }

    @RequestMapping(value = "deleteCommand", method = RequestMethod.POST, params = {"id_command"})
    public String deleteCommand(@RequestParam("id_command") Long id, HttpSession session) {
        if (isAdmin(session)){
            commadService.deleteCommand(id);
            return "redirect:/admin/admin";
        }
        return "redirect:/admin/login";
    }

    @RequestMapping("login")
    public String login() {
        return "admin/login";
    }

    @RequestMapping(value = "auth", method = RequestMethod.POST, params = {"username", "password"})
    public String auth(@RequestParam("username") String username, @RequestParam("password") String password, HttpSession session){
        Admin admin = adminService.getAdminByUsername(username);
        if (admin != null){
            if (admin.getPassword().equals(password)){
                session.setAttribute("admin", username);
                return "redirect:/admin/admin";
            }
        }
        return "redirect:/admin/login";
    }

    @RequestMapping("upload")
    public String upload(HttpSession session) {
        if (isAdmin(session)){
            return "admin/upload";
        }
        return "redirect:/admin/login";
    }

    @RequestMapping(value = "saveProduit", method = RequestMethod.POST, params = {"name", "photo", "description", "prix"})
    public String saveProduit(@RequestParam("name") String name, @RequestParam("photo") String photo, @RequestParam("description") String description, @RequestParam("prix") Integer prix, HttpSession session) {
        if (isAdmin(session)){
            produitService.saveProduit(new Produit(name, "/photo/" + photo, prix, description));
            return "redirect:/admin/upload";
        }
        return "redirect:/admin/login";
    }
}
