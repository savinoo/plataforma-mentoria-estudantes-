package br.edu.iff.ccc.plataforma_mentoria.controller.view;

import br.edu.iff.ccc.plataforma_mentoria.entities.Usuario;
import br.edu.iff.ccc.plataforma_mentoria.services.MentoriaService;
import br.edu.iff.ccc.plataforma_mentoria.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

@Controller
@RequestMapping("/mentoria")
public class MentoriaViewController {

    @Autowired
    private MentoriaService mentoriaService;
    
    @Autowired
    private UsuarioService usuarioService;
    
    @GetMapping("/buscar")
    public String buscarMentores(Model model) {
        model.addAttribute("mentores", usuarioService.buscarMentores());
        model.addAttribute("title", "Buscar Mentores");
        return "mentoria/buscar";
    }
    
    @GetMapping("/mentor/{id}")
    public String perfilMentor(@PathVariable Long id, Model model) {
        return usuarioService.buscarPorId(id)
            .map(mentor -> {
                if (mentor.getTipoUsuario() != Usuario.TipoUsuario.MENTOR) {
                    return "redirect:/erro?mensagem=Usuário não é um mentor";
                }
                
                model.addAttribute("mentor", mentor);
                model.addAttribute("title", "Perfil do Mentor");
                return "mentoria/perfil-mentor";
            })
            .orElse("redirect:/erro?mensagem=Mentor não encontrado");
    }
    
    @GetMapping("/solicitacoes")
    public String solicitacoesMentoria(Model model) {
        // Em um sistema real, buscaria o usuário da sessão
        Long usuarioId = 1L; // Simulando um usuário logado
        
        Optional<Usuario> usuarioOpt = usuarioService.buscarPorId(usuarioId);
        if (usuarioOpt.isPresent()) {
            Usuario usuario = usuarioOpt.get();
            
            if (usuario.getTipoUsuario() == Usuario.TipoUsuario.MENTOR) {
                model.addAttribute("solicitacoesRecebidas", 
                                 mentoriaService.buscarMentoriasPorMentor(usuario));
            }
            
            model.addAttribute("solicitacoesEnviadas", 
                             mentoriaService.buscarMentoriasPorMentorado(usuario));
        }
        
        model.addAttribute("title", "Solicitações de Mentoria");
        return "mentoria/solicitacoes";
    }
    
    @PostMapping("/solicitar/{mentorId}")
    public String solicitarMentoria(
            @PathVariable Long mentorId,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate data,
            @RequestParam @DateTimeFormat(pattern = "HH:mm") LocalTime horaInicio,
            @RequestParam @DateTimeFormat(pattern = "HH:mm") LocalTime horaFim,
            @RequestParam String assunto,
            @RequestParam String descricao,
            RedirectAttributes redirectAttributes) {
        
        // Em um sistema real, buscaria o usuário da sessão
        Long mentoradoId = 1L; // Simulando um usuário logado
        
        Optional<Usuario> mentorOpt = usuarioService.buscarPorId(mentorId);
        Optional<Usuario> mentoradoOpt = usuarioService.buscarPorId(mentoradoId);
        
        if (mentorOpt.isEmpty() || mentoradoOpt.isEmpty()) {
            redirectAttributes.addFlashAttribute("erro", "Mentor ou mentorado não encontrado");
            return "redirect:/mentoria/buscar";
        }
        
        Usuario mentor = mentorOpt.get();
        Usuario mentorado = mentoradoOpt.get();
        
        if (!mentoriaService.verificarDisponibilidade(mentor, data, horaInicio, horaFim)) {
            redirectAttributes.addFlashAttribute("erro", "O mentor não está disponível neste horário");
            return "redirect:/agendamento/agendar/" + mentorId;
        }
        
        mentoriaService.solicitarMentoria(mentorado, mentor, data, horaInicio, horaFim, assunto, descricao);
        
        redirectAttributes.addFlashAttribute("mensagem", "Solicitação de mentoria enviada com sucesso!");
        return "redirect:/mentoria/solicitacoes";
    }
    
    @PostMapping("/aprovar")
    public String aprovarMentoria(
            @RequestParam Long id,
            @RequestParam String linkReuniao,
            RedirectAttributes redirectAttributes) {
        
        return mentoriaService.buscarPorId(id)
            .map(mentoria -> {
                // Em um sistema real, verificaria se o mentor logado é o da mentoria
                
                mentoriaService.aprovarMentoria(mentoria, linkReuniao);
                
                redirectAttributes.addFlashAttribute("mensagem", "Mentoria aprovada com sucesso!");
                return "redirect:/mentoria/solicitacoes";
            })
            .orElse("redirect:/erro?mensagem=Mentoria não encontrada");
    }
    
    @PostMapping("/recusar")
    public String recusarMentoria(
            @RequestParam Long id,
            @RequestParam String motivo,
            RedirectAttributes redirectAttributes) {
        
        return mentoriaService.buscarPorId(id)
            .map(mentoria -> {
                // Em um sistema real, verificaria se o mentor logado é o da mentoria
                
                mentoriaService.recusarMentoria(mentoria, motivo);
                
                redirectAttributes.addFlashAttribute("mensagem", "Mentoria recusada com sucesso!");
                return "redirect:/mentoria/solicitacoes";
            })
            .orElse("redirect:/erro?mensagem=Mentoria não encontrada");
    }
}