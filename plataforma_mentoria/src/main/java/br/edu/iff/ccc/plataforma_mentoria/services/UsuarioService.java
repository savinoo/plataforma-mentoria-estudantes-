package br.edu.iff.ccc.plataforma_mentoria.services;

import br.edu.iff.ccc.plataforma_mentoria.entities.Usuario;
import br.edu.iff.ccc.plataforma_mentoria.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

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
        
    return usuarioRepository.save(usuario);
    }

    public Usuario atualizarUsuario(Usuario usuario, String nome, String email, 
                                  String telefone, String sobre) {
        usuario.setNome(nome);
        usuario.setEmail(email);
        usuario.setTelefone(telefone);
        usuario.setSobre(sobre);
        
    return usuarioRepository.save(usuario);
    }
    
    public void alterarSenha(Usuario usuario, String novaSenha) {
        usuario.setSenha(novaSenha); // Em produção, usar hash
    usuarioRepository.save(usuario);
    }

    public void excluirUsuario(Usuario usuario) {
        // usuarioRepository.delete(usuario);
    }

    public Optional<Usuario> buscarPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    public List<Usuario> buscarTodos() {
    return usuarioRepository.findAll();
    }

    public List<Usuario> buscarMentores() {
    return usuarioRepository.findByTipoUsuario(Usuario.TipoUsuario.MENTOR);
    }
    
    public boolean emailJaExiste(String email) {
        return usuarioRepository.existsByEmail(email);
    }
    
    public Optional<Usuario> buscarPorEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }
}