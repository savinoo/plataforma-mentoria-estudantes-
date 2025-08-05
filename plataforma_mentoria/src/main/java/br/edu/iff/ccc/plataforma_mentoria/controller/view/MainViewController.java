package br.edu.iff.ccc.plataforma_mentoria.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
@RequestMapping(path="/principal")
public class MainViewController {
    @GetMapping()
    public String getHomePage() {
    return "home.html";
    }
    @GetMapping("/user/{id}")
    public String getUserById(@PathVariable("id") String id, Model model) {

        model.addAttribute("id", id);
        model.addAttribute("nome", "Nome do Usuário " + id);
        model.addAttribute("email", "usuario@exemplo.com");
        model.addAttribute("status", "Ativo");
        model.addAttribute("role", "Usuário Padrão");
        return "userDetailHome.html";
    }
    
    
}
