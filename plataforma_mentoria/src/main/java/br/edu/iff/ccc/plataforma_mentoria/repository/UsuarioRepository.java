package br.edu.iff.ccc.plataforma_mentoria.repository;

import br.edu.iff.ccc.plataforma_mentoria.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByEmail(String email);
    boolean existsByEmail(String email);
    List<Usuario> findByTipoUsuario(Usuario.TipoUsuario tipoUsuario);
}
