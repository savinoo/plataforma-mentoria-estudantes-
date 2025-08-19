package br.edu.iff.ccc.plataforma_mentoria.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        // Delegate to MainViewController for the principal route
        return "redirect:/principal";
    }
    
    @GetMapping("/sobre")
    public String sobre(Model model) {
        model.addAttribute("title", "Sobre Nós");
        return "sobre";
    }
    
    @PostMapping("/contato")
    public String enviarContato(
            @RequestParam("nome") String nome,
            @RequestParam("email") String email,
            @RequestParam("assunto") String assunto,
            @RequestParam("mensagem") String mensagem,
            RedirectAttributes redirectAttributes) {
        
        // Lógica para salvar o contato ou enviar e-mail
        // contatoService.enviar(nome, email, assunto, mensagem);
        
        redirectAttributes.addFlashAttribute("mensagemContato", "Mensagem enviada com sucesso! Entraremos em contato em breve.");
        return "redirect:/sobre#contato";
    }
}