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
@RequestMapping("/agendamento")
public class AgendamentoController {

    @GetMapping("/calendario")
    public String calendario(Model model) {
        // Lógica para buscar agendamentos do usuário para preencher o calendário
        // List<Agendamento> agendamentos = agendamentoService.buscarPorUsuario(usuarioLogado.getId());
        
        // model.addAttribute("agendamentos", agendamentos);
        model.addAttribute("title", "Calendário de Mentorias");
        return "agendamento/calendario";
    }
    
    @GetMapping("/agendar/{mentorId}")
    public String agendar(@PathVariable Long mentorId, Model model) {
        // Lógica para buscar informações do mentor e suas disponibilidades
        // Mentor mentor = mentorService.buscarPorId(mentorId);
        // List<Disponibilidade> disponibilidades = disponibilidadeService.buscarPorMentor(mentorId);
        
        // model.addAttribute("mentor", mentor);
        // model.addAttribute("disponibilidades", disponibilidades);
        model.addAttribute("title", "Agendar Mentoria");
        return "agendamento/agendar";
    }
    
    @PostMapping("/agendar")
    public String realizarAgendamento(
            @RequestParam("mentorId") Long mentorId,
            @RequestParam("data") String data,
            @RequestParam("horarioInicio") String horarioInicio,
            @RequestParam("horarioFim") String horarioFim,
            @RequestParam("assunto") String assunto,
            @RequestParam("descricao") String descricao,
            RedirectAttributes redirectAttributes) {
        
        // Validar se o horário está disponível
        // boolean horarioDisponivel = agendamentoService.verificarDisponibilidade(mentorId, data, horarioInicio, horarioFim);
        
        // if (!horarioDisponivel) {
        //     redirectAttributes.addFlashAttribute("erro", "O horário selecionado não está mais disponível");
        //     return "redirect:/agendamento/agendar/" + mentorId;
        // }
        
        // Lógica para criar o agendamento
        // Agendamento agendamento = new Agendamento(usuarioLogado.getId(), mentorId, data, horarioInicio, horarioFim, assunto, descricao);
        // agendamentoService.criar(agendamento);
        
        redirectAttributes.addFlashAttribute("mensagem", "Mentoria agendada com sucesso!");
        return "redirect:/agendamento/historico";
    }
    
    @GetMapping("/historico")
    public String historico(Model model) {
        // Lógica para buscar histórico de agendamentos do usuário
        // List<Agendamento> agendamentosPassados = agendamentoService.buscarAgendamentosPassados(usuarioLogado.getId());
        // List<Agendamento> agendamentosFuturos = agendamentoService.buscarAgendamentosFuturos(usuarioLogado.getId());
        
        // model.addAttribute("agendamentosPassados", agendamentosPassados);
        // model.addAttribute("agendamentosFuturos", agendamentosFuturos);
        model.addAttribute("title", "Histórico de Mentorias");
        return "agendamento/historico";
    }
    
    @PostMapping("/cancelar")
    public String cancelarAgendamento(
            @RequestParam("agendamentoId") Long agendamentoId,
            @RequestParam(value = "motivo", required = false) String motivo,
            RedirectAttributes redirectAttributes) {
        
        // Verificar se o agendamento pertence ao usuário logado
        // boolean pertenceAoUsuario = agendamentoService.verificarPertenceAoUsuario(agendamentoId, usuarioLogado.getId());
        
        // if (!pertenceAoUsuario) {
        //     redirectAttributes.addFlashAttribute("erro", "Você não tem permissão para cancelar este agendamento");
        //     return "redirect:/agendamento/historico";
        // }
        
        // Lógica para cancelar o agendamento
        // agendamentoService.cancelar(agendamentoId, motivo);
        
        redirectAttributes.addFlashAttribute("mensagem", "Agendamento cancelado com sucesso!");
        return "redirect:/agendamento/historico";
    }
    
    @PostMapping("/reagendar")
    public String reagendarMentoria(
            @RequestParam("agendamentoId") Long agendamentoId,
            @RequestParam("novaData") String novaData,
            @RequestParam("novoHorarioInicio") String novoHorarioInicio,
            @RequestParam("novoHorarioFim") String novoHorarioFim,
            RedirectAttributes redirectAttributes) {
        
        // Verificar se o agendamento pertence ao usuário logado
        // boolean pertenceAoUsuario = agendamentoService.verificarPertenceAoUsuario(agendamentoId, usuarioLogado.getId());
        
        // if (!pertenceAoUsuario) {
        //     redirectAttributes.addFlashAttribute("erro", "Você não tem permissão para reagendar este agendamento");
        //     return "redirect:/agendamento/historico";
        // }
        
        // Validar se o novo horário está disponível
        // Agendamento agendamento = agendamentoService.buscarPorId(agendamentoId);
        // boolean horarioDisponivel = agendamentoService.verificarDisponibilidade(
        //     agendamento.getMentorId(), novaData, novoHorarioInicio, novoHorarioFim);
        
        // if (!horarioDisponivel) {
        //     redirectAttributes.addFlashAttribute("erro", "O horário selecionado não está disponível");
        //     return "redirect:/agendamento/historico";
        // }
        
        // Lógica para reagendar a mentoria
        // agendamentoService.reagendar(agendamentoId, novaData, novoHorarioInicio, novoHorarioFim);
        
        redirectAttributes.addFlashAttribute("mensagem", "Mentoria reagendada com sucesso!");
        return "redirect:/agendamento/historico";
    }
}
