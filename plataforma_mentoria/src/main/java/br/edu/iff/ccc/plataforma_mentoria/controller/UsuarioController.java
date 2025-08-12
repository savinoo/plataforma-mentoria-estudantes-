package br.edu.iff.ccc.plataforma_mentoria.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    @GetMapping("/cadastro")
    public String telaCadastro(Model model) {
        model.addAttribute("title", "Cadastro de Usuário");
        return "usuario/cadastro";
    }
    
    @PostMapping("/cadastrar")
    public String cadastrarUsuario(
            @RequestParam("nome") String nome,
            @RequestParam("email") String email,
            @RequestParam("senha") String senha,
            @RequestParam("confirmarSenha") String confirmarSenha,
            @RequestParam("telefone") String telefone,
            @RequestParam("tipoPerfil") String tipoPerfil,
            @RequestParam(value = "termos", required = false) Boolean termos,
            RedirectAttributes redirectAttributes) {
        
        // Validação básica
        if (!senha.equals(confirmarSenha)) {
            redirectAttributes.addFlashAttribute("erro", "As senhas não coincidem");
            return "redirect:/usuario/cadastro";
        }
        
        if (termos == null || !termos) {
            redirectAttributes.addFlashAttribute("erro", "Você deve aceitar os termos e condições");
            return "redirect:/usuario/cadastro";
        }
        
        // Lógica para salvar o usuário no banco de dados
        // UsuarioService.salvar(new Usuario(nome, email, senha, telefone, tipoPerfil));
        
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
        // Aqui você adicionaria a lógica para obter os dados do usuário logado
        model.addAttribute("title", "Meu Perfil");
        return "usuario/perfil";
    }
    
    @PostMapping("/atualizar")
    public String atualizarPerfil(
            @RequestParam("nome") String nome,
            @RequestParam("email") String email,
            @RequestParam("telefone") String telefone,
            @RequestParam("sobre") String sobre,
            RedirectAttributes redirectAttributes) {
        
        // Lógica para atualizar os dados do usuário no banco de dados
        // UsuarioService.atualizar(usuarioLogado.getId(), nome, email, telefone, sobre);
        
        redirectAttributes.addFlashAttribute("mensagem", "Perfil atualizado com sucesso!");
        return "redirect:/usuario/perfil";
    }
    
    @PostMapping("/alterar-senha")
    public String alterarSenha(
            @RequestParam("senhaAtual") String senhaAtual,
            @RequestParam("novaSenha") String novaSenha,
            @RequestParam("confirmarSenha") String confirmarSenha,
            RedirectAttributes redirectAttributes) {
        
        // Validação básica
        if (!novaSenha.equals(confirmarSenha)) {
            redirectAttributes.addFlashAttribute("erro", "As senhas não coincidem");
            return "redirect:/usuario/perfil";
        }
        
        // Verificar se a senha atual está correta
        // boolean senhaCorreta = UsuarioService.verificarSenha(usuarioLogado.getId(), senhaAtual);
        
        // if (!senhaCorreta) {
        //     redirectAttributes.addFlashAttribute("erro", "Senha atual incorreta");
        //     return "redirect:/usuario/perfil";
        // }
        
        // Lógica para alterar a senha do usuário
        // UsuarioService.alterarSenha(usuarioLogado.getId(), novaSenha);
        
        redirectAttributes.addFlashAttribute("mensagem", "Senha alterada com sucesso!");
        return "redirect:/usuario/perfil";
    }
    
    @PostMapping("/adicionar-especialidade")
    public String adicionarEspecialidade(
            @RequestParam("nome") String nome,
            @RequestParam("descricao") String descricao,
            RedirectAttributes redirectAttributes) {
        
        // Lógica para adicionar especialidade ao mentor
        // EspecialidadeService.adicionar(usuarioLogado.getId(), nome, descricao);
        
        redirectAttributes.addFlashAttribute("mensagem", "Especialidade adicionada com sucesso!");
        return "redirect:/usuario/perfil";
    }
    
    @PostMapping("/adicionar-disponibilidade")
    public String adicionarDisponibilidade(
            @RequestParam("diaSemana") String diaSemana,
            @RequestParam("horaInicio") String horaInicio,
            @RequestParam("horaFim") String horaFim,
            RedirectAttributes redirectAttributes) {
        
        // Lógica para adicionar disponibilidade ao mentor
        // DisponibilidadeService.adicionar(usuarioLogado.getId(), diaSemana, horaInicio, horaFim);
        
        redirectAttributes.addFlashAttribute("mensagem", "Disponibilidade adicionada com sucesso!");
        return "redirect:/usuario/perfil";
    }
    
    @GetMapping("/esqueci-senha")
    public String telaEsqueciSenha(Model model) {
        model.addAttribute("title", "Recuperar Senha");
        return "usuario/esqueci-senha";
    }
    
    @PostMapping("/recuperar-senha")
    public String recuperarSenha(
            @RequestParam("email") String email,
            RedirectAttributes redirectAttributes) {
        
        // Verificar se o email existe
        // boolean emailExiste = UsuarioService.verificarEmail(email);
        
        // if (!emailExiste) {
        //     redirectAttributes.addFlashAttribute("erro", "Email não encontrado");
        //     return "redirect:/usuario/esqueci-senha";
        // }
        
        // Lógica para enviar email de recuperação de senha
        // UsuarioService.enviarEmailRecuperacao(email);
        
        redirectAttributes.addFlashAttribute("mensagem", "Email de recuperação enviado com sucesso!");
        return "redirect:/usuario/login";
    }
}