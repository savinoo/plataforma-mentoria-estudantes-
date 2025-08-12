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
@RequestMapping("/mentoria")
public class MentoriaController {

    @GetMapping("/buscar")
    public String buscarMentores(
            @RequestParam(value = "nome", required = false) String nome,
            @RequestParam(value = "especialidade", required = false) Long especialidadeId,
            @RequestParam(value = "disponibilidade", required = false) String disponibilidade,
            Model model) {
        
        // Lógica para buscar mentores com base nos filtros
        // List<Mentor> mentores = mentoriaService.buscarMentores(nome, especialidadeId, disponibilidade);
        // List<Especialidade> especialidades = especialidadeService.listarTodas();
        
        // model.addAttribute("mentores", mentores);
        // model.addAttribute("especialidades", especialidades);
        model.addAttribute("title", "Buscar Mentores");
        return "mentoria/buscar";
    }
    
    @GetMapping("/mentor/{id}")
    public String perfilMentor(@PathVariable Long id, Model model) {
        // Lógica para obter os dados do mentor pelo ID
        // Mentor mentor = mentoriaService.buscarMentorPorId(id);
        // List<Avaliacao> avaliacoes = avaliacaoService.buscarAvaliacoesPorMentor(id);
        
        // model.addAttribute("mentor", mentor);
        // model.addAttribute("avaliacoes", avaliacoes);
        model.addAttribute("title", "Perfil do Mentor");
        return "mentoria/perfil-mentor";
    }
    
    @GetMapping("/solicitacoes")
    public String solicitacoesMentoria(Model model) {
        // Lógica para buscar solicitações recebidas e enviadas pelo usuário logado
        // List<Solicitacao> solicitacoesRecebidas = solicitacaoService.buscarRecebidas(usuarioLogado.getId());
        // List<Solicitacao> solicitacoesEnviadas = solicitacaoService.buscarEnviadas(usuarioLogado.getId());
        
        // model.addAttribute("solicitacoesRecebidas", solicitacoesRecebidas);
        // model.addAttribute("solicitacoesEnviadas", solicitacoesEnviadas);
        model.addAttribute("title", "Solicitações de Mentoria");
        return "mentoria/solicitacoes";
    }
    
    @PostMapping("/solicitar/{mentorId}")
    public String solicitarMentoria(
            @PathVariable Long mentorId,
            @RequestParam("data") String data,
            @RequestParam("horario") String horario,
            @RequestParam("assunto") String assunto,
            @RequestParam("mensagem") String mensagem,
            RedirectAttributes redirectAttributes) {
        
        // Lógica para criar uma solicitação de mentoria
        // SolicitacaoMentoria solicitacao = new SolicitacaoMentoria(usuarioLogado.getId(), mentorId, data, horario, assunto, mensagem);
        // solicitacaoService.criar(solicitacao);
        
        redirectAttributes.addFlashAttribute("mensagem", "Solicitação de mentoria enviada com sucesso!");
        return "redirect:/mentoria/solicitacoes";
    }
    
    @PostMapping("/aprovar")
    public String aprovarSolicitacao(
            @RequestParam("id") Long solicitacaoId,
            @RequestParam(value = "linkReuniao", required = false) String linkReuniao,
            @RequestParam(value = "observacoes", required = false) String observacoes,
            RedirectAttributes redirectAttributes) {
        
        // Verificar se a solicitação pertence ao mentor logado
        // boolean pertenceAoMentor = solicitacaoService.verificarPertenceAoMentor(solicitacaoId, usuarioLogado.getId());
        
        // if (!pertenceAoMentor) {
        //     redirectAttributes.addFlashAttribute("erro", "Você não tem permissão para aprovar esta solicitação");
        //     return "redirect:/mentoria/solicitacoes";
        // }
        
        // Lógica para aprovar a solicitação
        // solicitacaoService.aprovar(solicitacaoId, linkReuniao, observacoes);
        
        redirectAttributes.addFlashAttribute("mensagem", "Solicitação aprovada com sucesso!");
        return "redirect:/mentoria/solicitacoes";
    }
    
    @PostMapping("/recusar")
    public String recusarSolicitacao(
            @RequestParam("id") Long solicitacaoId,
            @RequestParam(value = "motivo", required = false) String motivo,
            RedirectAttributes redirectAttributes) {
        
        // Verificar se a solicitação pertence ao mentor logado
        // boolean pertenceAoMentor = solicitacaoService.verificarPertenceAoMentor(solicitacaoId, usuarioLogado.getId());
        
        // if (!pertenceAoMentor) {
        //     redirectAttributes.addFlashAttribute("erro", "Você não tem permissão para recusar esta solicitação");
        //     return "redirect:/mentoria/solicitacoes";
        // }
        
        // Lógica para recusar a solicitação
        // solicitacaoService.recusar(solicitacaoId, motivo);
        
        redirectAttributes.addFlashAttribute("mensagem", "Solicitação recusada com sucesso!");
        return "redirect:/mentoria/solicitacoes";
    }
    
    @PostMapping("/cancelar")
    public String cancelarSolicitacao(
            @RequestParam("id") Long solicitacaoId,
            RedirectAttributes redirectAttributes) {
        
        // Verificar se a solicitação pertence ao usuário logado
        // boolean pertenceAoUsuario = solicitacaoService.verificarPertenceAoSolicitante(solicitacaoId, usuarioLogado.getId());
        
        // if (!pertenceAoUsuario) {
        //     redirectAttributes.addFlashAttribute("erro", "Você não tem permissão para cancelar esta solicitação");
        //     return "redirect:/mentoria/solicitacoes";
        // }
        
        // Lógica para cancelar a solicitação
        // solicitacaoService.cancelar(solicitacaoId);
        
        redirectAttributes.addFlashAttribute("mensagem", "Solicitação cancelada com sucesso!");
        return "redirect:/mentoria/solicitacoes";
    }
    
    @GetMapping("/minhas-mentorias")
    public String minhasMentorias(Model model) {
        // Lógica para buscar mentorias do usuário (como mentor ou mentorado)
        // List<Mentoria> mentoriasComoMentor = mentoriaService.buscarComoMentor(usuarioLogado.getId());
        // List<Mentoria> mentoriasComoMentorado = mentoriaService.buscarComoMentorado(usuarioLogado.getId());
        
        // model.addAttribute("mentoriasComoMentor", mentoriasComoMentor);
        // model.addAttribute("mentoriasComoMentorado", mentoriasComoMentorado);
        model.addAttribute("title", "Minhas Mentorias");
        return "mentoria/minhas_mentorias";
    }
    
    @PostMapping("/contatar/{mentorId}")
    public String contatarMentor(
            @PathVariable Long mentorId,
            @RequestParam("assunto") String assunto,
            @RequestParam("mensagem") String mensagem,
            RedirectAttributes redirectAttributes) {
        
        // Lógica para enviar mensagem ao mentor
        // mensagemService.enviar(usuarioLogado.getId(), mentorId, assunto, mensagem);
        
        redirectAttributes.addFlashAttribute("mensagem", "Mensagem enviada com sucesso!");
        return "redirect:/mentoria/mentor/" + mentorId;
    }
}