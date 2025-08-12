package br.edu.iff.ccc.plataforma_mentoria.controller.view;

import br.edu.iff.ccc.plataforma_mentoria.entities.Usuario;
import br.edu.iff.ccc.plataforma_mentoria.services.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/usuario")
public class UsuarioViewController {

    @Autowired
    private UsuarioService usuarioService;
    
    @GetMapping("/cadastro")
    public String telaCadastro(Model model) {
        model.addAttribute("usuario", new Usuario());
        model.addAttribute("title", "Cadastro de Usuário");
        return "usuario/cadastro";
    }
    
    @PostMapping("/cadastrar")
    public String cadastrarUsuario(@Valid Usuario usuario, BindingResult result, 
                                RedirectAttributes redirectAttributes, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("title", "Cadastro de Usuário");
            return "usuario/cadastro";
        }
        
        if (usuarioService.emailJaExiste(usuario.getEmail())) {
            model.addAttribute("erro", "Email já cadastrado");
            model.addAttribute("title", "Cadastro de Usuário");
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
        
        redirectAttributes.addFlashAttribute("mensagem", "Cadastro realizado com sucesso!");
        return "redirect:/usuario/login";
    }
    
    @GetMapping("/login")
    public String telaLogin(Model model) {
        model.addAttribute("title", "Login");
        return "usuario/login";
    }
    
    @GetMapping("/perfil")
    public String telaPerfil(Model model) {
        // Em um sistema real, buscaria o usuário da sessão
        Long usuarioId = 1L; // Simulando um usuário logado
        usuarioService.buscarPorId(usuarioId).ifPresent(usuario -> {
            model.addAttribute("usuario", usuario);
        });
        
        model.addAttribute("title", "Meu Perfil");
        return "usuario/perfil";
    }
    
    @GetMapping("/{id}")
    public String verUsuario(@PathVariable Long id, Model model) {
        return usuarioService.buscarPorId(id)
            .map(usuario -> {
                model.addAttribute("usuario", usuario);
                model.addAttribute("title", "Perfil de " + usuario.getNome());
                return "usuario/detalhes";
            })
            .orElse("redirect:/erro?mensagem=Usuário não encontrado");
    }
    
    @PostMapping("/atualizar")
    public String atualizarPerfil(@Valid Usuario usuarioForm, BindingResult result, 
                               RedirectAttributes redirectAttributes, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("title", "Meu Perfil");
            return "usuario/perfil";
        }
        
        // Em um sistema real, buscaria o usuário da sessão
        Long usuarioId = 1L; // Simulando um usuário logado
        return usuarioService.buscarPorId(usuarioId)
            .map(usuario -> {
                usuarioService.atualizarUsuario(
                    usuario,
                    usuarioForm.getNome(),
                    usuarioForm.getEmail(),
                    usuarioForm.getTelefone(),
                    usuarioForm.getSobre()
                );
                
                redirectAttributes.addFlashAttribute("mensagem", "Perfil atualizado com sucesso!");
                return "redirect:/usuario/perfil";
            })
            .orElse("redirect:/erro?mensagem=Usuário não encontrado");
    }
}