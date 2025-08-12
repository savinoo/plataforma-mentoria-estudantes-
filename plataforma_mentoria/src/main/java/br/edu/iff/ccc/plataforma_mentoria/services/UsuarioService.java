package br.edu.iff.ccc.plataforma_mentoria.services;

import br.edu.iff.ccc.plataforma_mentoria.entities.Usuario;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    // Aqui injetaríamos o repositório com @Autowired
    // private UsuarioRepository usuarioRepository;

    public Usuario criarUsuario(String nome, String email, String senha, String telefone, 
                              String sobre, Usuario.TipoUsuario tipoUsuario) {
        Usuario usuario = new Usuario();
        usuario.setNome(nome);
        usuario.setEmail(email);
        usuario.setSenha(senha); // Em produção, usar hash
        usuario.setTelefone(telefone);
        usuario.setSobre(sobre);
        usuario.setTipoUsuario(tipoUsuario);
        usuario.setStatus(Usuario.StatusUsuario.ATIVO);
        
        // return usuarioRepository.save(usuario);
        return usuario; // Simulação
    }

    public Usuario atualizarUsuario(Usuario usuario, String nome, String email, 
                                  String telefone, String sobre) {
        usuario.setNome(nome);
        usuario.setEmail(email);
        usuario.setTelefone(telefone);
        usuario.setSobre(sobre);
        
        // return usuarioRepository.save(usuario);
        return usuario; // Simulação
    }
    
    public void alterarSenha(Usuario usuario, String novaSenha) {
        usuario.setSenha(novaSenha); // Em produção, usar hash
        // usuarioRepository.save(usuario);
    }

    public void excluirUsuario(Usuario usuario) {
        // usuarioRepository.delete(usuario);
    }

    public Optional<Usuario> buscarPorId(Long id) {
        // return usuarioRepository.findById(id);
        
        // Simulação
        if (id == 1L) {
            Usuario usuario = new Usuario();
            usuario.setId(1L);
            usuario.setNome("João Mentor");
            usuario.setEmail("joao@exemplo.com");
            usuario.setTipoUsuario(Usuario.TipoUsuario.MENTOR);
            usuario.setStatus(Usuario.StatusUsuario.ATIVO);
            return Optional.of(usuario);
        }
        return Optional.empty();
    }

    public List<Usuario> buscarTodos() {
        // return usuarioRepository.findAll();
        return List.of(); // Simulação
    }

    public List<Usuario> buscarMentores() {
        // return usuarioRepository.findByTipoUsuario(Usuario.TipoUsuario.MENTOR);
        return List.of(); // Simulação
    }
    
    public boolean emailJaExiste(String email) {
        // return usuarioRepository.existsByEmail(email);
        return false; // Simulação
    }
}