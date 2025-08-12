package br.edu.iff.ccc.plataforma_mentoria.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message = "O nome não pode ser vazio")
    private String nome;
    
    @NotBlank(message = "O email não pode ser vazio")
    @Email(message = "O email deve ser válido")
    @Column(unique = true)
    private String email;
    
    @NotBlank(message = "A senha não pode ser vazia")
    private String senha;
    
    private String telefone;
    
    @NotBlank
    private String sobre;
    
    @Enumerated(EnumType.STRING)
    private TipoUsuario tipoUsuario;
    
    @Enumerated(EnumType.STRING)
    private StatusUsuario status;
    
    public enum TipoUsuario {
        MENTOR, MENTORADO
    }
    
    public enum StatusUsuario {
        ATIVO, INATIVO
    }
}