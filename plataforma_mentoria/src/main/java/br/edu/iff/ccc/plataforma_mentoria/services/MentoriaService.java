package br.edu.iff.ccc.plataforma_mentoria.services;

import br.edu.iff.ccc.plataforma_mentoria.entities.Mentoria;
import br.edu.iff.ccc.plataforma_mentoria.entities.Usuario;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
public class MentoriaService {

    // private MentoriaRepository mentoriaRepository;
    // private UsuarioService usuarioService;

    public Mentoria solicitarMentoria(Usuario mentorado, Usuario mentor, 
                                    LocalDate data, LocalTime horaInicio, LocalTime horaFim,
                                    String assunto, String descricao) {
        Mentoria mentoria = new Mentoria();
        mentoria.setMentorado(mentorado);
        mentoria.setMentor(mentor);
        mentoria.setData(data);
        mentoria.setHoraInicio(horaInicio);
        mentoria.setHoraFim(horaFim);
        mentoria.setAssunto(assunto);
        mentoria.setDescricao(descricao);
        mentoria.setStatus(Mentoria.StatusMentoria.SOLICITADA);
        mentoria.setAvaliada(false);
        
        // return mentoriaRepository.save(mentoria);
        return mentoria; // Simulação
    }

    public Mentoria aprovarMentoria(Mentoria mentoria, String linkReuniao) {
        mentoria.setStatus(Mentoria.StatusMentoria.APROVADA);
        mentoria.setLinkReuniao(linkReuniao);
        
        // return mentoriaRepository.save(mentoria);
        return mentoria; // Simulação
    }

    public Mentoria recusarMentoria(Mentoria mentoria, String motivo) {
        mentoria.setStatus(Mentoria.StatusMentoria.RECUSADA);
        mentoria.setMotivoCancelamento(motivo);
        
        // return mentoriaRepository.save(mentoria);
        return mentoria; // Simulação
    }

    public Mentoria concluirMentoria(Mentoria mentoria) {
        mentoria.setStatus(Mentoria.StatusMentoria.CONCLUIDA);
        
        // return mentoriaRepository.save(mentoria);
        return mentoria; // Simulação
    }

    public Mentoria cancelarMentoria(Mentoria mentoria, String motivo) {
        mentoria.setStatus(Mentoria.StatusMentoria.CANCELADA);
        mentoria.setMotivoCancelamento(motivo);
        
        // return mentoriaRepository.save(mentoria);
        return mentoria; // Simulação
    }

    public List<Mentoria> buscarMentoriasPorMentor(Usuario mentor) {
        // return mentoriaRepository.findByMentor(mentor);
        return List.of(); // Simulação
    }

    public List<Mentoria> buscarMentoriasPorMentorado(Usuario mentorado) {
        // return mentoriaRepository.findByMentorado(mentorado);
        return List.of(); // Simulação
    }
    
    public Optional<Mentoria> buscarPorId(Long id) {
        // return mentoriaRepository.findById(id);
        return Optional.empty(); // Simulação
    }
    
    public boolean verificarDisponibilidade(Usuario mentor, LocalDate data, 
                                          LocalTime horaInicio, LocalTime horaFim) {
        // Lógica para verificar se o mentor está disponível no horário solicitado
        return true; // Simulação
    }
}