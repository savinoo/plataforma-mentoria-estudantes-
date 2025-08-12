package br.edu.iff.ccc.plataforma_mentoria.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/feedback")
public class FeedbackController {

    @GetMapping("/avaliar/{mentoriaId}")
    public String avaliarMentoria(@PathVariable Long mentoriaId, Model model) {
        // Lógica para verificar se o usuário participou da mentoria
        // Mentoria mentoria = mentoriaService.buscarPorId(mentoriaId);
        // boolean participou = mentoria.getMentoradoId().equals(usuarioLogado.getId());
        
        // if (!participou) {
        //     return "redirect:/";
        // }
        
        // model.addAttribute("mentoria", mentoria);
        model.addAttribute("title", "Avaliar Mentoria");
        return "feedback/avaliar";
    }
    
    @PostMapping("/avaliar")
    public String enviarAvaliacao(
            @RequestParam("mentoriaId") Long mentoriaId,
            @RequestParam("nota") Integer nota,
            @RequestParam("comentario") String comentario,
            RedirectAttributes redirectAttributes) {
        
        // Validação básica
        if (nota < 1 || nota > 5) {
            redirectAttributes.addFlashAttribute("erro", "A nota deve ser entre 1 e 5");
            return "redirect:/feedback/avaliar/" + mentoriaId;
        }
        
        // Verificar se o usuário já avaliou esta mentoria
        // boolean jaAvaliou = avaliacaoService.verificarJaAvaliou(mentoriaId, usuarioLogado.getId());
        
        // if (jaAvaliou) {
        //     redirectAttributes.addFlashAttribute("erro", "Você já avaliou esta mentoria");
        //     return "redirect:/agendamento/historico";
        // }
        
        // Lógica para salvar a avaliação
        // Avaliacao avaliacao = new Avaliacao(mentoriaId, usuarioLogado.getId(), nota, comentario);
        // avaliacaoService.salvar(avaliacao);
        
        redirectAttributes.addFlashAttribute("mensagem", "Avaliação enviada com sucesso!");
        return "redirect:/agendamento/historico";
    }
    
    @GetMapping("/minhas-avaliacoes")
    public String minhasAvaliacoes(Model model) {
        // Lógica para buscar avaliações recebidas pelo mentor
        // List<Avaliacao> avaliacoesRecebidas = avaliacaoService.buscarPorMentor(usuarioLogado.getId());
        
        // Lógica para buscar avaliações feitas pelo mentorado
        // List<Avaliacao> avaliacoesFeitas = avaliacaoService.buscarPorMentorado(usuarioLogado.getId());
        
        // model.addAttribute("avaliacoesRecebidas", avaliacoesRecebidas);
        // model.addAttribute("avaliacoesFeitas", avaliacoesFeitas);
        model.addAttribute("title", "Minhas Avaliações");
        return "feedback/minhas-avaliacoes";
    }
    
    @PostMapping("/responder")
    public String responderAvaliacao(
            @RequestParam("avaliacaoId") Long avaliacaoId,
            @RequestParam("resposta") String resposta,
            RedirectAttributes redirectAttributes) {
        
        // Verificar se a avaliação foi feita para o mentor logado
        // boolean avaliacaoDoMentor = avaliacaoService.verificarPertenceAoMentor(avaliacaoId, usuarioLogado.getId());
        
        // if (!avaliacaoDoMentor) {
        //     redirectAttributes.addFlashAttribute("erro", "Você não tem permissão para responder esta avaliação");
        //     return "redirect:/feedback/minhas-avaliacoes";
        // }
        
        // Lógica para salvar a resposta
        // avaliacaoService.responder(avaliacaoId, resposta);
        
        redirectAttributes.addFlashAttribute("mensagem", "Resposta enviada com sucesso!");
        return "redirect:/feedback/minhas-avaliacoes";
    }
}