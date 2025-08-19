package br.edu.iff.ccc.plataforma_mentoria.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;
import java.time.LocalDate;
import java.time.LocalTime;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Mentoria {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "mentor_id")
    private Usuario mentor;
    
    @ManyToOne
    @JoinColumn(name = "mentorado_id")
    private Usuario mentorado;
    
    private LocalDate data;
    
    private LocalTime horaInicio;
    
    private LocalTime horaFim;
    
    private String assunto;
    
    private String descricao;
    
    private String linkReuniao;
    
    @Enumerated(EnumType.STRING)
    private StatusMentoria status;
    
    private String motivoCancelamento;
    
    private boolean avaliada;
    
    public enum StatusMentoria {
        SOLICITADA, APROVADA, RECUSADA, CONCLUIDA, CANCELADA
    }
}