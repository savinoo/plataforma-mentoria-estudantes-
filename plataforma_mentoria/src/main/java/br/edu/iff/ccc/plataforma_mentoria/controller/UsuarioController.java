package br.edu.iff.ccc.plataforma_mentoria.controller;

import br.edu.iff.ccc.plataforma_mentoria.entities.Usuario;
import br.edu.iff.ccc.plataforma_mentoria.services.UsuarioService;
import jakarta.validation.Valid;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/cadastro")
    public String cadastroForm(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "usuario/cadastro";
    }

    @PostMapping("/cadastrar")
    public String cadastrar(
            @Valid @ModelAttribute("usuario") Usuario usuario,
            BindingResult result,
            @RequestParam("confirmarSenha") String confirmarSenha,
            Model model,
            RedirectAttributes redirect) {
        if (!usuario.getSenha().equals(confirmarSenha)) {
            result.rejectValue("senha", "error.usuario", "Senhas não conferem");
        }
        if (usuarioService.emailJaExiste(usuario.getEmail())) {
            result.rejectValue("email", "error.usuario", "Email já cadastrado");
        }
        if (result.hasErrors()) {
            return "usuario/cadastro";
        }
        usuarioService.criarUsuario(
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getSenha(),
                usuario.getTelefone(),
                usuario.getSobre(),
                usuario.getTipoUsuario()
        );
        redirect.addFlashAttribute("success", "Cadastro realizado com sucesso!");
        return "redirect:/usuario/login";
    }

    @GetMapping("/login")
    public String loginForm() {
        return "usuario/login";
    }
    
    @PostMapping("/login")
    public String loginProcess(@RequestParam("username") String username,
                               @RequestParam("password") String password,
                               Model model,
                               HttpSession session) {
        var opt = usuarioService.buscarPorEmail(username);
        if (opt.isPresent() && opt.get().getSenha().equals(password)) {
            session.setAttribute("usuarioLogado", opt.get());
            return "redirect:/usuario/perfil";
        }
        model.addAttribute("error", "Email ou senha inválidos.");
        return "usuario/login";
    }

    @GetMapping("/perfil")
    public String perfil(HttpSession session, Model model) {
        var usuario = (Usuario) session.getAttribute("usuarioLogado");
        if (usuario != null) {
            model.addAttribute("usuario", usuario);
            return "usuario/perfil";
        }
        return "redirect:/usuario/login";
    }

    @PostMapping("/atualizar")
    public String atualizar(
            @RequestParam("id") Long id,
            @RequestParam String nome,
            @RequestParam String email,
            @RequestParam String telefone,
            @RequestParam String sobre,
            RedirectAttributes redirect) {
        var usuOpt = usuarioService.buscarPorId(id);
        if (usuOpt.isPresent()) {
            usuarioService.atualizarUsuario(usuOpt.get(), nome, email, telefone, sobre);
            redirect.addAttribute("id", id);
            return "redirect:/usuario/perfil";
        }
        return "redirect:/usuario/cadastro";
    }

    @PostMapping("/alterar-senha")
    public String alterarSenha(
            @RequestParam("id") Long id,
            @RequestParam String novaSenha,
            @RequestParam String confirmarSenha,
            RedirectAttributes redirect,
            Model model) {
        if (!novaSenha.equals(confirmarSenha)) {
            model.addAttribute("senhaError", "Senhas não conferem");
            redirect.addAttribute("id", id);
            return "redirect:/usuario/perfil";
        }
        var usuOpt = usuarioService.buscarPorId(id);
        if (usuOpt.isPresent()) {
            usuarioService.alterarSenha(usuOpt.get(), novaSenha);
            redirect.addAttribute("id", id);
            return "redirect:/usuario/perfil";
        }
        return "redirect:/usuario/cadastro";
    }
}
